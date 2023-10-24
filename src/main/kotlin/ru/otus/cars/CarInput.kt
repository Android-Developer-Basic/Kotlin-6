package ru.otus.cars

import ru.otus.cars.Car.Companion.MAX_DEGREE
import ru.otus.cars.Car.Companion.MIN_DEGREE

/**
 * Рулит машиной
 */
interface CarInput {
    /**
     * Руль вправо на [degrees] градусов
     */
    fun wheelToRight(degrees: Int)

    /**
     * Руль влево на [degrees] градусов
     */
    fun wheelToLeft(degrees: Int)
}

fun commonWheelToRight(
    wheelAngle: Int,
    degrees: Int
) : Int {
    if (degrees <= 0) return wheelAngle

    val newAngle = wheelAngle + degrees

    if (newAngle > MAX_DEGREE)
        return MAX_DEGREE

    return newAngle
}

fun commonWheelToLeft(
    wheelAngle: Int,
    degrees: Int
) : Int {
    if (degrees <= 0) return wheelAngle

    val newAngle = wheelAngle - degrees

    if (newAngle < MIN_DEGREE)
       return MIN_DEGREE

    return newAngle
}