package mx.emp.primerproyecto.actividad_dos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import models.Animal
import models.animalList
import mx.emp.primerproyecto.R

class AnimalAdapter(private val items:List<Animal>, private val listener: AnimalItemListener): RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder>() {
    class AnimalViewHolder(view: View):RecyclerView.ViewHolder(view) {
        val name: TextView
        val image: ImageView

        init{
            name = view.findViewById(R.id.tvAnimalName)
            image = view.findViewById(R.id.animalImg)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_animal_item,parent,false)
        return AnimalViewHolder(view)
    }

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        val animal = animalList().find { it.id == position+1 }
        if (animal!=null){
            holder.name.text = animal.name
            holder.image.setImageResource(animal.img?:R.drawable.ic_img_placeholder)
            holder.itemView.setOnClickListener {
                listener.onItemSelected(animal)
            }
        } else {
            holder.name.text = "sin asignar"
            holder.image.setImageResource(R.drawable.ic_img_placeholder)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}