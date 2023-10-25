package ru.otus.cars

interface Tank {

    val mouth: TankMouth

    fun getContents(): Int

    fun receiveFuel(liters: Int)
}

abstract class TankImplementation : Tank {
    private var fuelLevel: Int = 0

    override fun getContents(): Int = fuelLevel

    override fun receiveFuel(liters: Int) {
        fuelLevel += liters
    }
}

class PetrolTank: TankImplementation() {
    override val mouth: TankMouth = PetrolMouth(this)
}

class SimpleLpgMouth: TankImplementation() {
    override val mouth: TankMouth = LpgMouth(this)
}

abstract class ExplodingTank : Tank {
    override fun getContents(): Int = 0

    override fun receiveFuel(liters: Int) {
        throw IllegalStateException("Error receive fuel")
    }
}

class ExplodingPetrolTank: ExplodingTank() {
    override val mouth: TankMouth = PetrolMouth(this)
}

class ExplodingLpgMouth: ExplodingTank() {
    override val mouth: TankMouth = LpgMouth(this)
}
