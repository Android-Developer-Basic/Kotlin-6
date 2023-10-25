package ru.otus.cars.mouth

import ru.otus.cars.tank.Tank

class PetrolMouthImpl(tank: Tank): TankMouth(tank) {
    override fun open() {
        println("mouth is opened")
    }

    override fun close() {
        println("mouth is closed")
    }
}