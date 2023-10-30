package ru.otus.cars

sealed class TankMouth {
    abstract fun open()
    abstract fun close()

}

open class PetrolMouth : TankMouth() {
    override fun open() = println("Горловина бензинового бака открыта")

    override fun close() = println("Горловина бензинового бака закрыта")

    open fun fuelPetrol(liters: Int) {}
}

open class LpgMouth : TankMouth() {
    override fun open() = println("Горловина газового бака открыта")

    override fun close() = println("Горловина газового бака закрыта")

    open fun fuelLpg(liters: Int) {}
}