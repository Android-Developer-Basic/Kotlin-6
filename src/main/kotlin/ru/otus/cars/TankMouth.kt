package ru.otus.cars

enum class MouthState {
    OPEN, CLOSE
}

sealed class TankMouth {
    /**
     * Доступ к баку имеет только горловина. Бак создаеться совместно с горловиной
     */
    protected lateinit var tank : Tankable
    private var mouthState = MouthState.CLOSE.ordinal
    open fun open() {
        mouthState = MouthState.OPEN.ordinal
    }
    open fun close() {
        mouthState = MouthState.OPEN.ordinal
    }
    fun getContents(): Int {
        return tank.getContents()
    }
    fun getMouthState() : Int {
        return mouthState
    }
    fun checkFuelSystem() : Boolean {
        return mouthState == MouthState.OPEN.ordinal || tank.getContents() == 0
    }
    open fun receiveFuel(liters: Int) {
        if (mouthState != MouthState.OPEN.ordinal)
            throw IllegalStateException("Горловина бака закрыта!")
        tank.receiveFuel(liters)
    }
}

class LpgTankMouth() : TankMouth() {
    init {
        tank = Tank(this)
    }
    override fun open() {
        super.open()
        println("Открыт клапан газавого бака!")
    }
    override fun close() {
        super.open()
        println("Закрыт клапан газавого бака, можно ехать")
    }
    override fun receiveFuel(liters: Int) {
        open()
        super.receiveFuel(liters)
        close()
        println("Было заправлено $liters кубометров газа")
    }
}

class PetrolTankMouth() : TankMouth() {
    init {
        tank = Tank(this)
    }
    override fun open() {
        super.open()
        println("Открыт лючок бензобака бака!")
    }
    override fun close() {
        println("Закрыт закрыт лючок бензобака, можно ехать")
    }
    override fun receiveFuel(liters: Int) {
        open()
        tank.receiveFuel(liters)
        close()
        println("Было заправлено $liters литров бензина")
    }
}