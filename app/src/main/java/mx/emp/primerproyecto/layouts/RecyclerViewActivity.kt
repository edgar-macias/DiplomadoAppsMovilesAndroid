package mx.emp.primerproyecto.layouts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import models.UserItem
import mx.emp.primerproyecto.R

class RecyclerViewActivity : AppCompatActivity(),RecyclerItemListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        val list = findViewById<RecyclerView>(R.id.list)

        val userAdapter = UserAdapter(getData(),this)

        list.layoutManager = LinearLayoutManager(this,RecyclerView.VERTICAL,false)

        list.addItemDecoration(DividerItemDecoration(this,RecyclerView.VERTICAL))
        list.itemAnimator = DefaultItemAnimator()

        list.adapter = userAdapter
    }

    private fun getData():ArrayList<UserItem>{
        val data = arrayListOf<UserItem>()

        data.add(UserItem("Edgar",""))
        data.add(UserItem("Jose",""))
        data.add(UserItem("Juan",""))
        data.add(UserItem("Pedro",""))
        data.add(UserItem("Maria",""))
        data.add(UserItem("Luisa",""))
        data.add(UserItem("Jaime",""))
        data.add(UserItem("Diana",""))
        data.add(UserItem("Adriana",""))
        data.add(UserItem("Luis",""))

        return data
    }

    override fun onItemSelected(user: UserItem) {
        Toast.makeText(this,"User:${user.name}",Toast.LENGTH_SHORT).show()
    }


}