package ru.otus.cars

import ru.otus.cars.tank.Tank

/**
 * Сборщик машины
 */
sealed interface CarBuilder {
    /**
     * Собери машину
     */
    fun build(plates: Car.Plates, tank: Tank): Car
}