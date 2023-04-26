package ru.otus.cars


sealed class TankMouth {
    open fun open() {}
    open fun close() {}
}

//
open class PetrolMouth : TankMouth() {
    override fun open() {
        println("Бак открыт, идет заправка Бензином")
    }

    override fun close() {
        println("Заправка Газом закончина, бак Бензином")
    }

    open fun fuelPetrol(liters: Int) {}
}

open class LpgMouth : TankMouth() {
    override fun open() {
        println("Бак открыт, идет заправка Газом")
    }

    override fun close() {
        println("Заправка Газом закончина, бак закрыт")
    }
    open fun fuelLpg(liters: Int) {}
}