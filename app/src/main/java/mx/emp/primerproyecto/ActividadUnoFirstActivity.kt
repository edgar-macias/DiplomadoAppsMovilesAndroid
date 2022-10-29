package mx.emp.primerproyecto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import models.Usuario

class ActividadUnoFirstActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actividad_uno_first)

        val etName = findViewById<EditText>(R.id.name)
        val etLastName = findViewById<EditText>(R.id.last_name)
        val etAge = findViewById<EditText>(R.id.age)
        val btnSend = findViewById<Button>(R.id.btn_send)

        btnSend.setOnClickListener{
            val exceptionText:String? = when {
                etName.text.isEmpty() -> "El campo Nombre no puede ser vacio"
                etLastName.text.isEmpty() -> "El campo Apellido no puede ser vacio"
                etAge.text.isEmpty() -> "El campo edad no puede ser vacio"
                else -> null
            }

            if(exceptionText===null){
                val usuario = Usuario("${etName.text}","${etLastName.text}",Integer.parseInt(etAge.text.toString()))
                val intent = Intent(this,ActividadUnoSecondActivity::class.java).apply {
                    putExtra("KEY_USER_DATA",usuario)
                }
                startActivity(intent)
            } else {
                isEmptyForm(exceptionText)
            }
        }
    }

    private fun isEmptyForm(infoText:String){
        Toast.makeText(this,infoText,Toast.LENGTH_SHORT).show()
    }

}