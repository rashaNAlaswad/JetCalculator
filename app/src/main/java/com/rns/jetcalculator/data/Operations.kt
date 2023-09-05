package com.rns.jetcalculator.data

sealed class Operations(val symbol: String){
    object Add : Operations("+")
    object Subtract : Operations("-")
    object Multiply : Operations("x")
    object Divide : Operations("/")
    object Mod : Operations("%")
    object Power : Operations("^")
}
