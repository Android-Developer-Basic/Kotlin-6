package ru.otus.cars

interface Tank {

    var capacity: Int

    fun getContents(): Int

    fun receiveFuel(liters: Int)
}
