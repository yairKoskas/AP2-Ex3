package com.example.flightsimulator

import java.io.OutputStream
import java.net.Socket
import java.nio.charset.Charset

class Model(private var viewModel: ViewModel) {
    private lateinit var sock: Socket
    private var connected=false
    fun connect() {
        connected=true
        val ip:String = viewModel.ip
        val port:String = viewModel.port
        sock = Socket(ip,port.toInt())
    }

    fun onPropertyChanged() {
        var t1 : Thread = Thread {
            if (connected) {
                val writer: OutputStream = sock.getOutputStream()
                writer.write(
                    ("set /controls/flight/aileron " + viewModel.aileron
                        .toString() + "\r\n").toByteArray(Charset.defaultCharset())
                )
                writer.write(
                    ("set /controls/flight/elevator " + viewModel.elevator
                        .toString() + "\r\n").toByteArray(Charset.defaultCharset())
                )
                writer.write(
                    ("set /controls/flight/rudder " + viewModel.getRudder()
                        .toString() + "\r\n").toByteArray(Charset.defaultCharset())
                )
                writer.write(
                    ("set /controls/engines/current-engine/throttle " + viewModel.getThrottle()
                        .toString() + "\r\n").toByteArray(Charset.defaultCharset())
                )
            }
        }
        t1.start()
    }
}