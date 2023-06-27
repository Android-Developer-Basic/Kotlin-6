package ru.otus.cars.tank


sealed class TankMouth {
    fun open() {
        println("Открыть бак")
    }
    fun close() {
        println("Закрыть бак")
    }

}
class PetrolMouth(
    /**
     * Ссылка на бак горловины
     */
    private val tank: Tank
) : TankMouth() {

    fun fillWithPetrol(liters: PetrolLiters) {
        open()
        if (liters.value > 0) {
            tank.fuel += liters.value
            println("Залито ${liters.value}л бенза")
        }
        close()
    }
}

class LpgMouth(
    /**
     * Ссылка на бак горловины
     */
    private val tank: Tank
) : TankMouth() {

    fun fillWithLpg(liters: LpgLiters) {
        open()
        if (liters.value > 0) {
            tank.fuel += liters.value
            println("Залито ${liters.value}л газа")
        }
        close()
    }
}