package com.example.menuapplication.fragment

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_YES
import androidx.fragment.app.Fragment
import com.example.menuapplication.R
import kotlinx.android.synthetic.main.fragment_mode.*
import java.util.*

class ModeFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mode, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnDark.setOnClickListener {

           AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_YES)
            changeLanguages(LAST_UPDATE)
        }
        btnLight.setOnClickListener {
           AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            changeLanguages(LAST_UPDATE)
        }

        btnDefault.setOnClickListener {
            AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_FOLLOW_SYSTEM)
            changeLanguages(LAST_UPDATE)
        }

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        changeLanguages(LAST_UPDATE)
    }

        //unNecessary Bro
    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        changeLanguages(LAST_UPDATE)

    }

    private fun changeLanguages(lan:String){
        val locale = Locale(lan)
        Locale.setDefault(locale)
        val config = Configuration()
        config.locale = locale
        requireContext().resources.updateConfiguration(
            config,
            requireContext().resources.displayMetrics
        )
    }

}