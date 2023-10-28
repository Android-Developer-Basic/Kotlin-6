package ru.otus.cars

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

    /**
     * Внутренний статический класс - номерой знак
     */
    data class Plates(val number: String, val region: Int)

    /**
     * Топливный бак
     */
    val tankMouth : TankMouth // горловина
    val updateFuel: UpdateFuel // вспомогательный объект для обновления информации о топливе в баке
}