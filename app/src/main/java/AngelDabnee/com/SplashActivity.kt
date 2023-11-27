package AngelDabnee.com

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        var logo = findViewById<ImageView>(R.id.imageViewLogo)

        logo.setOnClickListener()
        {
            var i = Intent(this,MainActivity::class.java)
            startActivity(i)
            finish()
            /*Toast.makeText(this,"Iniciando", Toast.LENGTH_SHORT).show()*/
        }
    }
}