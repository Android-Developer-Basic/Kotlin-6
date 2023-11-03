package ru.otus.cars

interface Tank {
    var mouth: TankMouth

    fun getContents(): Int

    fun receiveFuel(liters: Int)
}