package com.example.flightsimulator

class ViewModel() {

    var ip="127.0.0.1"
    var port=0
    private var _elevator =0f
    private var _aileron =0f
    var elevator: Float
        get() =  _elevator
        set(value) {
            _elevator= value
            model.onPropertyChanged()
        }
    var aileron: Float
        get() = _aileron
        set(value) {
            _aileron= value
            model.onPropertyChanged()
        }
    private var _modifiedThrottle=0
    var modifiedThrottle:Int
        get() =  _modifiedThrottle
        set(value) {
            _modifiedThrottle= value
            model.onPropertyChanged()
        }
    private var _modifiedRudder=0
    var modifiedRudder:Int
        get() =  _modifiedRudder
        set(value) {
            _modifiedRudder= value
            model.onPropertyChanged()
        }
    private lateinit var model:Model
    fun setModel(model:Model){
        this.model=model
    }
    fun connect(){
        model.connect()
    }


    fun getThrottle(): Float {
        return this.modifiedThrottle/1000f
    }

    fun getRudder(): Float {
        return (this.modifiedRudder-500)/500f
    }
}