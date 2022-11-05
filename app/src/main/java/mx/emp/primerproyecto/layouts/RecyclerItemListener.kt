package mx.emp.primerproyecto.layouts

import models.UserItem

interface RecyclerItemListener {
    fun onItemSelected(user:UserItem)
}