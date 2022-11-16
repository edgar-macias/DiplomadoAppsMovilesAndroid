package mx.emp.primerproyecto.clase3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import mx.emp.primerproyecto.R

class BottomNavigationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigation)

        loadFragment(PrimerFragment())

        val menu = findViewById<BottomNavigationView>(R.id.menu)

        menu.setOnItemSelectedListener {
            when(it.itemId){
                R.id.navigation_home->{
                    loadFragment(PrimerFragment())
                    return@setOnItemSelectedListener true
                }
                R.id.navigation_dashboard->{
                    loadFragment(SegundoFragment())
                    return@setOnItemSelectedListener true
                }
                R.id.navigation_notifications->{
                    loadFragment(TercerFragment())
                    return@setOnItemSelectedListener true
                }
                else -> return@setOnItemSelectedListener false
            }
        }
    }

    private fun loadFragment(fragment:Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.root,fragment).commit()
    }
}