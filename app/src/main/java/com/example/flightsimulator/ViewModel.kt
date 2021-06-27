package com.example.flightsimulator

<<<<<<< HEAD
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

=======
class ViewModel(private var view:MainActivity,private var model:Model) {

    var ip="127.0.0.1"
    var port=0
    private var aileron: Float = 0F
    private var elevator : Float = 0F
    var modifiedThrottle=0
    var modifiedRudder=0

    fun connect(){
        model.connect()
    }
>>>>>>> 59069e2416d8e0b3a37297cfa8ec714f0eaf7745
    fun getAileron(): Float {
        return this.aileron
    }

    fun getElevator(): Float {
        return this.elevator
    }

    fun getThrottle(): Float {
<<<<<<< HEAD
        return this.throttle
    }

    fun getRudder(): Float {
        return this.rudder
=======
        return this.modifiedThrottle/1000f
    }

    fun getRudder(): Float {
        return (this.modifiedRudder-500)/500f
>>>>>>> 59069e2416d8e0b3a37297cfa8ec714f0eaf7745
    }
}