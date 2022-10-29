package mx.emp.primerproyecto

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ImplicitActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_implicit)

        val btnSendEmail = findViewById<Button>(R.id.btn_send_mail)

        btnSendEmail.setOnClickListener {
            val email: Intent = Intent(Intent.ACTION_SEND).apply {
                data = Uri.parse("mailto:")
                putExtra(Intent.EXTRA_EMAIL, arrayListOf("edgaremp007@gmail.com"))
                putExtra(Intent.EXTRA_SUBJECT, "Urgente.")
                putExtra(Intent.EXTRA_TEXT, "Cuerpo del correo")
            }

            startActivity(Intent.createChooser(email,"test"))
        }



    }
}