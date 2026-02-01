package com.example.islami.ui.screens.fragments.hadeth

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.R
import kotlin.math.log

class HadethFragment : Fragment() {

  var  hadethDM: ArrayList<HadethDM> = ArrayList<HadethDM>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_hadeth, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fillHadeth()
       Log.e("ListSize",hadethDM.get(20).toString())
      var recyclerView  = activity!!.findViewById<RecyclerView>(R.id.HadethRecyclerView)
       var adapter = HadethAdapter(hadethDM)
        recyclerView.adapter = adapter

    }


    fun fillHadeth(){


        val fileName = "hadeth.txt"
        var inputStream = activity!!.assets.open(fileName)
        var title : String = ""
        var content : String = ""
        var lines = inputStream.reader().forEachLine {

            if (title.isEmpty()) {
                title = it

            }
            else {


                if (it.equals("/")) {
                    hadethDM.add(
                        HadethDM(
                            content, title
                        )
                    )
                    title = ""
                    content = ""
                    return@forEachLine
                }
                content+=it
            }



            }


        }

    }


