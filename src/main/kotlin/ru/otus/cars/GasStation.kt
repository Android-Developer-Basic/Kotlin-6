package ru.otus.cars

import javax.swing.text.html.parser.DTDConstants.MODEL

object GasStation {
    fun carFilling(cars: List<Car>) {
        try {
            cars.forEach {
                println("Уровень топлива:  ${it.carOutput.getFuelContents()}")
            }

            cars.forEach {
                when (it.tankMouth) {
                    is TankMouth.PetrolMouth -> (it.tankMouth as TankMouth.PetrolMouth).fuelPetrol(
                        10
                    )

                    is TankMouth.LpgMouth -> (it.tankMouth as TankMouth.LpgMouth).fuelLpg(20)
                }
            }

            cars.forEach {
                println("Уровень топлива после заправки: ${it.carOutput.getFuelContents()}")
            }

        } catch (e: Exception) {
            println("Бак взорвался(((")
        }
    }
}
