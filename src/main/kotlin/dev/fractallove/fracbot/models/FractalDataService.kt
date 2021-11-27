package dev.fractallove.fracbot.models

import dev.fractallove.fracbot.models.enums.Fractals

class FractalDataService {
    private val fractalDataScraper = FractalDataScraper()

    private val cache = HashMap<Int, Fractal>()

    suspend fun getFractal(fractal: Fractals) : Fractal? {
        return getFractal(fractal.id)
    }

    suspend fun getFractal(id: Int) : Fractal? {
        if (cache.size == 0) {
            cache.putAll(
                fractalDataScraper.fetchFractals().map {
                    it.id to it
                }
            )
        }

        return cache.getOrDefault(id, null)
    }
}