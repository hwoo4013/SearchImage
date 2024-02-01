package com.example.searchimage_ver2

import SearchFragment
import StorageFragment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils.replace
import androidx.fragment.app.Fragment
import com.example.searchimage_ver2.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 뷰바인딩
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imageSearch.setOnClickListener {
            showFragment(SearchFragment())
        }

        binding.imageStorage.setOnClickListener {
            showFragment(StorageFragment())
        }
    }

    private fun showFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame, fragment)
            .commit()
    }

    private fun searchImages(query: String) {

        val searchFragment = supportFragmentManager.findFragmentById(R.id.frame) as? SearchFragment
        searchFragment?.fetchImageResults(query)
        }
    }
