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
