package ru.otus.cars

class GasStation {
    fun fuel(car:Car,fuel: Int) {
        try {
            println("Заправляем ${car.carOutput.getModel()}")
        } catch (e: Exception) {
            println("Заправляем машинку")
        }
        try {
            when (car.carTank.getType()) {
                FuelType.GAS -> fuelGas(car, fuel)
                FuelType.PETROL -> fuelPetrol(car, fuel)
                else -> car.carTank.recieveFuel(fuel) // авось зальется :-)
            }
        } catch (e: Exception) {
            println("Машина не подходит для этой заправки")
        }
    }
    fun fuelGas(car: Car,fuel: Int)=car.carTank.recieveFuel(fuel)
    fun fuelPetrol(car: Car,fuel: Int)=car.carTank.recieveFuel(fuel)
}