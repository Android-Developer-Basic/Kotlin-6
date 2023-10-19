package ru.otus.cars

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

class ExplosiveTank : Tank {

    override fun getContents(): Int = 0

    override fun receiveFuel(liters: Int) = throw TankExplodedException("Бак взорвался")
}

class TankExplodedException(message: String) : RuntimeException(message)