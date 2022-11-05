package mx.emp.primerproyecto.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import mx.emp.primerproyecto.R

class FragmentManagerActivity : AppCompatActivity() {

    val name = "Edgar Macias"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_manager)

        supportFragmentManager.beginTransaction()
            .add(R.id.container,FirstFragment.newInstance(name)).commit()
    }
}