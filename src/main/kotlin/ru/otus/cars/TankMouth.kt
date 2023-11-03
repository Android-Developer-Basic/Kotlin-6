package ru.otus.cars

sealed class TankMouth {
    abstract fun open()
    abstract fun close()

    open class LpgMouth: TankMouth() {
        open fun fuelLpg(liters: Int) {}
        override fun open() {
            println("газобак открыт")
        }

        override fun close() {
            println("газобак закрыт")
        }
    }

    open class PetrolMouth: TankMouth() {
        open fun fuelPetrol(liters: Int) {}
        override fun open() {
            println("бензобак открыт")
        }

        override fun close() {
            println("бензобак закрыт")
        }
    }
}