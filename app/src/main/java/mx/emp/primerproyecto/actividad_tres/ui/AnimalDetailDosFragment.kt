package mx.emp.primerproyecto.actividad_tres.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.bumptech.glide.Glide
import mx.emp.primerproyecto.actividad_tres.models.AnimalSqlModel
import mx.emp.primerproyecto.actividad_tres.services.AnimalDBHelper
import mx.emp.primerproyecto.R

/**
 * A simple [Fragment] subclass.
 * Use the [AnimalDetailDosFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AnimalDetailDosFragment : Fragment() {

    private var animalSqlModel : AnimalSqlModel? = null
    private lateinit var animalDBHelper: AnimalDBHelper

    companion object{
        fun newInstance(animalSqlModel: AnimalSqlModel):AnimalDetailDosFragment{
            return AnimalDetailDosFragment().apply {
                arguments = Bundle().apply {
                    putSerializable("ARG_ANIMAL",animalSqlModel)
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            animalSqlModel = it.getSerializable("ARG_ANIMAL") as AnimalSqlModel
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_animal_detail_dos, container, false)

        animalDBHelper = AnimalDBHelper(requireContext())

        val tvAnimalName = view.findViewById<TextView>(R.id.tvAnimalName)
        val ivAnimal = view.findViewById<ImageView>(R.id.ivAnimal)
        val tvAnimalDescription = view.findViewById<TextView>(R.id.tvAnimalDescription)
        val rgSexo = view.findViewById<RadioGroup>(R.id.rgSexo)
        val checkAnimalSickness = view.findViewById<CheckBox>(R.id.animalSickness)
        val btnDelete = view.findViewById<Button>(R.id.btnDelete)

        tvAnimalName.text = animalSqlModel?.name
        Glide.with(view).load(animalSqlModel?.url_image).placeholder(R.drawable.ic_img_placeholder).into(ivAnimal)
        tvAnimalDescription.text = animalSqlModel?.description
        val rgSexoValue = when(animalSqlModel?.gender){
            "M" -> R.id.rbMas
            "F" -> R.id.rbFem
            "S" -> R.id.rbSN
            else -> R.id.rbSN
        }
        rgSexo.check(rgSexoValue)
        val sicknessValue = when(animalSqlModel?.is_sick){
            0 -> false
            1 -> true
            else -> false
        }
        checkAnimalSickness.isChecked = sicknessValue

        btnDelete.setOnClickListener {
            if(animalSqlModel!==null){
                animalDBHelper.deleteUser(animalSqlModel!!.id)
                btnDelete.isEnabled = false
            }
        }

        return view
    }
}