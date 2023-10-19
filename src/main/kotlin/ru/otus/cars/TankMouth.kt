package ru.otus.cars

abstract class TankMouth(protected val tank: Tank) {

    abstract fun open()
    abstract fun close()

}

class PetrolMouth(tank: Tank) : TankMouth(tank) {

    override fun open() = println("Бак с бензином открылся")

    override fun close() = println("Бак с бензином закрылся")

    fun fuelPetrol(liters: Int) {
        open()
        tank.receiveFuel(liters)
        close()
    }

}

class LpgMouth(tank: Tank) : TankMouth(tank) {

    override fun open() = println("Баллон с газом открылся")

    override fun close() = println("Баллон с газом закрылся")

    fun fuelLpg(liters: Int) {
        open()
        tank.receiveFuel(liters)
        close()
    }

}