package ru.otus.cars

enum class FuelType(var type: String) {
    UNDEFINED("Не определено"),
    PETROL("Бензин"),
    GAS("Газ");
    override fun toString(): String {
        return type
    }
}

interface Tank {
    fun getContents(): Int
    fun recieveFuel(liters: Int)
    fun getType():FuelType
}

sealed class TankMouth: Tank {
    private var liters: Int=0
        set (value) {
            field+=value
            if (field<0) {
                field=0;
            }
        }
        get()=field

    protected var fuelType: FuelType = FuelType.UNDEFINED
        set (value) {
            if (field!=FuelType.UNDEFINED) {
                throw Exception("Fuel type already defined")
            }
            field=value
        }

    fun open() {
        println("Горловина открыта")
    }
    fun close() {
        println("Горловина закрыта")
    }

    override fun recieveFuel(liters: Int) {
        if (fuelType==FuelType.UNDEFINED) {
            throw Exception("Fuel type undefined, unable to fuel")
        }
        open()
        println("Заправка $liters литров ...")
        this.liters = this.liters.plus(liters)
        close()
    }

    override fun getContents(): Int = liters

    override fun getType(): FuelType = fuelType
}


open class PetrolMouth: TankMouth() {
    init {
        this.fuelType=FuelType.PETROL
    }
    fun fuelPetrol(liters: Int) {
        this.recieveFuel(liters)
    }
}

open class LpgMouth: TankMouth() {
    init {
        this.fuelType=FuelType.GAS
    }
    fun fuelLpg(liters: Int) {
        this.recieveFuel(liters)
    }
}


