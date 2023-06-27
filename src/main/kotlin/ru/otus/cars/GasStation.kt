package ru.otus.cars

import ru.otus.cars.tank.LpgLiters
import ru.otus.cars.tank.LpgMouth
import ru.otus.cars.tank.PetrolLiters
import ru.otus.cars.tank.PetrolMouth
import ru.otus.cars.tank.TankMouth
import java.lang.Exception

interface GasStation {
    fun fillCar(car: Car, liters: Int)
}

class GasStationImpl : GasStation {

    override fun fillCar(car: Car, liters: Int) {
        val fillTank: (TankMouth, Int) -> Unit =
            { mouth: TankMouth, liters: Int ->
                when (mouth) {
                    is LpgMouth -> mouth.fillWithLpg(LpgLiters(liters))
                    is PetrolMouth -> mouth.fillWithPetrol(PetrolLiters(liters))
                }
            }

        try {
            when (car) {
                is Vaz2107 -> fillTank(car.tankMouth, liters)
                is Vaz2108 -> fillTank(car.tankMouth, liters)
                Taz -> Taz.tankMouth.open()
            }
        } catch (e: Exception) {
            e.printStackTrace()
            println("Всё норм, без паники!")
        }
    }
}