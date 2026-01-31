package com.example.islami.ui.screens.fragments.quran

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.R

class QuranFragment : Fragment() {
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: QuranAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_quran, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.Suras_RecyclerView)
        adapter = QuranAdapter(QuranDM.quranList)
        recyclerView.adapter = adapter
        adapter.selectedSurah = object : SelectedSurah{
            override fun surahClick(
                position: Int,
                quranDM: QuranDM
            ) {
                val intent = Intent(requireContext() , SelectedSurah_Activity::class.java)
            }

        }
    }


}