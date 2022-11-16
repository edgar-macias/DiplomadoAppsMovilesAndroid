package mx.emp.primerproyecto.actividad_tres.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import mx.emp.primerproyecto.actividad_tres.AnimalSqlItemListener
import mx.emp.primerproyecto.actividad_tres.models.AnimalSqlModel
import mx.emp.primerproyecto.R

class AnimalSqlAdapter(private val items : ArrayList<AnimalSqlModel>, private val listener: AnimalSqlItemListener) : RecyclerView.Adapter<AnimalSqlAdapter.AnimalSqlViewHolder>() {

    class AnimalSqlViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name:TextView
        val image:ImageView

        init {
            name = view.findViewById(R.id.tvAnimalName)
            image = view.findViewById(R.id.animalImg)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalSqlViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_animal_item,parent,false)
        return AnimalSqlViewHolder(view)
    }

    override fun onBindViewHolder(holder: AnimalSqlViewHolder, position: Int) {
        holder.name.text = items[position].name
        Glide.with(holder.itemView)
            .load(items[position].url_image)
            .placeholder(R.drawable.ic_img_placeholder)
            .apply(RequestOptions().override(200,200))
            .into(holder.image)
        holder.itemView.setOnClickListener {
            listener.onItemSelected(items[position])
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun updateItems(newItems:ArrayList<AnimalSqlModel>){
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }
}