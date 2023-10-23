package ru.otus.cars

import java.lang.RuntimeException

interface Tank {
  val mouth: TankMouth

  fun getContents(): Int

  fun receiveFuel(liters: Int): Unit
}

abstract class SimpleTank : Tank {
  private var fuelLevel: Int = 0

  override fun getContents(): Int = fuelLevel

  override fun receiveFuel(liters: Int) {
    fuelLevel += liters
  }
}

class SimplePetrolTank: SimpleTank() {
  override val mouth: TankMouth = PetrolMouth(this)
}

class SimpleLpgMouth: SimpleTank() {
  override val mouth: TankMouth = LpgMouth(this)
}

abstract class ExplodingTank : Tank {
  override fun getContents(): Int = 0

  override fun receiveFuel(liters: Int) {
    throw ExplodingTankException()
  }
}

class ExplodingPetrolTank: ExplodingTank() {
  override val mouth: TankMouth = PetrolMouth(this)
}

class ExplodingLpgMouth: ExplodingTank() {
  override val mouth: TankMouth = LpgMouth(this)
}

class ExplodingTankException : RuntimeException()
