package com.leandro.test.Model

data class indicadores(
    val autor: String,
    val bitcoin: Bitcoin,
    val dolar: Dolar,
    val dolar_intercambio: DolarIntercambio,
    val euro: Euro,
    val fecha: String,
    val imacec: Imacec,
    val ipc: Ipc,
    val ivp: Ivp,
    val libra_cobre: LibraCobre,
    val tasa_desempleo: TasaDesempleo,
    val tpm: Tpm,
    val uf: Uf,
    val utm: Utm,
    val version: String
)

data class Bitcoin(
    val codigo: String,
    val fecha: String,
    val nombre: String,
    val unidad_medida: String,
    val valor: Double
)

data class Dolar(
    val codigo: String,
    val fecha: String,
    val nombre: String,
    val unidad_medida: String,
    val valor: Double
)

data class DolarIntercambio(
    val codigo: String,
    val fecha: String,
    val nombre: String,
    val unidad_medida: String,
    val valor: Double
)

data class Euro(
    val codigo: String,
    val fecha: String,
    val nombre: String,
    val unidad_medida: String,
    val valor: Double
)

data class Imacec(
    val codigo: String,
    val fecha: String,
    val nombre: String,
    val unidad_medida: String,
    val valor: Double
)

data class Ipc(
    val codigo: String,
    val fecha: String,
    val nombre: String,
    val unidad_medida: String,
    val valor: Double
)

data class Ivp(
    val codigo: String,
    val fecha: String,
    val nombre: String,
    val unidad_medida: String,
    val valor: Double
)

data class LibraCobre(
    val codigo: String,
    val fecha: String,
    val nombre: String,
    val unidad_medida: String,
    val valor: Double
)

data class TasaDesempleo(
    val codigo: String,
    val fecha: String,
    val nombre: String,
    val unidad_medida: String,
    val valor: Double
)

data class Tpm(
    val codigo: String,
    val fecha: String,
    val nombre: String,
    val unidad_medida: String,
    val valor: Double
)

data class Uf(
    val codigo: String,
    val fecha: String,
    val nombre: String,
    val unidad_medida: String,
    val valor: Double
)

data class Utm(
    val codigo: String,
    val fecha: String,
    val nombre: String,
    val unidad_medida: String,
    val valor: Double
)