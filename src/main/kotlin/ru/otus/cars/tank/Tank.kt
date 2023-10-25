package ru.otus.cars.tank

import java.lang.IllegalArgumentException

interface Tank {

     var capacity: Int

    fun getContents(): Int

    fun receiveFuel(liters: Int)
}

class PetrolTankImpl(override var capacity: Int = 0) : Tank {
    private val maxValue = 52
    override fun getContents(): Int {
        return capacity
    }

    override fun receiveFuel(liters: Int) {
        if (capacity + liters > maxValue) throw IllegalArgumentException("Ouch")
        capacity += liters
    }
}

class LpgTankImpl(override var capacity: Int = 0) : Tank {
    private val maxValue = 32
    override fun getContents(): Int {
        return capacity
    }

    override fun receiveFuel(liters: Int) {
        if (capacity + liters > maxValue) throw IllegalArgumentException("Ouch")
        capacity += liters
    }

}

class ExplosiveTankImpl(override var capacity: Int = 0) : Tank {
    override fun getContents(): Int {
        return capacity
    }

    override fun receiveFuel(liters: Int) {
        throw IllegalStateException("tank has blew up")
    }
}

