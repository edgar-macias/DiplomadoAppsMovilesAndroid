package mx.emp.primerproyecto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import models.Usuario

class ActividadUnoSecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actividad_uno_second)

        val tvName = findViewById<TextView>(R.id.name)
        val tvLastName = findViewById<TextView>(R.id.last_name)
        val tvAge = findViewById<TextView>(R.id.age)

        intent.extras?.let {
            if (it.containsKey("KEY_USER_DATA")){
                val user:Usuario = it.getSerializable("KEY_USER_DATA") as Usuario

                tvName.text = user.name
                tvLastName.text = user.lastName
                tvAge.text = "${user.age}"
            } else {
                showEmptyInfo("No hay informacion disponible del usuario")
            }
        } ?: showEmptyInfo("Extras vacio")

    }

    private fun showEmptyInfo(textInfo:String) {
        Toast.makeText(this,textInfo, Toast.LENGTH_SHORT).show()
    }
}