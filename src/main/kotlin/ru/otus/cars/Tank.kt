package ru.otus.cars

sealed interface Tank{
    val mouth: TankMouth

    fun getContents(): Int
    fun receiveFuel(liters: Int)
}