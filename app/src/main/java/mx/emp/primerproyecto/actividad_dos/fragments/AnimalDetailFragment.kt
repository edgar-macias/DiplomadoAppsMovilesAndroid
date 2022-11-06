package mx.emp.primerproyecto.actividad_dos.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import models.Animal
import mx.emp.primerproyecto.R


/**
 * A simple [Fragment] subclass.
 * Use the [AnimalDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AnimalDetailFragment : Fragment() {

    var animal: Animal? = null

    companion object{
        fun newInstance(animal:Animal):AnimalDetailFragment{
            return AnimalDetailFragment().apply {
                arguments = Bundle().apply {
                    putSerializable("ARG_ANIMAL",animal)
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            animal = it.getSerializable("ARG_ANIMAL") as Animal
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_animal_detail, container, false)

        val tvAnimalName:TextView = view.findViewById(R.id.tvAnimalName)
        val ivAnimal:ImageView = view.findViewById(R.id.ivAnimal)

        tvAnimalName.text = animal?.name
        ivAnimal.setImageResource(animal?.img?:R.drawable.ic_img_placeholder)

        return view
    }
}