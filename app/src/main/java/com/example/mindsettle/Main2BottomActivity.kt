package com.example.mindsettle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main2_bottom.*

class Main2BottomActivity : AppCompatActivity() {
    
    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item->
        when(item.itemId){
            R.id.home ->{
                //println("home pressed")
                //actionBar.title = "Home"
                replaceFragment(HomeFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.goals ->{
                //println("goals pressed")
                //supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, GoalsFragment())
                replaceFragment(GoalsFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.activities ->{
                //println("activities pressed")
                replaceFragment(ActivitiesFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.profile ->{
                //println("profile pressed")
                replaceFragment(ProfileFragment())
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2_bottom)

        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        replaceFragment(HomeFragment())
    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainer, fragment)
        fragmentTransaction.commit()
    }
}
