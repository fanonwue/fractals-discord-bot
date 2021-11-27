package dev.fractallove.fracbot.models.enums

import dev.fractallove.fracbot.models.Fractal
import dev.fractallove.fracbot.models.FractalDataScraper
import dev.fractallove.fracbot.models.FractalDataService
import java.util.*
import kotlin.collections.HashMap

enum class Fractals() {
    AETHERBLADE,
    AQUATIC_RUINS,
    CAPTAIN_MAI_TRIN_BOSS,
    CHAOS,
    CLIFFSIDE,
    DEEPSTONE,
    MOLTEN_BOSS,
    MOLTEN_FURNACE,
    NIGHTMARE,
    SHATTERED_OBSERVATORY,
    SIRENS_REEF,
    SNOWBLIND,
    SUNQUA_PEAK,
    SOLID_OCEAN,
    SWAMPLAND,
    THAUMANOVA_REACTOR,
    TWILIGHT_OASIS,
    UNCATEGORIZED,
    UNDERGROUND_FACILITY,
    URBAN_BATTLEGROUND,
    VOLCANIC;

    val id = ordinal + 1

    suspend fun getFractal() : Fractal? {
        return fractalDataService.getFractal(this)
    }

    companion object {
        var fractalDataService = FractalDataService()
    }
}