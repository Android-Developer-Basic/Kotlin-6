package ru.otus.cars

class PetrolMouth() : TankMouth() {
    override fun open() {
        println("Открыли бак")
    }

    override fun close() {
        println("Закрыли бак")
    }

    fun fuelPetrol(litres: Int, updateFuel: UpdateFuel) {
        updateFuel(litres)
        println("Выдано $litres литров")
    }
}