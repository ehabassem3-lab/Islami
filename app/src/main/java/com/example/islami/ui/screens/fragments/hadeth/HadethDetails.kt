package com.example.islami.ui.screens.fragments.hadeth

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.islami.databinding.HadethDetailsBinding
import com.example.islami.ui.screens.MainActivity

class HadethDetails : AppCompatActivity() {
    lateinit var binding: HadethDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = HadethDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        hadethGetter()
        BackArrow()


    }

    fun BackArrow(){
        binding.backArrow.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }

    }
    fun hadethGetter(){
        val hadeth = (
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
                    intent.getSerializableExtra("Hadeth", HadethDM::class.java)

                }
                else {
                    intent.getSerializableExtra("Hadeth") as HadethDM

                }
                )
        binding.surahNameAr.text = hadeth?.title
        binding.SlectedSurauh.text = hadeth?.content
    }






}