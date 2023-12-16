package ru.otus.cars

sealed class TankMouth {

    fun Builder(ITank: ITank) {
        this.ITank = ITank
    }

    protected lateinit var ITank: ITank

    private var opened: Boolean = true

    fun open() {
        opened = true
    }

    fun close() {
        opened = false
    }
}
class PetrolMouth : TankMouth() {

    fun fuelPetrol(litres: Int) {
        ITank.receiveFuel(litres)
    }

}
open class LpgMouth : TankMouth() {
    open fun fuelLpg(litres: Int) {
        ITank.receiveFuel(litres)
    }
}
