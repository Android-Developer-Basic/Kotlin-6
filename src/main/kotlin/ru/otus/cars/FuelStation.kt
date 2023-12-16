package ru.otus.cars

class FuelStation () {
    companion object{
        fun addFuel(car: Car, litr: Int) {
            car.tankMouth.open()
            if (car == Taz) throw IllegalStateException("Бак у Таза взорвался")
            when(car.tankMouth) {
                is LpgMouth -> (car.tankMouth as LpgMouth).fuelLpg(litr)
                is PetrolMouth -> (car.tankMouth as PetrolMouth).fuelPetrol(litr)
            }
            car.tankMouth.close()
        }
        fun addFuel(list: List<Car>, litr: Int) {
            for(car in list) {
                car.tankMouth.open()
                if (car == Taz) throw IllegalStateException("Бак у Таза взорвался")
                when(car.tankMouth) {
                    is LpgMouth -> (car.tankMouth as LpgMouth).fuelLpg(litr)
                    is PetrolMouth -> (car.tankMouth as PetrolMouth).fuelPetrol(litr)
                }
                car.tankMouth.close()
            }
        }
    }
}