package com.anwesh.uiprojects.stepbarview

/**
 * Created by anweshmishra on 27/12/19.
 */

import android.view.View
import android.view.MotionEvent
import android.graphics.Paint
import android.graphics.Canvas
import android.graphics.RectF
import android.graphics.Color
import android.app.Activity
import android.content.Context

val nodes : Int = 5
val bars : Int = 5
val scGap : Float = 0.02f / bars
val sizeFactor : Float = 2f
val foreColor : Int = Color.parseColor("#0D47A1")
val backColor : Int = Color.parseColor("#BDBDBD")
val delay : Long = 30

fun Int.inverse() : Float = 1f / this
fun Float.maxScale(i : Int, n : Int) : Float = Math.max(0f, this - i * n.inverse())
fun Float.divideScale(i : Int, n : Int) : Float = Math.min(n.inverse(), maxScale(i, n)) * n
fun Float.sinify() : Float = Math.sin(this * Math.PI).toFloat()

fun Canvas.drawStepBar(i : Int, scale : Float, size : Float, gap : Float, paint : Paint) {
    val sf : Float = scale.sinify().divideScale(i, bars)
    save()
    translate(i * gap, 0f)
    drawRect(RectF(-gap / 2, -size * sf, gap / 2, 0f), paint)
    restore()
}

fun Canvas.drawStepBars(scale : Float, wSize : Float, hSize : Float, paint : Paint) {
    val gap : Float = wSize / bars
    val hGap : Float = hSize / bars
    for (j in 0..(bars - 1)) {
        drawStepBar(j, scale, hGap * (j + 1), gap, paint)
    }
}

fun Canvas.drawSBNode(i : Int, scale : Float, paint : Paint) {
    val w : Float = width.toFloat()
    val h : Float = height.toFloat()
    paint.color = foreColor
    val wSize : Float = w / sizeFactor
    val hSize : Float = h / (nodes + 1)
    save()
    translate(-wSize / 2, hSize * (i + 1))
    drawStepBars(scale, wSize, hSize, paint)
    restore()
}
