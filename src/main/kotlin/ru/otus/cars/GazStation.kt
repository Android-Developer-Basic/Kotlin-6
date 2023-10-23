package ru.otus.cars

import java.lang.RuntimeException

interface GazStation {
  fun fillCar(car: Car, liters: Int)
}

class GazStationImpl: GazStation {
  override fun fillCar(car: Car, liters: Int) {
    try {
      when (car.tankMouth) {
        is PetrolMouth -> (car.tankMouth as PetrolMouth).apply {
          open()
          fuelPetrol(liters)
          println("Залили $liters литров бензина")
          close()
        }
        is LpgMouth -> (car.tankMouth as LpgMouth).apply {
          open()
          fuelLpg(liters)
          println("Залили $liters литров газа")
          close()
        }
        else -> throw FuelNotSupportedException()
      }
    } catch (e: ExplodingTankException) {
      val tankFuelType = when (car.tankMouth) {
        is PetrolMouth -> "бензином"
        is LpgMouth -> "газом"
        else -> throw FuelNotSupportedException()
      }
      println("Бак с $tankFuelType взорвался! Бак ремонтируется")
    }
  }
}

class FuelNotSupportedException: RuntimeException()
