package ru.otus.cars

import kotlin.random.Random

interface Tankable {
    val mouth: TankMouth
    fun getContents(): Int
    fun receiveFuel(liters: Int)
}

final class Tank(override val mouth: TankMouth) : Tankable {
    /**
     * Максимальный уровень топлива в баке. Об этом знает только бак!
     */
    private val maxFuelLevel = 35
    /**
     * Физический уровень топлива в баке. Об этом значении знает только бак!
     */
    private var fuelLevel = Random.nextInt(0, maxFuelLevel)
    override fun getContents(): Int { return fuelLevel }
    override fun receiveFuel(liters: Int) {
        if (fuelLevel + liters > maxFuelLevel)
            throw IllegalArgumentException("В бак столько не влезет!")
        fuelLevel += liters
    }
}