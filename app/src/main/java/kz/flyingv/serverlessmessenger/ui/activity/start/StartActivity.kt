package kz.flyingv.serverlessmessenger.ui.activity.start

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kz.flyingv.serverlessmessenger.databinding.ActivityStartBinding

class StartActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStartBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }



}