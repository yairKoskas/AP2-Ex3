package com.example.flightsimulator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.EditText
import android.widget.SeekBar
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.flightsimulator.databinding.ActivityMainBinding
import kotlin.concurrent.thread
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnTouchListener{
    lateinit var joystick:Joystick
    lateinit var viewModel:ViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel= ViewModel()
        var model=Model(viewModel)
        viewModel.setModel(model)
        var binding:ActivityMainBinding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.viewModel=viewModel
        val sb1:SeekBar=findViewById(R.id.throttle)
        val sb2:SeekBar=findViewById(R.id.rudder)
        sb1.max=1000
        sb2.max=1000
        joystick=findViewById(R.id.joystick)
        joystick.setViewModel(viewModel)
        joystick.setOnTouchListener(this)
    }
    override fun onTouch(v: View, event: MotionEvent): Boolean {
        return joystick.onTouch(v,event)
    }
    public fun onConnect(view: View) {
        val ipText: EditText = findViewById(R.id.editTextIP)
        val portText: EditText = findViewById(R.id.editTextPort)
        val ipRegex= "^(?:[0-9]{1,3}\\.){3}[0-9]{1,3}\$"
        if (!ipText.text.matches(ipRegex.toRegex())) {
            Toast.makeText(applicationContext, "IP address invalid!", Toast.LENGTH_SHORT).show()
            return
        }
        viewModel.ip = ipText.text.toString()
        viewModel.port = portText.text.toString()
        var t1 : Thread = thread {
            viewModel.connect()
        }
    }
}