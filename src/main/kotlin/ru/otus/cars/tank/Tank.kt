package ru.otus.cars.tank

interface Tank {

    fun getContents(): Int
    fun receiveFuel(liters: Int)

}

class NormalTank : Tank {

    private var fuel: Int = 0

    override fun getContents(): Int = fuel

    override fun receiveFuel(liters: Int) {
        fuel += liters
    }
}