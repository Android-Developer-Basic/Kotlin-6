package ru.otus.cars

import kotlin.random.Random

sealed class TankMouth: Tank {
    open fun open() {}
    open fun close() {}
}

class PetrolMouth : TankMouth() {
    override fun open() {
        println("Открыли бак, заправляем бензин")
    }

    override fun close() {
        println("Закрыли бак, заправка бензином закончена")
    }
    override val mouth: TankMouth = this
    override fun getContents(): Int {
        return litersNumber
    }

    override fun receiveFuel(liters: Int) {
        fuelPetrol(liters)
    }

    private var litersNumber : Int = Random.nextInt(0,25)
    private fun fuelPetrol(liters: Int) {
        open()
        litersNumber += liters
        close()
    }
}

class LpgMouth : TankMouth() {
    override fun open() {
        println("Открыли бак, заправляем газ")
    }

    override fun close() {
        println("Закрыли бак, заправка газом закончена")
    }
    override val mouth: TankMouth = this
    override fun getContents(): Int {
        return litersNumber
    }

    override fun receiveFuel(liters: Int) {
        fuelLpg(liters)
    }

    private var litersNumber : Int = Random.nextInt(0,25)
    private fun fuelLpg(liters: Int) {
        open()
        litersNumber += liters
        close()
    }
}