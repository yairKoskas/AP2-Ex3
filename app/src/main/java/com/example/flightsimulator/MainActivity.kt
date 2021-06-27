package com.example.flightsimulator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.EditText
import android.widget.SeekBar
import android.widget.Toast
import kotlin.concurrent.thread
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnTouchListener{
    lateinit var joystick:Joystick

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sb1:SeekBar=findViewById(R.id.throttle)
        val sb2:SeekBar=findViewById(R.id.rudder)
        sb1.max=1000
        sb2.max=1000
        joystick=findViewById(R.id.joystick)
        joystick.setOnTouchListener(this)
    }
    override fun onTouch(v: View, event: MotionEvent): Boolean {
        return joystick.onTouch(v,event)
    }
    public fun onConnect(view: View) {
        val ipText: EditText = findViewById(R.id.editTextIP)
        val portText: EditText = findViewById(R.id.editTextPort)
        val ipRegex: String = "^(?:[0-9]{1,3}\\.){3}[0-9]{1,3}\$"
        if (!ipText.text.matches(ipRegex.toRegex())) {
            Toast.makeText(applicationContext, "IP address invalid!", Toast.LENGTH_SHORT).show()
            return
        }
        val ip = ipText.text.toString()
        val port = portText.text.toString().toInt()
        var t1 : Thread = thread {
            m.connect()

        }
    }
}