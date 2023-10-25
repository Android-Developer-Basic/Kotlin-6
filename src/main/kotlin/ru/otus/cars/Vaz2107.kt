package ru.otus.cars

import ru.otus.cars.mouth.LpgMouthImpl
import ru.otus.cars.mouth.TankMouth
import ru.otus.cars.tank.LpgTankImpl
import kotlin.random.Random

/**
 * Семёрочка
 */
class Vaz2107 private constructor() : Car {

    companion object : CarBuilder {
        override fun build(plates: Car.Plates): Vaz2107 = Vaz2107().apply {
            this.plates = plates
        }

        fun test(vaz2107: Vaz2107) {
            println("${MODEL}: Проверка движка...")
            vaz2107.currentSpeed = Random.nextInt(0, 60)
            println("${MODEL}: Скорость: ${vaz2107.carOutput.getCurrentSpeed()}")
        }

        const val MODEL = "2107"
    }


    fun drdrdrdrdr() {
        println("Помчали на $MODEL:")
        println("Др-др-др-др....")
    }

    private var wheelAngle: Int = 0 // Положение руля
    private var currentSpeed: Int = 0 // Скока жмёт
    private val tank = LpgTankImpl()

    override val carOutput: CarOutput = VazOutput()
    override val tankMouth: TankMouth = LpgMouthImpl(tank)


    override lateinit var plates: Car.Plates
        private set

    override fun toString(): String {
        return "Vaz2107(plates=$plates, wheelAngle=$wheelAngle, currentSpeed=$currentSpeed fuelAmount=${tank.capacity})"
    }

    override fun wheelToRight(degrees: Int) {
        wheelAngle += degrees
    }

    override fun wheelToLeft(degrees: Int) {
        wheelAngle -= degrees
    }

    inner class VazOutput : CarOutput {
        override fun getCurrentSpeed(): Int {
            return this@Vaz2107.currentSpeed
        }

        override fun getFuelContents(): Int {
            return this@Vaz2107.tank.getContents()
        }
    }
}