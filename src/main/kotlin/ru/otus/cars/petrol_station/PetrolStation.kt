package ru.otus.cars.petrol_station

import ru.otus.cars.tank.TankMouth

interface PetrolStation {
    fun fillCar(tankMouth: TankMouth, litres: Int)
}

class PetrolStationImpl : PetrolStation{
    override fun fillCar(
        tankMouth: TankMouth, litres: Int
    ) {
        tankMouth.fuel(litres)
    }
}