package com.nekozouneko.preventSpawnerChange.commands

import com.nekozouneko.preventSpawnerChange.PreventSpawnerChange
import com.nekozouneko.preventSpawnerChange.manager.CommandManager
import com.nekozouneko.preventSpawnerChange.wrapper.Config
import org.bukkit.command.Command
import org.bukkit.command.CommandSender

class ReloadCommand : CommandManager.SubCommand {
    override fun handle(p0: CommandSender, p1: Command, p2: String, p3: Array<out String>): Boolean {
        PreventSpawnerChange.instance.reloadConfig()
        p0.sendMessage(Config.Languages.reloadedConfig)
        return true
    }
}