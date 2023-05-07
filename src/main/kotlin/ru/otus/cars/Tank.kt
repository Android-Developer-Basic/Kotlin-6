package ru.otus.cars

sealed class Tank {
    private var fuel = 0

    open fun getContents(): Int {
        return fuel
    }

    open fun receiveFuel(liters: Int) {
        fuel += liters
        println("Залито $liters литров топлива")
    }
}

class FuelTank: Tank()