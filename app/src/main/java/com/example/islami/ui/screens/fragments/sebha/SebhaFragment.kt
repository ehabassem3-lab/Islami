package com.example.islami.ui.screens.fragments.sebha

import android.media.Image
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.islami.R
import com.example.islami.databinding.FragmentSebhaBinding


class SebhaFragment : Fragment() {
    lateinit var sebhaZekr: TextView
    lateinit var sebhaNumber: TextView
    lateinit var sebhaImage: ImageView
    lateinit var sebhaLayout: ConstraintLayout
    var counter: Int = 0
    var type = arrayListOf<String>(" استغفر الله ", "لا اله الا الله ", "سبحان الله")


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sebha, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        sebhaZekr = activity!!.findViewById(R.id.Sebha_Zekr_type)
        sebhaNumber = activity!!.findViewById(R.id.Sebha_Zekr_Number)
        sebhaImage = activity!!.findViewById(R.id.Sebha)
        sebhaLayout = activity!!.findViewById(R.id.Sebha_Layout)
        sebhaZekr.text = type[0]
        sebhaNumber.text = counter.toString()
        super.onViewCreated(view, savedInstanceState)
        sebhaOnClick()


    }

    fun sebhaOnClick() {

        sebhaLayout.setOnClickListener {
            sebhaImage.setOnClickListener { view ->
                view.animate()
                    .rotationBy(20f)
                    .setDuration(300)
                    .start()
                counter++
                sebhaNumber.text = counter.toString()
                Log.e("counter", counter.toString())
                if (counter <= 30 ){
                    sebhaZekr.text = type[0]
                    sebhaNumber.text = counter.toString()
                }
               else  if (counter <= 60 ){
                    sebhaZekr.text = type[1]
                    sebhaNumber.text = counter.toString()
                }
                else  if (counter <= 90 ){
                    sebhaZekr.text = type[2]
                    sebhaNumber.text = counter.toString()
                }

                if (counter == 90 ){
                    counter = 0
                    sebhaZekr.text = type[0]
                    sebhaNumber.text = counter.toString()


                    return@setOnClickListener
                }



            }


        }


    }
}