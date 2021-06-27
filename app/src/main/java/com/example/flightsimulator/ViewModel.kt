package com.example.flightsimulator

class ViewModel() {

    var ip="127.0.0.1"
    var port=0
    private var aileron: Float = 0F
    private var elevator : Float = 0F
    var modifiedThrottle=0
    var modifiedRudder=0
    private lateinit var model:Model
    fun setModel(model:Model){
        this.model=model
    }
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