package ru.otus.cars.tank

interface Fuel

@JvmInline
value class LpgLiters(val value: Int) : Fuel

@JvmInline
value class PetrolLiters(val value: Int) : Fuel