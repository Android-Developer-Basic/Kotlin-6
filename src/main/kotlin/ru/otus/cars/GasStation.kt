package ru.otus.cars

import kotlin.random.Random

object GasStation {
    fun refuelCars(cars: List<Car>) {
        try {
            cars.forEach {
                println("До заправки - ${it.carOutput.getFuelContents()}")
            }

            cars.forEach {
                when (it.tankMouth) {
                    is PetrolMouth -> (it.tankMouth as PetrolMouth).fuelPetrol(100)
                    is LpgMouth -> (it.tankMouth as LpgMouth).fuelLpg(100)
                }
            }

            cars.forEach {
                println("После заправки - ${it.carOutput.getFuelContents()}")
            }
        } catch (e: Exception) {
            println(e)
            println("Ошибка заправки")
        }
    }
}