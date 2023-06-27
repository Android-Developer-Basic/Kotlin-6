package ru.otus.cars

import ru.otus.cars.tank.LpgLiters
import ru.otus.cars.tank.LpgMouth
import ru.otus.cars.tank.PetrolLiters
import ru.otus.cars.tank.PetrolMouth
import ru.otus.cars.tank.Tank

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

    println("\n===> fill with a fuel...")
    getCarsFilled()
}

private fun getLpgTank() = object : Tank {
    override val mouth = LpgMouth(this)
    override var fuel: Int = 0

    override fun getContents(): Int {
        return fuel
    }

    override fun receiveFuel(litres: Int) {
        mouth.fillWithLpg(LpgLiters(litres))
    }
}

private fun getPetrolTank() = object : Tank {
    override val mouth = PetrolMouth(this)
    override var fuel: Int = 0

    override fun getContents(): Int {
        return fuel
    }

    override fun receiveFuel(litres: Int) {
        mouth.fillWithPetrol(PetrolLiters(litres))
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
    val vaz07 = Vaz2107.build(
        Car.Plates("123", 77),
        getLpgTank()
    )
    val output = vaz07.VazOutput() // Создаем новый объект ИЗ ЭКЗЕМПЛЯРА МАШИНЫ

    println("Скорость до проверки: ${output.getCurrentSpeed()}") // Выводит 0
    Vaz2107.test(vaz07) // Газуем...
    println("Скорость после проверки: ${output.getCurrentSpeed()}") // Выводит случайную скорость
}

fun garageMake() {
    val maker = "Дядя Вася"
    val garage = object : CarFactory {
        override fun buildCar(plates: Car.Plates): Car {
            println("Запил Жигулей у: $maker...")
            println("Машину не проверяем... и в продакшн...")
            return Vaz2107.build(plates, getLpgTank())
        }
    }

    val vaz = garage.buildCar(Car.Plates("500", 50))
    println(vaz.toString())
}

fun modelSpecial() {
    val cars = listOf(
        Vaz2107.build(Car.Plates("123", 77), getLpgTank()),
        Vaz2108.build(Car.Plates("321", 78), getPetrolTank()),
        Taz
    )

    cars.forEach { car ->
        when (car) {
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

fun getCarsFilled() {
    val cars = listOf(
        Vaz2107.build(Car.Plates("123", 77), getLpgTank()),
        Vaz2108.build(Car.Plates("321", 78), getPetrolTank()),
        Taz,
        Vaz2108.build(Car.Plates("777", 177), getLpgTank()),
    )

    val gasStation = GasStationImpl()

    println("Заправляем тачки:")

    cars.forEach { car ->
        println(car)
        gasStation.fillCar(car, 20)
        println(car)
    }
}