package ru.otus.cars

fun main() {
    //innerNestedCheck()
    addFuelCollectionCars()
}

fun driveCars() {
    val vaz1 = Togliatti.buildCar(Car.Plates("123", 77), LpgMouth())
    val vaz2 = Togliatti.buildCar(Car.Plates("321", 78), LpgMouth())

    println("Экземпляры класса имеют разное внутреннее состояние:")
    vaz1.wheelToRight(10)
    println(vaz1.toString()) // Выводит 10 и случайную скорость
    vaz2.wheelToLeft(20)
    println(vaz2.toString()) // Выводит -20 и случайную скорость

}

fun addFuelCollectionCars() {
    val cars = listOf(
        Vaz2107.build(Car.Plates("555", 77), LpgMouth()),
        Vaz2108.build(Car.Plates("321", 78), PetrolMouth())
    )
    checkFuel(cars)
    FuelStation.addFuel(cars, 30)
    checkFuel(cars)
}

fun checkFuel(list: List<Car>) {
    for(car in list) {
        println("Текущий уровень топлива: ${car.carOutput.getFuelContents()}")
    }
}


fun innerNestedCheck() {
    val vaz = Vaz2107.build(Car.Plates("123", 77), LpgMouth())
    vaz.carOutput.getCurrentSpeed()
    println("Топливо до заправки: ${vaz.carOutput.getFuelContents()}")
    FuelStation.addFuel(vaz, 15)
    println("Топливо после заправки: ${vaz.carOutput.getFuelContents()}")
    val output = vaz.VazOutput() // Создаем новый объект ИЗ ЭКЗЕМПЛЯРА МАШИНЫ

    FuelStation.addFuel(Taz, 15)
    println("Скорость до проверки: ${output.getCurrentSpeed()}") // Выводит 0
    Vaz2107.test(vaz) // Газуем...
    println("Скорость после проверки: ${output.getCurrentSpeed()}") // Выводит случайную скорость
}

fun garageMake() {
    val maker = "Дядя Вася"
    val garage = object : CarFactory {
        override fun buildCar(plates: Car.Plates, tankMouth: TankMouth): Car {
            println("Запил Жигулей у: $maker...")
            println("Машину не проверяем... и в продакшн...")
            return Vaz2107.build(plates, tankMouth)
        }
    }

    val vaz = garage.buildCar(Car.Plates("500", 50), LpgMouth())
    println(vaz.toString())
}

fun modelSpecial() {
    val cars = listOf(
        Vaz2107.build(Car.Plates("123", 77), LpgMouth()),
        Vaz2108.build(Car.Plates("321", 78), LpgMouth()),
        Taz
    )

    cars.forEach { car ->
        when(car) {
            is Vaz2107 -> car.drdrdrdrdr()
            is Vaz2108 -> car.zhzhzhzh()
            Taz -> println("Таз больше не ездит!")
        }
    }
}

fun modelMake() {
    val vaz1 = Togliatti.buildCar(Vaz2107, Car.Plates("123", 77), LpgMouth())
    val vaz2 = Togliatti.buildCar(Vaz2108, Car.Plates("321", 78), PetrolMouth())

    println("Создали машины:")
    println(vaz1.toString()) // 2107
    println(vaz2.toString()) // 2108
}