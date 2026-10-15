package com.example.bumi_sultan

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.bumi_sultan.databinding.ActivityBaseBinding
import com.example.bumi_sultan.home.HomeFragment
import com.example.bumi_sultan.message.MessageFragment
import com.example.bumi_sultan.more.MoreFragment

class BaseActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBaseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityBaseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, 0)
            insets
        }

        /* FragmentHome sebagai fragment default */
        replaceFragment(HomeFragment())

        binding.bottomNavView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    Toast.makeText(this, "Home click", Toast.LENGTH_SHORT).show()
                    replaceFragment(HomeFragment())
                    true
                }
                R.id.message -> {
                    Toast.makeText(this, "message click", Toast.LENGTH_SHORT).show()

                    replaceFragment(MessageFragment())
                    true
                }
                R.id.more -> {
                    Toast.makeText(this, "more click", Toast.LENGTH_SHORT).show()
                    replaceFragment(MoreFragment())
                    true
                }
                else -> false
            }
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(binding.fragmentContainer.id, fragment)
            .commit()
    }
}