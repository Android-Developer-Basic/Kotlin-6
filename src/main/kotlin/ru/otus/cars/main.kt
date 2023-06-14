package ru.otus.cars

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
    println("\nЗаправляем семёрочку!")
    refuel()
    println("\nЗаправляем кортеж: семёрка, восьмёрка, восьмёрка...")
    refuelCortage()
    println("\nЗаправляем Таз...")
    refuelTaz()
}
//создаём экземпляр "семёрки"
val vaz2107Buryat = Togliatti.buildCar(Car.Plates("511",103))
//создаём экземпляр "восьмёрки"
val vaz2108Yaroslavecc = Vaz2108.build(Car.Plates("470", 76))
//создаём ещё один экземпляр "восьмёрки"
val vaz2108Kamchedal = Vaz2108.build(Car.Plates("288", 41))
//пригоняем Таз
val vaz210Taz = Taz
//создаём очередь из автомобилей
val carsCortege = listOf(vaz2107Buryat, vaz2108Yaroslavecc, vaz2108Kamchedal)

/**
 * Заправляем один автомобиль
 */
fun refuel() = GasStation.refuelCar(vaz2107Buryat, 17)
fun refuelTaz() = GasStation.refuelCar(vaz210Taz, 10)


/**
 * Заправляем вереницу автомобилей
 */
fun refuelCortage() = GasStation.refuelMotorcade(carsCortege, 70)

/**
 * Заправляем Таз
 */
//fun refuelTaz() = GasStation.refuelCar(vaz210Taz, 5)

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