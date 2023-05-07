package ru.otus.cars

/**
 * Тачка не едет
 */
object Taz : Car {
    /**
     * Номерной знак
     */
    override val plates: Car.Plates
        get() = throw IllegalStateException("Тачка без номеров")

    /**
     * Топливная горловина
     */
    override val mouth: LpgMouth = LpgMouth(TazTank)

    object TazTank: Tank() {
        override fun receiveFuel(liters: Int) {
            throw IllegalStateException("Бак взорвался")
        }
    }

    /**
     * Следит за машиной
     */
    override val carOutput: CarOutput
        get() = throw IllegalStateException("Приборы сняты")

    /**
     * Руль вправо на [degrees] градусов
     */
    override fun wheelToRight(degrees: Int) {
        throw IllegalStateException("Руля нет")
    }

    /**
     * Руль влево на [degrees] градусов
     */
    override fun wheelToLeft(degrees: Int) {
        throw IllegalStateException("Руля нет")
    }

    override fun receiveFuel(liters: Int) { mouth.fuelLpg(liters) }
}