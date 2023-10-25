package ru.otus.cars.mouth

import ru.otus.cars.tank.Tank

abstract class TankMouth(private val tank: Tank) {

    abstract fun open()
    abstract fun close()

    fun fuelUp(fuelAmount: Int) {
        open()
        tank.receiveFuel(fuelAmount)
        close()
    }
}