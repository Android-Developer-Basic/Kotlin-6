package ru.otus.cars

import ru.otus.cars.tank.TankMouth

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
     * Внутренний статический класс - номерой знак
     */
    data class Plates(val number: String, val region: Int)

    companion object{
        const val MAX_DEGREE = 180
        const val MIN_DEGREE = -180
    }
}

