package com.example.islami.ui.screens.fragments.quran

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.R

class QuranAdapter
    (var QuranList : ArrayList<QuranDM>)
    :
RecyclerView.Adapter<QuranAdapter.ViewHolder>()
{

    lateinit var selectedSurah: SelectedSurah
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.surah_item , parent,false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        var QuranList = QuranList[position]
        holder.surahNameEn.text = QuranList.surahNameEn
        holder.surahNameAr.text = QuranList.surahNameAr
        holder.surahNumber.text = QuranList.surahNumber.toString()
        holder.surahVerse.text = QuranList.surahVerseNumber.toString()+"   Verses  "
           holder.itemView.setOnClickListener { view->
               selectedSurah.surahClick(position,QuranList)
           }

    }


    override fun getItemCount(): Int {return QuranList.size}


    class ViewHolder(view : View) : RecyclerView.ViewHolder(view){
        var surahNameEn  : TextView = itemView.findViewById(R.id.Surah_Name_En)
        var surahNameAr  : TextView = itemView.findViewById(R.id.Surah_Name_Ar)
        var surahVerse  : TextView = itemView.findViewById(R.id.Surah_Verse)
        var surahNumber  : TextView = itemView.findViewById(R.id.Surah_number)


    }
}
