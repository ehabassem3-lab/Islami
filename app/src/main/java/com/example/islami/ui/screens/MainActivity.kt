package com.example.islami.ui.screens

import androidx.fragment.app.Fragment;
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.islami.R
import com.example.islami.databinding.ActivityMainBinding
import com.example.islami.ui.screens.fragments.hadeth.HadethFragment
import com.example.islami.ui.screens.fragments.quran.QuranFragment
import com.example.islami.ui.screens.fragments.radio.RadioFragment
import com.example.islami.ui.screens.fragments.sebha.SebhaFragment


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding : ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        FragmentsController(QuranFragment())
        binding.BottomBar.setOnItemSelectedListener { item ->
          when(item.itemId){
              R.id.QuranTab -> FragmentsController(QuranFragment())
              R.id.Hadehtab -> FragmentsController(HadethFragment())
              R.id.SebhaTab -> FragmentsController(SebhaFragment())
              R.id.RadioTab -> FragmentsController(RadioFragment())
          }


           return@setOnItemSelectedListener true
        }


    }

    fun FragmentsController( fragment : Fragment ){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.FragmentsContainer,fragment)
            .addToBackStack("")
            .commit()

    }
}