package ru.otus.cars

/**
 * Следит за машиной
 */
interface CarOutput {
    fun getCurrentSpeed(): Int

    fun getFuelContents(): Int
}