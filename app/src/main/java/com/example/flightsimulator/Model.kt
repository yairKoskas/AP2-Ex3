package com.example.flightsimulator

import java.io.OutputStream
import java.net.Socket
import java.net.SocketAddress
import java.nio.charset.Charset

class Model(private var viewModel: ViewModel) {
    private lateinit var sock: Socket

    fun connect() {
<<<<<<< HEAD
        val ip:String = viewModel.getIP()
        val port:Int = viewModel.getPort()
=======
        val ip:String = viewModel.ip
        val port:Int = viewModel.port
>>>>>>> 59069e2416d8e0b3a37297cfa8ec714f0eaf7745
        sock = Socket(ip,port)
    }

    fun send() {
        val writer: OutputStream = sock.getOutputStream()
        writer.write(("set /controls/flight/aileron " + viewModel.getAileron()
            .toString()+"\r\n").toByteArray(Charset.defaultCharset()))
        writer.write(("set /controls/flight/elevator " + viewModel.getElevator()
            .toString()+"\r\n").toByteArray(Charset.defaultCharset()))
        writer.write(("set /controls/flight/rudder " + viewModel.getRudder()
            .toString()+"\r\n").toByteArray(Charset.defaultCharset()))
        writer.write(("set /controls/engines/current-engine/throttle "+viewModel.getThrottle()
            .toString()+"\r\n").toByteArray(Charset.defaultCharset()))
    }
}