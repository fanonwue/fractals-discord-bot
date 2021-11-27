package dev.fractallove.fracbot.models

import java.time.LocalDate
import java.util.*

data class Fractal(
    val id: Int,
    val name: String,
    val scales: IntArray,
    val dateAdded: LocalDate?
)