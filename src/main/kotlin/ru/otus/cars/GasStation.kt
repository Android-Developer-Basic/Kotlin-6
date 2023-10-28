package ru.otus.cars

import kotlin.random.Random

class GasStation {
    /**
     * АЗС для заправки машины
     */
    companion object {
        fun refill(car: Car) {
            println("Заправляем машину: $car")
            car.tankMouth.open()
            val litres = Random.nextInt(10, 30)
            try {
                when (car.tankMouth) {
                    is LpgMouth -> {
                        (car.tankMouth as LpgMouth).fuelLpg(litres, car.updateFuel)
                    }
                    is PetrolMouth -> {
                        (car.tankMouth as PetrolMouth).fuelPetrol(litres, car.updateFuel)
                    }
                    else -> {
                        throw IllegalStateException("Не подходящего контакта с горловиной бака для заправки")
                    }
                }
                println("Заправлено ${car.carOutput.getFuelContents()} литров")
            }
            catch(e: Exception) {
                println("Проблема с заправкой! Но мы успели остановить процесс.")
                println("ОСТАНОВЛЕН: ${e.message}")
            }
            car.tankMouth.close()
            println("Машины после заправки: $car")
        }

        /**
         * Заправка нескольких а/м сразу
         */
        fun refill(listCars: List<Car>) {
            listCars.forEach { refill(it) }
        }
    }
}