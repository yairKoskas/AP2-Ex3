package com.example.flightsimulator

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View


class Joystick : View,View.OnTouchListener {
    private val BACKGROUND_COLOR=Color.LTGRAY
    private val JOYSTICK_COLOR= Color.RED
    private var centerX =0f
    private var centerY =0f
    private var baseRadius =0f
    private var joystickRadius =0f
    private var _elevator =0f
    private var _aileron =0f

    var elevator: Float
        get() =  _elevator
        set(value) {
            _elevator= value
        }
    var aileron: Float
        get() = _aileron
        set(value) {
            _aileron= value
        }


    constructor(context: Context) : super(context) {
        init(null, 0)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(attrs, 0)
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    ) {
        init(attrs, defStyle)
    }

    override fun onSizeChanged(width: Int, height: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(width, height, oldw, oldh)
        baseRadius = Math.min(width, height) / 4f
        joystickRadius = Math.min(width, height) / 5f
        centerX=width/2f
        centerY=height/2f
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        var p = Paint()
        p.setColor(BACKGROUND_COLOR)
        canvas.drawCircle(width / 2f, height / 2f, baseRadius + joystickRadius, p)
        p.setColor(JOYSTICK_COLOR)
        canvas.drawCircle(centerX, centerY, joystickRadius, p)
    }

    override fun onTouch(view: View, event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                normalizeCoordinates(event.x,event.y)
            }
            MotionEvent.ACTION_MOVE ->{
                normalizeCoordinates(event.x,event.y)
            }
            else -> return false
        }
        return true
    }
    private fun normalizeCoordinates(x:Float,y:Float){
        centerX=x
        centerY=y
        var dx=width/2-x
        var dy=height/2-y
        var distance=Math.sqrt((dx*dx+dy*dy).toDouble())
        if(distance>baseRadius){
            dx= (dx*baseRadius/distance).toFloat()
            dy= (dy*baseRadius/distance).toFloat()
            centerX=width/2-dx
            centerY=height/2-dy
        }
        elevator= dy/baseRadius
        aileron= -dx/baseRadius
        invalidate()
    }
    private fun init(attrs: AttributeSet?, defStyle: Int) {

    }
}