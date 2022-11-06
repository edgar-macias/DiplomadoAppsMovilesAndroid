package mx.emp.primerproyecto.actividad_dos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import mx.emp.primerproyecto.R
import mx.emp.primerproyecto.actividad_dos.fragments.AnimalListFragment

class ActividadDosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actividad_dos)

        supportFragmentManager.beginTransaction()
            .add(R.id.actividadDosContainer,AnimalListFragment()).commit()
    }
}