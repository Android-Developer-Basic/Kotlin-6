package ru.otus.cars

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import ru.otus.cars.Car.Companion.MAX_DEGREE
import ru.otus.cars.Car.Companion.MIN_DEGREE

//carOutput is used because these are getCurrentWheelAngle and getCurrentSpeed random numbers
class TogliattiTest {
    @Test
    fun buildCarDefault() {
        val actual = Togliatti.buildCar(Car.Plates("123", 77))
        val carOutput = actual.carOutput
        val expect = "Vaz2107(plates=Plates(number=123, region=77), wheelAngle=${carOutput.getCurrentWheelAngle()}, currentSpeed=${carOutput.getCurrentSpeed()})"

        assertEquals(expect, actual.toString())
    }

    @Test
    fun buildCarRequiredModel(){
        val actual1 = Togliatti.buildCar(Vaz2107, Car.Plates("123", 77))
        val carOutput1 = actual1.carOutput
        val expect1 = "Vaz2107(plates=Plates(number=123, region=77), wheelAngle=${carOutput1.getCurrentWheelAngle()}, currentSpeed=${carOutput1.getCurrentSpeed()})"
        assertEquals(expect1, actual1.toString())

        val actual2 = Togliatti.buildCar(Vaz2108, Car.Plates("321", 78))
        val carOutput2 = actual2.carOutput
        val expect2 = "Vaz2108(plates=Plates(number=321, region=78), wheelAngle=${carOutput2.getCurrentWheelAngle()}, currentSpeed=${carOutput2.getCurrentSpeed()})"
        assertEquals(expect2, actual2.toString())
    }

    @Test
    fun wheelToRightDegreeLessZero() {
        val actual1 = Togliatti.buildCar(Vaz2107, Car.Plates("123", 77))
        actual1.wheelToRight(-10)
        assertEquals(0, actual1.carOutput.getCurrentWheelAngle())
        actual1.wheelToRight(0)
        assertEquals(0, actual1.carOutput.getCurrentWheelAngle())

        val actual2 = Togliatti.buildCar(Vaz2108, Car.Plates("321", 78))
        val currentWheelAngle = actual2.carOutput.getCurrentWheelAngle()
        var expected = commonWheelToRight(currentWheelAngle,0)
        actual2.wheelToRight(0)
        assertEquals(expected, actual2.carOutput.getCurrentWheelAngle())
        actual2.wheelToRight(-20)
        expected = commonWheelToRight(currentWheelAngle,-20)
        assertEquals(expected, actual2.carOutput.getCurrentWheelAngle())
    }

    @Test
    fun wheelToLeftDegreeLessZero() {
        val actual1 = Togliatti.buildCar(Vaz2107, Car.Plates("123", 77))
        actual1.wheelToLeft(-10)
        assertEquals(0, actual1.carOutput.getCurrentWheelAngle())
        actual1.wheelToLeft(0)
        assertEquals(0, actual1.carOutput.getCurrentWheelAngle())

        val actual2 = Togliatti.buildCar(Vaz2108, Car.Plates("321", 78))
        val currentWheelAngle = actual2.carOutput.getCurrentWheelAngle()
        var expected = commonWheelToLeft(currentWheelAngle,0)
        actual2.wheelToLeft(0)
        assertEquals(expected, actual2.carOutput.getCurrentWheelAngle())
        actual2.wheelToLeft(-20)
        expected = commonWheelToRight(currentWheelAngle,-20)
        assertEquals(expected, actual2.carOutput.getCurrentWheelAngle())
    }

    @Test
    fun wheelToRightMax() {
        val actual1 = Togliatti.buildCar(Vaz2107, Car.Plates("123", 77))
        actual1.wheelToRight(MAX_DEGREE)
        assertEquals(MAX_DEGREE, actual1.carOutput.getCurrentWheelAngle())
        actual1.wheelToRight(MAX_DEGREE)
        assertEquals(MAX_DEGREE, actual1.carOutput.getCurrentWheelAngle())

        val actual2 = Togliatti.buildCar(Vaz2108, Car.Plates("321", 78))
        val currentWheelAngle = actual2.carOutput.getCurrentWheelAngle()
        var expected = commonWheelToRight(currentWheelAngle,MAX_DEGREE)
        actual2.wheelToRight(MAX_DEGREE)
        assertEquals(expected, actual2.carOutput.getCurrentWheelAngle())
        expected = commonWheelToRight(actual2.carOutput.getCurrentWheelAngle(), MAX_DEGREE)
        actual2.wheelToRight(MAX_DEGREE)
        assertEquals(expected, actual2.carOutput.getCurrentWheelAngle())
    }

    @Test
    fun wheelToLeftMin() {
        val actual1 = Togliatti.buildCar(Vaz2107, Car.Plates("123", 77))
        actual1.wheelToLeft(MAX_DEGREE)
        assertEquals(MIN_DEGREE, actual1.carOutput.getCurrentWheelAngle())
        actual1.wheelToLeft(MAX_DEGREE)
        assertEquals(MIN_DEGREE, actual1.carOutput.getCurrentWheelAngle())

        val actual2 = Togliatti.buildCar(Vaz2108, Car.Plates("321", 78))
        val currentWheelAngle = actual2.carOutput.getCurrentWheelAngle()
        var expected = commonWheelToLeft(currentWheelAngle, MAX_DEGREE)
        actual2.wheelToLeft(MAX_DEGREE)
        assertEquals(expected, actual2.carOutput.getCurrentWheelAngle())
        expected = commonWheelToLeft(actual2.carOutput.getCurrentWheelAngle(), MAX_DEGREE)
        actual2.wheelToLeft(MAX_DEGREE)
        assertEquals(expected, actual2.carOutput.getCurrentWheelAngle())
    }
}