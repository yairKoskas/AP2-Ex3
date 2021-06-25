package com.example.flightsimulator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.core.text.isDigitsOnly
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onConnect(view: View) {
        val ipText: EditText = findViewById(R.id.editTextIP)
        val portText: EditText = findViewById(R.id.editTextPort)
        val ipRegex: String = "^(?:[0-9]{1,3}\\.){3}[0-9]{1,3}\$"
        if (!ipText.text.matches(ipRegex.toRegex())) {
            Toast.makeText(applicationContext, "IP address invalid!", Toast.LENGTH_SHORT).show()
            return
        }
        val ip = ipText.text.toString()
        val port = portText.text.toString().toInt()
        val viewModel : ViewModel = ViewModel(ip, port)
        val m : Model = Model(viewModel)
        var t1 : Thread = thread {
            m.connect()

        }
    }
}