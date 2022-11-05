package mx.emp.primerproyecto.layouts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayout
import mx.emp.primerproyecto.R

class TapsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_taps)

        val taps = findViewById<TabLayout>(R.id.taps)

        taps.addTab(taps.newTab().setText("Football"))
        taps.addTab(taps.newTab().setText("Basquetball"))
        taps.addTab(taps.newTab().setText("Tennis"))
        taps.tabGravity = TabLayout.GRAVITY_START
    }
}