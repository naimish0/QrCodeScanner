package com.example.qrcodescanner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.qrcodescanner.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var _binding:ActivityMainBinding?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        _binding= ActivityMainBinding.inflate(layoutInflater)
        val view=_binding?.root
        setContentView(view)
        supportFragmentManager?.beginTransaction()?.replace(R.id.frame_activity_main,QrScanner()).commit()
    }
}