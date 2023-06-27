package ru.otus.cars.tank

interface Tank {

    var fuel: Int
    val mouth: TankMouth

    fun getContents(): Int
    fun receiveFuel(litres: Int)
}