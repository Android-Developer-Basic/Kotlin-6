package ru.otus.cars

import ru.otus.cars.mouth.LpgMouthImpl
import ru.otus.cars.mouth.PetrolMouthImpl

object GasStation {

    fun fuelUpCars(cars: List<Car>) {
        try {
            cars.forEach {
                when (it.tankMouth) {
                    is LpgMouthImpl -> it.tankMouth.fuelUp(100)
                    is PetrolMouthImpl -> it.tankMouth.fuelUp(250)
                }
            }
            cars.forEach {
                println(it)
            }
        } catch (e: Exception) {
            println("call 911")
        }
    }
}