package com.example.islami.ui.screens.fragments.radio

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.R


class RadioFragment : Fragment() {
     var radioDM = arrayListOf<RadioDM>()
    lateinit var adapter : RadioAdapter
    lateinit var recyclerView : RecyclerView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Fillfake()


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_radio, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
         recyclerView = view.findViewById(R.id.Recycler_Radio)
        adapter = RadioAdapter(radioDM,{ Index->
           var item =  radioDM.get(Index)
            item.play_status = R.drawable.pause

        })
        recyclerView.adapter = adapter
    }

    fun Fillfake(){
        for(i in 0 until 50){
            radioDM.add(RadioDM(
                "Ehab Assem "+i,
                   R.drawable.footer,
                R.drawable.volume_on,
                R.drawable.play,
                false
            ))

        }

    }


}