package com.example.bumi_sultan.pertemuan10

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.bumi_sultan.R
import com.example.bumi_sultan.databinding.ActivityNinthBinding
import com.google.android.material.chip.Chip

class NinthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNinthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNinthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Toolbar + tombol back
        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            title = "Pertemuan 10"
            subtitle = "Input & GridLayout"
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_arrow_back)
        }

        // Deteksi Chip yang dipilih
        binding.chipGroupFilter.setOnCheckedStateChangeListener { group, checkedIds ->
            val selectedChipId = checkedIds.firstOrNull()
            if (selectedChipId != null) {
                val chip = group.findViewById<Chip>(selectedChipId)
                Toast.makeText(this, "Filter: ${chip.text}", Toast.LENGTH_SHORT).show()
            }
        }

        // Listener untuk tombol GridLayout
        binding.btnMenu1.setOnClickListener { showToast("Menu 1 diklik") }
        binding.btnMenu2.setOnClickListener { showToast("Menu 2 diklik") }
        binding.btnMenu3.setOnClickListener { showToast("Menu 3 diklik") }
        binding.btnMenu4.setOnClickListener { showToast("Menu 4 diklik") }
        binding.btnMenu5.setOnClickListener { showToast("Menu 5 diklik") }
        binding.btnMenu6.setOnClickListener { showToast("Menu 6 diklik") }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    // Aksi tombol back di toolbar
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}