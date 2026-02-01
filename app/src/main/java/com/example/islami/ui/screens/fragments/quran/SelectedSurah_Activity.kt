package com.example.islami.ui.screens.fragments.quran

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.islami.databinding.SelectedSurahBinding
import com.example.islami.ui.screens.MainActivity
import kotlin.math.log

class SelectedSurah_Activity : AppCompatActivity(){
    lateinit var binding : SelectedSurahBinding
    companion object{
        const val  SURAH_KEY = "surah"
    }
    lateinit var surah : QuranDM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         binding  = SelectedSurahBinding.inflate(layoutInflater)
        setContentView(binding.root)
        surahGetter()
        surahDetails()


        binding.backArrow.setOnClickListener { view ->
            val  intent = Intent(this, MainActivity::class.java)

            startActivity(intent)

        }

    }
    fun surahGetter(){
        surah = (
                (if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
                    intent.getSerializableExtra(SURAH_KEY, QuranDM::class.java)
                } else{
                    intent.getSerializableExtra(SURAH_KEY)  as  QuranDM


                })!!
                )

        binding.surahNameAr.text = surah.surahNameAr

        binding.surahNameEn.text = surah.surahNameEn
    }

    fun surahDetails(){
        val fileName = "quran/${surah.surahNumber}.txt"
        val surahName = assets.open(fileName)
      val lines =  surahName.reader().readLines()
        binding.SlectedSurauh.text = lines.toString()



    }

}