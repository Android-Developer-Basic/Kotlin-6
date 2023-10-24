package ru.otus.cars

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.assertThrows

class TazTest {

    @Test
    fun getPlates() {
        val taz = Togliatti.buildTaz()
        assertThrows<IllegalStateException>(message = "Тачка без номеров") {
            taz.plates
        }
    }

    @Test
    fun getCarOutput() {
        val taz = Togliatti.buildTaz()
        assertThrows<IllegalStateException>(message = "Приборы сняты") {
            taz.carOutput
        }
    }

    @Test
    fun wheelToRight() {
        val taz = Togliatti.buildTaz()
        assertThrows<IllegalStateException>(message = "Руля нет") {
            taz.wheelToRight(1)
        }
    }

    @Test
    fun wheelToLeft() {
        val taz = Togliatti.buildTaz()
        assertThrows<IllegalStateException>(message = "Руля нет") {
            taz.wheelToLeft(-1)
        }
    }

    @Test
    fun mouth() {
        val taz = Togliatti.buildTaz()
        assertThrows<IllegalStateException>(message = "Бак взорвался") {
            taz.mouth
        }
    }
}