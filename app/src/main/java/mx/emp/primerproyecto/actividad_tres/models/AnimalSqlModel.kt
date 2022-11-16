package mx.emp.primerproyecto.actividad_tres.models

import java.io.Serializable

data class AnimalSqlModel(
    val id:Int=0,
    val name: String,
    val description:String,
    val url_image:String,
    val gender:String?,
    val is_sick:Int?
) : Serializable