package com.example.bumi_sultan.home.pertemuan12

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.bumi_sultan.R
import com.example.bumi_sultan.data.api.NoteApiClient
import com.example.bumi_sultan.data.model.NoteModel
import com.example.bumi_sultan.databinding.ActivitySupabaseBinding
import kotlinx.coroutines.launch

class SupabaseActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySupabaseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySupabaseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            title = "Supabase Note CRUD"
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_arrow_back)
        }

        loadNotes()

        binding.btnAddNote.setOnClickListener {
            val title = binding.etTitle.text.toString().trim()
            val content = binding.etContent.text.toString().trim()

            if (title.isNotEmpty() && content.isNotEmpty()) {
                addNewNote(title, content)
            } else {
                Toast.makeText(this, "Judul dan Isi tidak boleh kosong", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnRefreshNotes.setOnClickListener {
            loadNotes()
        }
    }

    private fun loadNotes() {
        lifecycleScope.launch {
            try {
                binding.tvNotesResult.text = "Memuat data dari Supabase..."
                val notes = NoteApiClient.apiService.getNotes()
                if (notes.isEmpty()) {
                    binding.tvNotesResult.text = "Belum ada catatan di Supabase."
                } else {
                    val sb = StringBuilder()
                    for (note in notes) {
                        sb.append("ID: ${note.id}\n")
                        sb.append("Judul: ${note.title}\n")
                        sb.append("Isi: ${note.content}\n")
                        sb.append("Status: ${note.status ?: "To Do"}\n")
                        sb.append("-----------------------------------\n")
                    }
                    binding.tvNotesResult.text = sb.toString()
                }
            } catch (e: Exception) {
                binding.tvNotesResult.text = "Gagal memuat data: ${e.message}"
            }
        }
    }

    private fun addNewNote(title: String, content: String) {
        lifecycleScope.launch {
            try {
                val newNote = NoteModel(id = null, title = title, content = content, status = "To Do", created_at = null)
                NoteApiClient.apiService.addNote(newNote)
                Toast.makeText(this@SupabaseActivity, "Berhasil menambah catatan!", Toast.LENGTH_SHORT).show()
                binding.etTitle.text?.clear()
                binding.etContent.text?.clear()
                loadNotes()
            } catch (e: Exception) {
                Toast.makeText(this@SupabaseActivity, "Gagal menambah: ${e.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressedDispatcher.onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
