package ru.otus.cars

/**
 * Следит за машиной
 */
interface CarOutput {
    /**
     * Скажи текущую скорость
     */
    fun getCurrentSpeed(): Int

    fun getFuelContents(): Int
    //abstract fun getContents(): String
    //abstract fun getContents(): String
}