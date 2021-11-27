package dev.fractallove.fracbot.models

import dev.fractallove.fracbot.models.enums.FractalAchievementType

class FractalAchievement(
    id: Int,
    icon: String?,
    name: String,
    scale: Int,
    type: FractalAchievementType = FractalAchievementType.DAILY,
    fractal: Fractal?
) : Achievement(id, icon, name)
