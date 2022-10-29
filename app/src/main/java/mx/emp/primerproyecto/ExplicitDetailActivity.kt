package mx.emp.primerproyecto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class ExplicitDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_explicit_detail)

        val tvName = findViewById<TextView>(R.id.name)
        val tvLastName = findViewById<TextView>(R.id.last_name)
        val tvAge = findViewById<TextView>(R.id.age)

        intent.extras?.let {

            tvName.text = if(it.containsKey("KEY_NAME")) it.getString("KEY_NAME") else tvName.text

            tvLastName.text = if(it.containsKey("KEY_LASTNAME")) it.getString("KEY_LASTNAME") else tvLastName.text

            tvAge.text = if(it.containsKey("KEY_AGE")) it.getInt("KEY_AGE").toString() else tvAge.text

        } ?: showEmptyInfo()
    }

    private fun showEmptyInfo() {
        Toast.makeText(this,"Extras vacio",Toast.LENGTH_SHORT).show()
    }
}