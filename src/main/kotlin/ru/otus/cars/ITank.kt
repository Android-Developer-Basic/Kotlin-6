package ru.otus.cars

interface ITank {
    val mouth: TankMouth
    fun getContents() : Int
    fun receiveFuel(litres: Int)
}


