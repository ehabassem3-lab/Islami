package com.example.islami.ui.screens.fragments.quran

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.islami.databinding.SelectedSurahBinding

class SelectedSurah_Activity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding : SelectedSurahBinding = SelectedSurahBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

}