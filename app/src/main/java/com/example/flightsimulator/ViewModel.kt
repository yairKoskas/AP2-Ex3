package com.example.flightsimulator

import androidx.databinding.Bindable

class ViewModel() {
    private var Port: Int = 0
    private lateinit var IP: String

    constructor(ip: String, port: Int) {
        this.IP = ip
        this.Port = port
    }

    @Bindable
    fun getIP(): String {
        return this.IP
    }

    @Bindable
    fun getPort(): Int {
        return this.Port
    }
}