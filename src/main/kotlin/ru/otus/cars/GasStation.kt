package ru.otus.cars

/**
 * Объект - заправка
 */

object GasStation {
    /**
     * Заправляем автомобиль
     */
    fun refuelCar(car: Car, liters: Int){
        car.tankMouth.open()
        when(car.tankMouth){
            is PetrolMouth ->{
                (car.tankMouth as PetrolMouth).fuelPetrol(liters)
                println("Колонка №1. Заправляем $liters литров бензина.")
            }
            is LpgMouth ->{
                (car.tankMouth as LpgMouth).fuelLpg(liters)
                println("Колонка №2. Заправляем $liters литров пропана.")
            }
        }
        car.tankMouth.close()
    }
    /**
     * Заправляем коллекцию автомобилей
     */
    private fun returnContent(car: Car){
        println("Авто c номером ${car.plates.number} регион ${car.plates.region} уровень топлива ${car.carOutput.getFuelContents()}")
    }
    /**
     * Заправляем коллекцию автомобилей
     */
    fun refuelMotorcade(motorcade: Collection<Car>, liters: Int){
        for (car in motorcade) {
            returnContent(car)
            refuelCar(car, liters)
            returnContent(car)
        }
    }
}