package com.example.islami.ui.screens

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.islami.R
import com.example.islami.databinding.ActivityMainBinding
import com.example.islami.ui.screens.fragments.HadethFragment
import com.example.islami.ui.screens.fragments.QuranFragment
import com.example.islami.ui.screens.fragments.RadioFragment
import com.example.islami.ui.screens.fragments.SebhaFragment


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
              R.id.SebhaTab -> {
                  Toast.makeText(this,"Under Development", Toast.LENGTH_SHORT).show();
                  return@setOnItemSelectedListener false
              }
              R.id.RadioTab ->{
                  Toast.makeText(this,"Task", Toast.LENGTH_SHORT).show();
                  return@setOnItemSelectedListener false}
          }


           return@setOnItemSelectedListener true
        }


    }

    fun FragmentsController( fragment : Fragment ){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.FragmentsContainer,fragment)
            .commit()

    }
}