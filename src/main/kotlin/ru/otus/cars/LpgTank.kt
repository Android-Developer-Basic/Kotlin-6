package ru.otus.cars

class LpgTank (override var capacity: Int = 0) : Tank {
    private val maxValue = 32
    override fun getContents(): Int {
        return capacity
    }

    override fun receiveFuel(liters: Int) {
        if (capacity + liters > maxValue) throw IllegalArgumentException("Ouch")
        capacity += liters
    }

}
