package mx.emp.primerproyecto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ExplicitActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_explicit)

        val intent:Intent = Intent(this,ExplicitDetailActivity::class.java).apply {
            putExtra("KEY_NAME","Edgar")
            putExtra("KEY_LASTNAME","Macias")
            putExtra("KEY_AGE",27)
        }

        startActivity(intent)
    }
}