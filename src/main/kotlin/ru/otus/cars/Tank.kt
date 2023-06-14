package ru.otus.cars
/**
 * Бак
 */
interface Tank {
    /**
     * Горловина
     */
    val mouth: TankMouth
    /**
     * Увеличивает содержимое бака на несколько литров
     */
    fun receiveFuel(liters: Int)
    /**
     * Возвращает содержимое бака в литрах
     */
    fun getContents(): Int
}
/**
 * Рабочий бак
 */
class WorkingTank private constructor(): Tank {
    /**
     * Сборщик бака
     */
    companion object {
        /**
         * Создаёт бак
         */
        fun create(mouth: TankMouth.Builder): Tank = WorkingTank().apply {
            this.mouth = mouth.create(this)
        }
    }

    /**
     * Максимальный объём бака
     */
    private val maxContents: Int = 50

    /**
     * Содержимое
     */
    private var contents: Int = 0

    /**
     * Горловина бачка
     */
    override lateinit var mouth: TankMouth
        private set

    /**
     * Получить кол-во залитых литров
     */
    override fun getContents(): Int = contents

    /**
     * Заправить несколько литров
     */
    override fun receiveFuel(liters: Int) {
        contents = when {
            contents + liters < maxContents -> {
                contents + liters
            }
            else -> maxContents
        }
    }
}