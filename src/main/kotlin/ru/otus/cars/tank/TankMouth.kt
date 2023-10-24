package ru.otus.cars.tank

abstract class TankMouth(private val tank: Tank) {

    abstract fun open()
    abstract fun close()

    open fun fuel(
        liters: Int
    ){
        open()
        tank.receiveFuel(liters)
        close()
    }
}

class PetrolMouth(
    tank: Tank
) : TankMouth(tank) {

    override fun open() = println("Бак с бензином открылся")

    override fun close() = println("Бак с бензином закрылся")

    override fun fuel(
        liters: Int
    ){
        super.fuel(liters)
    }
}

class LpgMouth(tank: Tank) : TankMouth(tank) {

    override fun open() = println("Баллон с газом открылся")

    override fun close() = println("Баллон с газом закрылся")

    override fun fuel(
        liters: Int
    ){
        super.fuel(liters)
    }
}