package ru.otus.cars.mouth

import ru.otus.cars.tank.Tank

class LpgMouthImpl(tank: Tank): TankMouth(tank) {
    override fun open() {
       println("tank is opened")
    }

    override fun close() {
        println("tank is closed")
    }

}
