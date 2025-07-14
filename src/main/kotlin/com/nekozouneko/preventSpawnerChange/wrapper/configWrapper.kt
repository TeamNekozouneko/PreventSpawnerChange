package com.nekozouneko.preventSpawnerChange.wrapper

import com.nekozouneko.preventSpawnerChange.PreventSpawnerChange

object Config {
    private val config = PreventSpawnerChange.instance.config

    object PreventTypes{
        val isSpawnerEnabled = config.getString("preventTypes.spawner")
        val isTrialSpawnerEnabled = config.getString("preventTypes.trialSpawner")
    }

    object Languages {
        val reloadedConfig = config.getString("languages.reloadedConfig")
    }
}