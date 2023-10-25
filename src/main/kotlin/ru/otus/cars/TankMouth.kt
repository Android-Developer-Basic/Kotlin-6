package ru.otus.cars

abstract class TankMouth {
    abstract fun open()
    abstract fun close()
}

class PetrolMouth(private val tank: Tank) : TankMouth() {
    fun fuelPetrol(liters: Int) {
        tank.receiveFuel(liters)
    }

    override fun open() {
        println("Бак с бензином открылся")
    }

    override fun close() {
        println("Бак с бензином закрылся")
    }
}

class LpgMouth(private val tank: Tank) : TankMouth() {
    fun fuelLpg(liters: Int) {
        tank.receiveFuel(liters)
    }

    override fun open() {
        println("Бак с газом открылся")
    }

    override fun close() {
        println("Бак с газом закрылся")
    }
}