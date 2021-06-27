package com.example.flightsimulator

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
    fun getAileron(): Float {
        return this.aileron
    }

    fun getElevator(): Float {
        return this.elevator
    }

    fun getThrottle(): Float {
        return this.modifiedThrottle/1000f
    }

    fun getRudder(): Float {
        return (this.modifiedRudder-500)/500f
    }
}