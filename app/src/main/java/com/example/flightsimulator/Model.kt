package com.example.flightsimulator

import java.io.OutputStream
import java.net.Socket
import java.net.SocketAddress
import java.nio.charset.Charset

class Model(private var viewModel: ViewModel) {
    private lateinit var sock: Socket

    fun connect() {
        val ip:String = viewModel.ip
        val port:Int = viewModel.port
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