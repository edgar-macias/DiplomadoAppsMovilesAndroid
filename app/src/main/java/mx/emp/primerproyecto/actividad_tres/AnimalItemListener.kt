package mx.emp.primerproyecto.actividad_tres

import mx.emp.primerproyecto.actividad_tres.models.AnimalSqlModel


interface AnimalSqlItemListener {
    fun onItemSelected(animal: AnimalSqlModel)
}