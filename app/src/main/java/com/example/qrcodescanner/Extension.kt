package com.example.qrcodescanner

import android.content.Context
import android.os.Message
import android.widget.Toast
import androidx.core.content.contentValuesOf

class Extension {
    companion object{

        fun Toast(context: Context,message: String)
        {
            Toast.makeText(context,message, Toast.LENGTH_SHORT).show()
        }
    }
}