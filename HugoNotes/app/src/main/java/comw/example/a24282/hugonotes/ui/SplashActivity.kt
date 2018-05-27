package comw.example.a24282.hugonotes.ui

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //开始activity好简单啊
        startActivity(Intent(this@SplashActivity, MainActivity::class.java))
        finish()
    }
}