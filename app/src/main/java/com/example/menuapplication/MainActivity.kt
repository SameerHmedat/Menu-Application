package com.example.menuapplication
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.menuapplication.fragment.LanguagesFragment
import com.example.menuapplication.fragment.LoginFragment
import com.example.menuapplication.fragment.ModeFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var toogle:ActionBarDrawerToggle
    private val loginFragment=LoginFragment()
    private val languagesFragment=LanguagesFragment()
    private val modeFragment=ModeFragment()




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       replaceFragment(loginFragment)

        setTitle(R.string.app_name) //Set Title Of Your App Languages support
        toogle= ActionBarDrawerToggle(this,drawLayout,R.string.Open,R.string.Close)
        drawLayout.addDrawerListener(toogle)
        toogle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        navView.setNavigationItemSelectedListener {
            when(it.itemId){

                R.id.mihome ->
                {
                    replaceFragment(loginFragment)
                }
                R.id.miLang ->
                {
                    replaceFragment(languagesFragment)
                }
                R.id.miTheme ->
                {
                    replaceFragment(modeFragment)
                }
                R.id.miFinish ->
                {
                    finish()
                }
            }
            true
        }



    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toogle.onOptionsItemSelected(item))
        {
            return true
        }
        return super.onOptionsItemSelected(item)
    }


    private fun replaceFragment(fragment: Fragment)
    {
        val transaction=supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frameLayoutContainer,fragment)
        transaction.commit()
    }



}