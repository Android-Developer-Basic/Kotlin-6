package ru.otus.cars

class PetrolMouth(tank: Tank): TankMouth(tank) {
    override fun open() {
        println("mouth is opened")
    }

    override fun close() {
        println("mouth is closed")
    }
}