package ru.otus.cars

import kotlin.random.Random

/**
 * Восьмерка
 */
class Vaz2108 private constructor() : Car {
    /**
     * Сам-себе-сборщик ВАЗ 2108.
     */
    companion object : CarBuilder {
        override fun build(plates: Car.Plates): Vaz2108 = Vaz2108().apply {
            this.plates = plates
        }

        /**
         * Сход-развал
         */
        fun alignWheels(vaz2108: Vaz2108) {
            println("${MODEL}: Положение руля до: ${vaz2108.wheelAngle}")
            vaz2108.wheelAngle = Random.nextInt(-180, 180)
            println("${MODEL}: Положение руля после: ${vaz2108.wheelAngle}")
            vaz2108.carTank.recieveFuel(Random.nextInt(5, 40))
            println("${Vaz2108.MODEL}: Топливо (${vaz2108.carOutput.getFuelType().toString()}): ${vaz2108.carOutput.getCurrentFuel()}")
        }

        /**
         * Используем вместо STATIC
         */
        const val MODEL = "2108"
    }

    /**
     * Восьмерка едет так
     */
    fun zhzhzhzh() {
        println("Помчали на ${MODEL}:")
        println("Ж-ж-ж-ж....")
    }

    private var wheelAngle: Int = 0 // Положение руля
    private var currentSpeed: Int = 0 // Скока жмёт

    /**
     * Доступно сборщику
     * @see [build]
     */
    override lateinit var plates: Car.Plates
        private set

    // Выводим состояние машины
    override fun toString(): String {
        return "Vaz2108(plates=$plates, wheelAngle=$wheelAngle, currentSpeed=$currentSpeed, " +
                "currentFuel=${carTank.getContents()}, fuelType=${carTank.getType()})"
    }

    /**
     * Делегируем приборы внутреннему классу
     */
    override val carOutput: CarOutput = VazOutput()

    override fun wheelToRight(degrees: Int) { wheelAngle += degrees }

    override fun wheelToLeft(degrees: Int) { wheelAngle -= degrees }

    /**
     * Имеет доступ к внутренним данным ЭТОГО ВАЗ-2108!
     */
    inner class VazOutput : CarOutput {
        override fun getCurrentSpeed(): Int {
            return this@Vaz2108.currentSpeed
        }
        override fun getCurrentFuel(): Int {
            return this@Vaz2108.carTank.getContents()
        }
        override fun getFuelType(): FuelType {
            return this@Vaz2108.carTank.getType()
        }
        override fun getModel(): String = MODEL
    }
    override val carTank = PetrolMouth()
}