package ru.otus.cars

import kotlin.random.Random

fun main() {
    println("\n===> drive cars...")
    driveCars()
    println("\n===> inner test...")
    innerNestedCheck()
    println("\n===> garage make...")
    garageMake()
    println("\n===> model special...")
    modelSpecial()
    println("\n===> model make...")
    modelMake()
    println("\n===> model Заправка...")
    receiveFuel()
}

//Заправка
fun fuelStation(car: Car){
    try {
        when (car.tankMouth){
            is PetrolMouth -> (car.tankMouth as PetrolMouth).fuelPetrol(Random.nextInt(0, 60))
            is LpgMouth -> (car.tankMouth as LpgMouth).fuelLpg(Random.nextInt(0, 60))
        }
    } catch (e: IllegalStateException) {
        println("Заправка обноружила $e, и ликвидировала его")
    }
}

fun receiveFuel() {
    val vazList = listOf(
        Vaz2107.build(Car.Plates("123", 77)),
        Vaz2108.build(Car.Plates("555", 82)),
        Taz
    )
    println("Создали машины:")
    vazList.forEach {println(it)}
    println("Загнали на заправку:")
    vazList.forEach {fuelStation(it)}
    println("Проверка уровня топлива:")
    vazList.forEach {
        when(it){
            is Vaz2107 -> println("Топлива проверки проверки: ${it.VazOutput().getFuelContents()}")
            is Vaz2108 -> println("Топлива проверки проверки: ${it.VazOutput().getFuelContents()}")
            Taz -> println("нет бака")
        }
    }
}

fun driveCars() {
    val vaz1 = Togliatti.buildCar(Car.Plates("123", 77))
    val vaz2 = Togliatti.buildCar(Car.Plates("321", 78))

    println("Экземпляры класса имеют разное внутреннее состояние:")
    vaz1.wheelToRight(10)
    println(vaz1.toString()) // Выводит 10 и случайную скорость
    vaz2.wheelToLeft(20)
    println(vaz2.toString()) // Выводит -20 и случайную скорость
}

fun innerNestedCheck() {
    val vaz = Vaz2107.build(Car.Plates("123", 77))
    val output = vaz.VazOutput() // Создаем новый объект ИЗ ЭКЗЕМПЛЯРА МАШИНЫ

    println("Скорость до проверки: ${output.getCurrentSpeed()}") // Выводит 0
    Vaz2107.test(vaz) // Газуем...
    println("Скорость после проверки: ${output.getCurrentSpeed()}") // Выводит случайную скорость
}

fun garageMake() {
    val maker = "Дядя Вася"
    val garage = object : CarFactory {
        override fun buildCar(plates: Car.Plates): Car {
            println("Запил Жигулей у: $maker...")
            println("Машину не проверяем... и в продакшн...")
            return Vaz2107.build(plates)
        }
    }

    val vaz = garage.buildCar(Car.Plates("500", 50))
    println(vaz.toString())
}

fun modelSpecial() {
    val cars = listOf(
        Vaz2107.build(Car.Plates("123", 77)),
        Vaz2108.build(Car.Plates("321", 78)),
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
    val vaz1 = Togliatti.buildCar(Vaz2107, Car.Plates("123", 77))
    val vaz2 = Togliatti.buildCar(Vaz2108, Car.Plates("321", 78))

    println("Создали машины:")
    println(vaz1.toString()) // 2107
    println(vaz2.toString()) // 2108
}