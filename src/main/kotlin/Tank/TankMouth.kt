package Tank

abstract class TankMouth(protected val tank: Tank) {
    abstract fun open()
    abstract fun close()
}

class PetrolMouth(tank: Tank): TankMouth(tank) {
    override fun open() {
        println("Бензиновый бак открыт")
    }

    override fun close() {
        println("Бензиновый бак закрыт")
    }

    fun fuelPetrol(liters: Int) {
        open()
        tank.receiveFuel(liters)
        close()
    }

}

class LpgMouth(tank: Tank): TankMouth(tank) {
    override fun open() {
        println("Газовый бак открыт")
    }

    override fun close() {
        println("Газовый бак закрыт")
    }

    fun fuelLpg(liters: Int) {
        open()
        tank.receiveFuel(liters)
        close()
    }
}