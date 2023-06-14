package ru.otus.cars

sealed class TankMouth {

    interface Builder {
        fun create(tank: Tank): TankMouth
    }

    /**
     * Бак, к которому приварили горловину
     */
    protected lateinit var tank: Tank

    /**
     * Крышка снята или нет
     */
    private var opened: Boolean = false


    /**
     * Открывает крышку
     */
    fun open() {
        when (opened){
            false -> {
                opened = true
                println("Крышка горловины открыта.")
            }
            else -> println("Крышка горловины уже открыта!")
        }
    }

    /**
     * Закрывает крышку
     */
    fun close() {
        when (opened) {
            true -> {
                opened = false
                println("Крышка горловины закрыта.")
            }
            else -> println("Крышка горловины уже закрыта!")
        }
    }
    /**
     * Заправляет топливо в бак
     */
    protected fun putFuel(liters: Int) {
        if (opened) {
            tank.receiveFuel(liters)
        }
    }
}

/**
 * Горловина для газа
 */
class LpgMouth private constructor(): TankMouth() {
    companion object : Builder {
        override fun create(tank: Tank): TankMouth {
            return LpgMouth().apply { this.tank = tank }
        }
    }
    fun fuelLpg(liters: Int) {
        putFuel(liters)
    }
}

/**
 * Горловина для бензина
 */
class PetrolMouth private constructor(): TankMouth() {
    companion object : Builder {
        override fun create(tank: Tank): TankMouth {
            return PetrolMouth().apply { this.tank = tank }
        }
    }

    /**
     * Для бензина
     */
    fun fuelPetrol(liters: Int) {
        putFuel(liters)
    }
}


