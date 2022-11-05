package mx.emp.primerproyecto.layouts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import mx.emp.primerproyecto.R

class RelativeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_relative)

        val cbCredit = findViewById<CheckBox>(R.id.cbCreditCard)
        val btnSend = findViewById<Button>(R.id.btnSend)
        val rgGenero = findViewById<RadioGroup>(R.id.rgGenero)

        //_ hace referencia al view del checkbox que es cbCredit
        cbCredit.setOnCheckedChangeListener { _, isChecked ->
            btnSend.isEnabled = isChecked

            Toast.makeText(this,"IsChecked: $isChecked",Toast.LENGTH_SHORT).show()
        }

        //RadioGroup
        rgGenero.check(R.id.rbFem)

        rgGenero.setOnCheckedChangeListener { _, i ->
            val selectedRB = when(i){
                R.id.rbMas -> "Masculino"
                R.id.rbFem -> "Femenino"
                else -> "Sin asignar"
            }
            Toast.makeText(this,"Selecciono: $selectedRB",Toast.LENGTH_SHORT).show()
        }

        //spinner
        val spinner =  findViewById<Spinner>(R.id.spinner)

        val datos = arrayListOf("Elemento 1","Elemento 2","Elemento 3","Elemento 4","Elemento 5")
        val adaptador = ArrayAdapter(this, android.R.layout.simple_spinner_item,datos)

        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adaptador

        spinner.onItemSelectedListener = object:AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val itemSelected = parent?.getItemAtPosition(position)

                Toast.makeText(this@RelativeActivity, "Selected: $itemSelected",Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

        btnSend.setOnClickListener {

            val selectedRB = when(rgGenero.checkedRadioButtonId){
                R.id.rbMas -> "Masculino"
                R.id.rbFem -> "Femenino"
                else -> "Sin asignar"
            }

            val itemSelectedPosition = spinner.selectedItemPosition


            Toast.makeText(this,"Genero $selectedRB\nItemSelected: ${datos[itemSelectedPosition]}\n" +
                    "isChecked:${cbCredit.isChecked}",Toast.LENGTH_SHORT).show()
        }

    }
}