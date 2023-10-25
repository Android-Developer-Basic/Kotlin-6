package ru.otus.cars

import ru.otus.cars.mouth.TankMouth

/**
 * Машина целиком
 */
sealed interface Car : CarInput {

    val plates: Plates

    val carOutput: CarOutput

    val tankMouth: TankMouth

    data class Plates(val number: String, val region: Int)
}