package kz.flyingv.serverlessmessenger.activity.launch

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kz.flyingv.serverlessmessenger.R
import kz.flyingv.serverlessmessenger.activity.start.StartActivity

class LaunchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch)

        startActivity(Intent(this, StartActivity::class.java))
        finish()

    }



}