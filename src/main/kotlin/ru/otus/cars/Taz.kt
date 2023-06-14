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
     * Следит за машиной
     */
    override val carOutput: CarOutput
        get() = throw IllegalStateException("Приборы сняты")

    /**
     * Бензобак
     */
    private val tank: Tank = object : Tank {
        /**
         * Горловина бачка
         */
        override val mouth: TankMouth = LpgMouth.create(this)

        /**
         * Получить кол-во залитых литров
         */
        override fun getContents(): Int = 0

        /**
         * Заправить несколько литров
         */
        override fun receiveFuel(liters: Int) {
            throw Error("Бак взорвался!")
        }
    }

    /**
     * Горловина бензобака
     */
    override val tankMouth: TankMouth
        get() = tank.mouth

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

}