package mx.emp.primerproyecto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private val tag = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnGoTo = findViewById<Button>(R.id.btn_to_implicit)

        btnGoTo.setOnClickListener {
            val intent = Intent(this,ImplicitActivity::class.java)

            startActivity(intent)
        }

        Log.e(tag,"Entre en onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.e(tag,"Entre en onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.e(tag,"Entre en onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.e(tag,"Entre en onPause")
    }

    override fun onRestart() {
        super.onRestart()
        Log.e(tag,"Entre en onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(tag,"Entre en onDestroy")
    }
}