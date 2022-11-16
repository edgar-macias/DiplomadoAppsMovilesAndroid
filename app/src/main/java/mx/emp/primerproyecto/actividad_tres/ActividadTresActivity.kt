package mx.emp.primerproyecto.actividad_tres

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import mx.emp.primerproyecto.actividad_tres.ui.AnimalListDosFragment
import mx.emp.primerproyecto.R

class ActividadTresActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actividad_tres)

        supportFragmentManager.beginTransaction()
            .add(R.id.actividadTresContainer,AnimalListDosFragment()).commit()
    }
}