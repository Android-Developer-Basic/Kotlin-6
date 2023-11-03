package ru.otus.cars

/**
 * Машина целиком
 */
sealed interface Car : CarInput {

    val tankMouth: TankMouth
    /**
     * Номерной знак
     */
    val plates: Plates

    /**
     * Следит за машиной
     */
    val carOutput: CarOutput

    /**
     * Внутренний статический класс - номерой знак
     */
    data class Plates(val number: String, val region: Int)

}