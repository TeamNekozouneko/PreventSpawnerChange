package com.nekozouneko.preventSpawnerChange

import org.bukkit.plugin.java.JavaPlugin

class PreventSpawnerChange : JavaPlugin() {
    val isFolia = isClassExists("io.papermc.paper.threadedregions.RegionizedServer") || isClassExists("io.papermc.paper.threadedregions.RegionizedServerInitEvent")

    override fun onEnable() {
        if (isFolia) {
            logger.warning("[Warning] It appears to be running on Folia.\n" +
                    "Folia is still experimental and may have errors.")
        }
    }

    override fun onDisable() {}

    private fun isClassExists(clazz: String) : Boolean {
        try {
            Class.forName(clazz)
            return true
        }catch (_: ClassNotFoundException){
            return false
        }
    }
}
