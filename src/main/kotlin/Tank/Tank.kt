package Tank

interface Tank {
    fun getContents(): Int
    fun receiveFuel(liters: Int)
}

class OrdinaryTank: Tank {
    private var fuel: Int = 0
    override fun getContents(): Int = fuel

    override fun receiveFuel(liters: Int) {
        fuel += liters
    }
}

