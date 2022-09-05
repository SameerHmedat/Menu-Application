package com.example.menuapplication.fragment

import android.content.res.Configuration
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.menuapplication.R
import kotlinx.android.synthetic.main.fragment_languages.*
import java.util.*

 var LAST_UPDATE:String="en"

class LanguagesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_languages, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnArabic.setOnClickListener {
            LAST_UPDATE="ar"
            changeLanguages("ar") }

        btnEnglish.setOnClickListener {
            LAST_UPDATE="en"
           changeLanguages("en") }

        btnTurkish.setOnClickListener {
            LAST_UPDATE="tr"
            changeLanguages("tr") }


    }



    private fun changeLanguages(lan:String){
        val locale =  Locale(lan)
        Locale.setDefault(locale)
        val config = Configuration()
        locale.also { config.locale = it }
        activity?.resources?.updateConfiguration(config, activity?.resources?.displayMetrics)
        activity?.recreate()
    }


}