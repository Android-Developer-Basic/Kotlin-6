package ru.otus.cars

class LpgMouth(tank: Tank): TankMouth(tank) {
    override fun open() {
        println("tank is opened")
    }

    override fun close() {
        println("tank is closed")
    }

}