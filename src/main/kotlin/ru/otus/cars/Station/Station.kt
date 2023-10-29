package ru.otus.cars.Station

import Tank.LpgMouth
import Tank.PetrolMouth
import ru.otus.cars.Car
import ru.otus.cars.Taz
import ru.otus.cars.Vaz2107
import ru.otus.cars.Vaz2108

class Station {
    private fun fillFuel(car: Car) {
        try {
            when (car.mouth) {
                is PetrolMouth -> (car.mouth as PetrolMouth).apply {
                    fuelPetrol(20)
                }
                is LpgMouth -> (car.mouth as LpgMouth).apply {
                    fuelLpg(30)
                }
            }
        } catch (e: IllegalStateException) {
            println("Похоже у вас ТАЗ, советую машину на помойку")
        }
    }

    fun carsFromStation(): List<Car> {
        val cars = listOf(
            Vaz2107.build(Car.Plates("771", 34)),
            Vaz2108.build(Car.Plates("772", 34)),
            Taz
        )
        printCarsFuel(cars)
        cars.forEach {
            fillFuel(it)
        }
        printCarsFuel(cars)
        return cars
    }

    private fun printCarsFuel(cars: List<Car>) {
        cars.forEach {
            try {
                println("Топлива в машине ${it.carOutput.getFuelContents()}")
            } catch (e: Exception) {
                println(e)
            }
        }
    }
}

fun main() {
    val station = Station()
    station.carsFromStation()
}