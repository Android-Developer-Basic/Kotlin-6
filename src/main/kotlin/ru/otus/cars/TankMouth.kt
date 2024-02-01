package ru.otus.cars

abstract class TankMouth(private val tank: Tank) {

    abstract fun open()
    abstract fun close()

    fun fuelUp(fuelAmount: Int) {
        open()
        tank.receiveFuel(fuelAmount)
        close()
    }
}