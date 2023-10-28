package ru.otus.cars

import kotlin.random.Random

/**
 * Семёрочка
 */
class Vaz2107 private constructor() : Car {
    /**
     * Сам-себе-сборщик ВАЗ 2107.
     */
    companion object : CarBuilder {
        override fun build(plates: Car.Plates, tankMouth: TankMouth): Vaz2107 = Vaz2107().apply {
            this.plates = plates
            this.tankMouth=tankMouth
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

    /**
     * Доступно сборщику
     * @see [build]
     */
    override lateinit var plates: Car.Plates
        private set

    // Выводим состояние машины
    override fun toString(): String {
        return "Vaz2107(plates=$plates, wheelAngle=$wheelAngle, currentSpeed=$currentSpeed, tankFuel=${tankFuel.getContents()})"
    }

    /**
     * Делегируем приборы внутреннему классу
     */
    override val carOutput: CarOutput = VazOutput()

    override fun wheelToRight(degrees: Int) { wheelAngle += degrees }

    override fun wheelToLeft(degrees: Int) { wheelAngle -= degrees }

    /**
     * Имеет доступ к внутренним данным ЭТОГО ВАЗ-2107!
     */
    inner class VazOutput : CarOutput {
        override fun getCurrentSpeed(): Int {
            return this@Vaz2107.currentSpeed
        }

        override fun getFuelContents(): Int {
            return this@Vaz2107.tankFuel.getContents()
        }
    }

    /**
     * Топливный бак
     */
    private var tankFuel = TankFuel()
    private var litresInTank: Int = 0  // кол-во литров в баке

    private inner class TankFuel : Tank {
        override val mouth: TankMouth
            get() = tankMouth

        override fun getContents(): Int {
            return litresInTank
        }
        override fun receiveFuel(liters: Int) {
            litresInTank += liters
        }
    }

    /**
     * Горловина бака
     */
    override lateinit var tankMouth: TankMouth

    override val updateFuel =
        UpdateFuel { this.tankFuel.receiveFuel(it) }
}