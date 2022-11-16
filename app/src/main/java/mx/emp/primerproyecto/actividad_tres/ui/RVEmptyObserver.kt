package mx.emp.primerproyecto.actividad_tres.ui

import android.view.View
import androidx.recyclerview.widget.RecyclerView

class RVEmptyObserver(ev: View?,rv:RecyclerView?) : RecyclerView.AdapterDataObserver() {

    private var emptyView: View? = null
    private var recyclerView: RecyclerView? = null

    init {
        emptyView = ev
        recyclerView = rv
        checkIfEmpty()
    }
    private fun checkIfEmpty(){
        if (emptyView != null && recyclerView!!.adapter != null) {
            val emptyViewVisible = recyclerView!!.adapter!!.itemCount == 0
            emptyView!!.visibility = if (emptyViewVisible) View.VISIBLE else View.GONE
            recyclerView!!.visibility = if (emptyViewVisible) View.GONE else View.VISIBLE
        }
    }

    override fun onChanged() {
        super.onChanged()
        checkIfEmpty()
    }

    override fun onItemRangeChanged(positionStart: Int, itemCount: Int) {
        super.onItemRangeChanged(positionStart, itemCount)
    }
}