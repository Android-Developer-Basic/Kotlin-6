package ru.otus.cars

import ru.otus.cars.mouth.PetrolMouthImpl
import ru.otus.cars.mouth.TankMouth
import ru.otus.cars.tank.PetrolTankImpl
import kotlin.random.Random

/**
 * Восьмерка
 */
class Vaz2108 private constructor() : Car {

    companion object : CarBuilder {
        override fun build(plates: Car.Plates): Vaz2108 = Vaz2108().apply {
            this.plates = plates
        }

        fun alignWheels(vaz2108: Vaz2108) {
            println("${MODEL}: Положение руля до: ${vaz2108.wheelAngle}")
            vaz2108.wheelAngle = Random.nextInt(-180, 180)
            println("${MODEL}: Положение руля после: ${vaz2108.wheelAngle}")
        }

        const val MODEL = "2108"
    }

    fun zhzhzhzh() {
        println("Помчали на ${MODEL}:")
        println("Ж-ж-ж-ж....")
    }

    private var wheelAngle: Int = 0 // Положение руля
    private var currentSpeed: Int = 0 // Скока жмёт
    private val tank = PetrolTankImpl()

    override val carOutput: CarOutput = VazOutput()
    override val tankMouth: TankMouth = PetrolMouthImpl(tank)

    override lateinit var plates: Car.Plates
        private set

    override fun toString(): String {
        return "Vaz2108(plates=$plates, wheelAngle=$wheelAngle, currentSpeed=$currentSpeed fuelAmount=${tank.capacity})"
    }

    override fun wheelToRight(degrees: Int) {
        wheelAngle += degrees
    }

    override fun wheelToLeft(degrees: Int) {
        wheelAngle -= degrees
    }

    inner class VazOutput : CarOutput {
        override fun getCurrentSpeed(): Int {
            return this@Vaz2108.currentSpeed
        }

        override fun getFuelContents(): Int {
            return this@Vaz2108.tank.getContents()
        }
    }
}