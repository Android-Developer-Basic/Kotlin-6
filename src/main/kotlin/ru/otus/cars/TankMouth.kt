package ru.otus.cars

sealed class TankMouth(private val tank: Tank) {

    fun open() {
        println("Открыта горловина")
    }

    fun close() {
        println("Закрыта горловина")
    }

    fun getContents(): Int {
        return tank.getContents()
    }
}

class PetrolMouth(private val tank: Tank): TankMouth(tank) {
    fun fuelPetrol(liters: Int) {
        open()
        tank.receiveFuel(liters)
        close()
    }
}

class LpgMouth(private val tank: Tank): TankMouth(tank) {
    fun fuelLpg(liters: Int) {
        open()
        tank.receiveFuel(liters)
        close()
    }
}