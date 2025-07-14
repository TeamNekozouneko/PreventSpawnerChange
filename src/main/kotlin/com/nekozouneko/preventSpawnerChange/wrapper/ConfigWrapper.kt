package com.nekozouneko.preventSpawnerChange.wrapper

import com.nekozouneko.preventSpawnerChange.PreventSpawnerChange

object Config {
    private val config = PreventSpawnerChange.instance.config

    object PreventTypes{
        val isSpawnerEnabled = config.getBoolean("preventTypes.spawner")
        val isTrialSpawnerEnabled = config.getBoolean("preventTypes.trialSpawner")
    }

    object Languages {
        val reloadedConfig = config.getString("languages.reloadedConfig") ?: ""
        val deniedUse = config.getString("languages.deniedUse") ?: ""
    }
}