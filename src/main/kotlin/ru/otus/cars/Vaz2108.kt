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
            this.carMouth = Mouth2108()
        }

        /**
         * Сход-развал
         */
        fun alignWheels(vaz2108: Vaz2108) {
            println("${MODEL}: Положение руля до: ${vaz2108.wheelAngle}")
            vaz2108.wheelAngle = Random.nextInt(-180, 180)
            println("${MODEL}: Положение руля после: ${vaz2108.wheelAngle}")
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
    private var fuelLevel: Int = 0//Уровень топлива

    /**
     * Доступно сборщику
     * @see [build]
     */
    override lateinit var plates: Car.Plates
        private set
    override lateinit var carMouth: TankMouth
        private set

    // Выводим состояние машины
    override fun toString(): String {
        return "Vaz2108(plates=$plates, wheelAngle=$wheelAngle, currentSpeed=$currentSpeed, fuelLevel=${tank.fuel})"
    }

    /**
     * Делегируем приборы внутреннему классу
     */
    override val carOutput: CarOutput = VazOutput()

    override fun wheelToRight(degrees: Int) { wheelAngle += degrees }

    override fun wheelToLeft(degrees: Int) { wheelAngle -= degrees }

    private val tank = object : Tank{
        override val mouth: TankMouth
            get() = carMouth
        override var fuel: Int = 0

        override fun receiveFuel(liters: Int) {
            mouth.open()
            fuel+=liters
            mouth.close()
        }
    }

    /**
     * Имеет доступ к внутренним данным ЭТОГО ВАЗ-2108!
     */
    inner class VazOutput : CarOutput {
        override fun getCurrentSpeed(): Int {
            return this@Vaz2108.currentSpeed
        }

        override fun getFuelLevel(): Int {
            return this@Vaz2108.tank.fuel
        }
    }

    open inner class Mouth2108 : LpgMouth() {
        override fun fuelLpg(liters: Int) {
            return this@Vaz2108.tank.receiveFuel(liters)
        }
    }
}