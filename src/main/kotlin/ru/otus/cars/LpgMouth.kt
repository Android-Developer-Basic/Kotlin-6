package ru.otus.cars

class LpgMouth() : TankMouth() {
    override fun open() {
        println("Открыли бак")
    }

    override fun close() {
        println("Закрыли бак")
    }

    fun fuelLpg(litres: Int, updateFuel: UpdateFuel) {
        updateFuel(litres)
        println("Выдано $litres литров")
    }
}