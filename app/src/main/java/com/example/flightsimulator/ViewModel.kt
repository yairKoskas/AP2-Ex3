package com.example.flightsimulator

class ViewModel(private var IP: String = "127.0.0.1", private var Port: Int = 0) {

    private var aileron: Float = 0F
    private var elevator : Float = 0F
    private var throttle : Float = 0F
    private var rudder : Float = 0F

    fun getIP(): String {
        return this.IP
    }

    fun getPort(): Int {
        return this.Port
    }

    fun getAileron(): Float {
        return this.aileron
    }

    fun getElevator(): Float {
        return this.elevator
    }

    fun getThrottle(): Float {
        return this.throttle
    }

    fun getRudder(): Float {
        return this.rudder
    }
}