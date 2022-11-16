package mx.emp.primerproyecto.actividad_tres.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import mx.emp.primerproyecto.actividad_tres.AnimalSqlItemListener
import mx.emp.primerproyecto.actividad_tres.models.AnimalSqlModel
import mx.emp.primerproyecto.actividad_tres.services.AnimalDBHelper
import mx.emp.primerproyecto.R

/**
 * A simple [Fragment] subclass.
 * Use the [AnimalListDosFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AnimalListDosFragment : Fragment(),AnimalSqlItemListener {

    private lateinit var animalDBHelper:AnimalDBHelper

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        animalDBHelper = AnimalDBHelper(requireContext())

        val view = inflater.inflate(R.layout.fragment_animal_list_dos, container, false)

        val animalListDos = view.findViewById<RecyclerView>(R.id.animalListDos)
        val btnAddAnimal = view.findViewById<FloatingActionButton>(R.id.addAnimal)
        val animalListEmpty = view.findViewById<TextView>(R.id.empty_view)

        animalListDos.layoutManager = LinearLayoutManager(view.context,RecyclerView.VERTICAL,false)

        val animalSqlAdapter = AnimalSqlAdapter(animalDBHelper.getAllAnimals(),this)

        animalListDos.adapter = animalSqlAdapter

        val emptyDataObserver = RVEmptyObserver(animalListEmpty,animalListDos)

        animalSqlAdapter.registerAdapterDataObserver(emptyDataObserver)

        btnAddAnimal.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.actividadTresContainer,AddAnimalFragment())
                .addToBackStack("AddAnimalFragment").commit()
        }

        return view
    }

    override fun onItemSelected(animal: AnimalSqlModel) {
        parentFragmentManager.beginTransaction()
            .replace(R.id.actividadTresContainer,AnimalDetailDosFragment.newInstance(animal))
            .addToBackStack("AnimalDetailDosFragment").commit()
    }

}