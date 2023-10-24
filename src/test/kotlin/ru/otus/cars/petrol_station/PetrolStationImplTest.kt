package ru.otus.cars.petrol_station

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import ru.otus.cars.*

class PetrolStationImplTest{
    @Test
    fun fillTaz(){
        val taz = Togliatti.buildTaz()
        assertThrows<IllegalStateException>(message = "Бак взорвался") {
            taz.mouth.fuel(10)
        }
    }

    @Test
    fun fillVaz2107(){
        val actual = Togliatti.buildCar(Car.Plates("123", 77))
        PetrolStationImpl().fillCar(actual.mouth, 30)

        Assertions.assertEquals(30, actual.carOutput.getFuelContents())
    }

    @Test
    fun patrolStationFillListCar(){
        val cars = listOf(
            Vaz2107.build(Car.Plates("123", 77)),
            Vaz2108.build(Car.Plates("321", 76)),
            Taz
        )

        PetrolStationImpl().fillCar(cars[0].mouth, 20)
        Assertions.assertEquals(20, cars[0].carOutput.getFuelContents())

        PetrolStationImpl().fillCar(cars[1].mouth,10)
        Assertions.assertEquals(10, cars[1].carOutput.getFuelContents())

        assertThrows<IllegalStateException>(message = "Бак взорвался") {
            PetrolStationImpl().fillCar(cars[2].mouth,20)
        }
    }
}