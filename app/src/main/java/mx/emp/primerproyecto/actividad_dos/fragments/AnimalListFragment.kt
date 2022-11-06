package mx.emp.primerproyecto.actividad_dos.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import models.Animal
import mx.emp.primerproyecto.R
import mx.emp.primerproyecto.actividad_dos.AnimalAdapter
import mx.emp.primerproyecto.actividad_dos.AnimalItemListener

class AnimalListFragment : Fragment(),AnimalItemListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_animal_list, container, false)

        val animalList = view.findViewById<RecyclerView>(R.id.animalList)

        val animalAdapter = AnimalAdapter(models.animalList(), this)

        animalList.layoutManager = LinearLayoutManager(view.context,RecyclerView.VERTICAL,false)

        animalList.adapter = animalAdapter

        return view
    }

    override fun onItemSelected(animal: Animal) {
        parentFragmentManager.beginTransaction()
            .replace(R.id.actividadDosContainer,AnimalDetailFragment.newInstance(animal))
            .addToBackStack("AnimalDetailFragment")
            .commit()
    }

}