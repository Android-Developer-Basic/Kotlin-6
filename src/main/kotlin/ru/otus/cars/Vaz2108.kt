package ru.otus.cars

import ru.otus.cars.Car.Companion.MAX_DEGREE
import ru.otus.cars.Car.Companion.MIN_DEGREE
import ru.otus.cars.tank.NormalTank
import ru.otus.cars.tank.PetrolMouth
import ru.otus.cars.tank.Tank
import ru.otus.cars.tank.TankMouth
import kotlin.random.Random

/**
 * Восьмерка
 */
class Vaz2108 private constructor() : Car {
    /**
     * Сам-себе-сборщик ВАЗ 2108.
     */
    companion object : CarBuilder {
        override fun build(
            plates: Car.Plates
        ): Vaz2108 = Vaz2108().apply {
            this.plates = plates
            this.mouth = PetrolMouth(tank)
        }

        /**
         * Сход-развал
         */
        fun alignWheels(vaz2108: Vaz2108) {
            println("${MODEL}: Положение руля до: ${vaz2108.wheelAngle}")
            vaz2108.wheelAngle = Random.nextInt(MIN_DEGREE, MAX_DEGREE)
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
    private var tank: Tank = NormalTank()

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
        return "Vaz2108(plates=$plates, wheelAngle=$wheelAngle, currentSpeed=$currentSpeed)"
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
     * Имеет доступ к внутренним данным ЭТОГО ВАЗ-2108!
     */
    inner class VazOutput : CarOutput {
        override fun getCurrentSpeed(): Int {
            return this@Vaz2108.currentSpeed
        }

        override fun getCurrentWheelAngle(): Int {
            return this@Vaz2108.wheelAngle
        }

        override fun getFuelContents(): Int {
            return this@Vaz2108.tank.getContents()
        }
    }
}