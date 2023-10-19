package ru.otus.cars

object GasStation {

    fun fillCar(car: Car, litres: Int) {
        try {
            when (car.mouth) {
                is PetrolMouth -> (car.mouth as PetrolMouth).fuelPetrol(litres)
                is LpgMouth -> (car.mouth as LpgMouth).fuelLpg(litres)
                else -> throw FuelNotSupportedException("На заправке нет такого топлива")
            }
        } catch (e: TankExplodedException) {
            println("${e.message}, но пожар потушен")
        }
    }

}

class FuelNotSupportedException(message: String) : RuntimeException(message)


fun getFilledCars(): List<Car> {
    val cars = listOf(
        Vaz2107.build(Car.Plates("С666СС", 63)),
        Vaz2108.build(Car.Plates("С666СС", 163)),
        Taz
    )
    printFuelState(cars)
    cars.forEach { GasStation.fillCar(it, 50) }
    printFuelState(cars)
    return cars
}

private fun printFuelState(cars: List<Car>) {
    cars.forEach {
        try {
            println("Топлива в баке ${it::class.simpleName}: ${it.carOutput.getFuelContents()}")
        } catch (e: Exception) {
            println("${it::class.simpleName}: ${e.message}")
        }
    }
}

fun main() {
    getFilledCars()
}