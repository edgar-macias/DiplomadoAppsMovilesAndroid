package mx.emp.primerproyecto.actividad_tres.ui

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import mx.emp.primerproyecto.actividad_tres.models.AnimalSqlModel
import mx.emp.primerproyecto.actividad_tres.services.AnimalDBHelper
import mx.emp.primerproyecto.R

/**
 * A simple [Fragment] subclass.
 * Use the [AddAnimalFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddAnimalFragment : Fragment() {

    private lateinit var animalDBHelper: AnimalDBHelper

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add_animal, container, false)

        animalDBHelper = AnimalDBHelper(view.context)

        val etName:EditText = view.findViewById(R.id.name)
        val etDescription:EditText = view.findViewById(R.id.description)
        val etUrlImage:EditText = view.findViewById(R.id.urlImage)
        val checkSickness:CheckBox = view.findViewById(R.id.animalSickness)
        val rgGenero:RadioGroup = view.findViewById(R.id.rgSexo)
        val btnAgregar:Button = view.findViewById(R.id.btnAgregar)

        var selectedGenero = "S"
        var isSick = false
        rgGenero.check(R.id.sn)
        checkSickness.isChecked = isSick

        rgGenero.setOnCheckedChangeListener { _, i ->
            when(i){
                R.id.mas -> "M"
                R.id.fem -> "F"
                else -> "S"
            }.also { selectedGenero = it }
        }

        checkSickness.setOnCheckedChangeListener { _, isChecked ->
            isSick = isChecked
        }

        btnAgregar.setOnClickListener {
            val exceptionText:String? = when{
                etName.text.isEmpty() -> "El campo nombre no puede estar vacio"
                etDescription.text.isEmpty() -> "El campo descripción no puede estar vacio"
                etUrlImage.text.isEmpty() -> "La url de la imagen que sera mostrada debe ser establecida"
                else -> null
            }

            if(exceptionText === null){
                val animalSqlModel = AnimalSqlModel(name = etName.text.toString(),
                    description = etDescription.text.toString(),
                    url_image = etUrlImage.text.toString(),
                    is_sick = if(isSick) 1 else 0, gender = selectedGenero)

                animalDBHelper.insert(animalSqlModel)

                parentFragmentManager.beginTransaction()
                    .replace(R.id.actividadTresContainer,AnimalListDosFragment()).commit()
            } else {
                showEmptyInfo(view.context,exceptionText)
            }
        }

        return view
    }

    private fun showEmptyInfo(context: Context,infoText:String) {
        Toast.makeText(context,infoText, Toast.LENGTH_SHORT).show()
    }
}