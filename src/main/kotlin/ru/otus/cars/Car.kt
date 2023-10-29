package ru.otus.cars

import Tank.TankMouth

/**
 * Машина целиком
 */
sealed interface Car : CarInput {
    /**
     * Номерной знак
     */
    val plates: Plates

    /**
     * Следит за машиной
     */
    val carOutput: CarOutput
    val mouth: TankMouth

    /**
     * Внутренний статический класс - номерной знак
     */
    data class Plates(val number: String, val region: Int)
}