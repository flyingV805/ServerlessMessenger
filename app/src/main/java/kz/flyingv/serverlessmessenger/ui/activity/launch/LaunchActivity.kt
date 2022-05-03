package kz.flyingv.serverlessmessenger.ui.activity.launch

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kz.flyingv.serverlessmessenger.R
import kz.flyingv.serverlessmessenger.ui.activity.start.StartActivity

class LaunchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch)

        startActivity(Intent(this, StartActivity::class.java))
        finish()

    }



}