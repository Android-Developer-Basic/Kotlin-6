package ru.otus.cars

abstract class TankMouth {
    abstract fun open();
    abstract fun close();
}

class PetrolMouth: TankMouth(){
    override fun open() {
    }
    override fun close() {
    }
    fun fuelPetrol(liters:Int){}
}

class LpgMouth: TankMouth(){
    override fun open() {
    }
    override fun close() {
    }
    fun fuelLpg(liters:Int){
    }
}