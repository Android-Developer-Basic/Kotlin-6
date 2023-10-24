package ru.otus.cars

import ru.otus.cars.tank.*
import kotlin.random.Random

/**
 * Семёрочка
 */
class Vaz2107 private constructor() : Car {
    /**
     * Сам-себе-сборщик ВАЗ 2107.
     */
    companion object : CarBuilder {
        override fun build(
            plates: Car.Plates
        ): Vaz2107 = Vaz2107().apply {
            this.plates = plates
            this.mouth = LpgMouth(tank)
        }

        /**
         * Проверь, ездит или нет
         */
        fun test(vaz2107: Vaz2107) {
            println("${MODEL}: Проверка движка...")
            vaz2107.currentSpeed = Random.nextInt(0, 60)
            println("${MODEL}: Скорость: ${vaz2107.carOutput.getCurrentSpeed()}")
        }

        /**
         * Используем вместо STATIC
         */
        const val MODEL = "2107"
    }

    /**
     * Семерка едет так
     */
    fun drdrdrdrdr() {
        println("Помчали на $MODEL:")
        println("Др-др-др-др....")
    }

    private var wheelAngle: Int = 0 // Положение руля
    private var currentSpeed: Int = 0 // Скока жмёт
    private val tank: Tank = NormalTank()

    /**
     * Доступно сборщику
     * @see [build]
     */
    override lateinit var plates: Car.Plates
        private set
    override lateinit var mouth: TankMouth
        private set

    // Выводим состояние машины
    override fun toString(): String {
        return "Vaz2107(plates=$plates, wheelAngle=$wheelAngle, currentSpeed=$currentSpeed)"
    }

    /**
     * Делегируем приборы внутреннему классу
     */
    override val carOutput: CarOutput = VazOutput()

    override fun wheelToRight(
        degrees: Int
    ) {
        wheelAngle = commonWheelToRight(wheelAngle, degrees)
    }

    override fun wheelToLeft(
        degrees: Int
    ) {
        wheelAngle = commonWheelToLeft(wheelAngle, degrees)
    }

    /**
     * Имеет доступ к внутренним данным ЭТОГО ВАЗ-2107!
     */
    inner class VazOutput : CarOutput {
        override fun getCurrentSpeed(): Int {
            return this@Vaz2107.currentSpeed
        }

        override fun getCurrentWheelAngle(): Int {
            return this@Vaz2107.wheelAngle
        }

        override fun getFuelContents(): Int {
            return this@Vaz2107.tank.getContents()
        }
    }
}