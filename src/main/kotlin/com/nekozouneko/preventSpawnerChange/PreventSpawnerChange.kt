package com.nekozouneko.preventSpawnerChange

import com.nekozouneko.preventSpawnerChange.manager.CommandManager
import org.bukkit.plugin.java.JavaPlugin

class PreventSpawnerChange : JavaPlugin() {
    companion object{
        lateinit var instance: JavaPlugin

        val isFolia = isClassExists("io.papermc.paper.threadedregions.RegionizedServer") || isClassExists("io.papermc.paper.threadedregions.RegionizedServerInitEvent")
        private fun isClassExists(clazz: String) : Boolean {
            try {
                Class.forName(clazz)
                return true
            }catch (_: ClassNotFoundException){
                return false
            }
        }
    }

    override fun onEnable() {
        instance = this
        if (isFolia) {
            logger.warning("[Warning] It appears to be running on Folia.\n" +
                    "Folia is still experimental and may have errors.")
        }

        saveDefaultConfig()

        getCommand("preventspawnerchange")?.setExecutor(CommandManager())
    }

    override fun onDisable() {}
}
