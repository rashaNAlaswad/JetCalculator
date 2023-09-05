package com.rns.jetcalculator.data

import androidx.compose.ui.graphics.Color

sealed class ActionType(val text : String, val color: Color) {
    object Clear : ActionType("AC", Color.Red)
    object Delete : ActionType("Del", Color.Blue)
    object Calculate : ActionType("=", Color.Black)
    data class Operation(val operation: Operations) : ActionType(operation.symbol, Color.Magenta)
    data class Number(val number: Int) : ActionType(number.toString(), Color.Blue)
    object Decimal : ActionType(".", Color.Blue)
}