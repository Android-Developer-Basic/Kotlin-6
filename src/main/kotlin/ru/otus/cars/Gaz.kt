package ru.otus.cars

interface Gaz {
    fun fill(car: Car, liters: Int)
}

class GazStation : Gaz {
    override fun fill(car: Car, liters: Int) {
        try {
            when (car.tankMouth) {
                is PetrolMouth -> (car.tankMouth as PetrolMouth).apply {
                    open()
                    fuelPetrol(liters)
                    println("Пополнили на $liters литров бензина")
                    close()
                }

                is LpgMouth -> (car.tankMouth as LpgMouth).apply {
                    open()
                    fuelLpg(liters)
                    println("Пополнили на $liters литров газа")
                    close()
                }

                else -> throw IllegalStateException()
            }
        } catch (exception: IllegalStateException) {
            val tankFuelType = when (car.tankMouth) {
                is PetrolMouth -> "бензином"
                is LpgMouth -> "газом"
                else -> throw IllegalStateException()
            }
            println("Бак с $tankFuelType взорвался")
        }
    }
}

