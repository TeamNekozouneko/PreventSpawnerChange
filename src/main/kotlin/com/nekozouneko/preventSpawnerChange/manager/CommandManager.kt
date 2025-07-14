package com.nekozouneko.preventSpawnerChange.manager

import com.nekozouneko.preventSpawnerChange.commands.ReloadCommand
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.command.TabExecutor

class CommandManager : CommandExecutor, TabExecutor {
    companion object{
        private val commands = mutableMapOf<String, SubCommand>(
            "reload" to ReloadCommand()
        )
    }

    interface SubCommand {
        fun handle(p0: CommandSender, p1: Command, p2: String, p3: Array<out String>) : Boolean {
            return false
        }
    }

    override fun onCommand(p0: CommandSender, p1: Command, p2: String, p3: Array<out String>): Boolean {
        if (p3.size <= 1) return false
        if (!commands.containsKey(p3[1])) return false
        val subCommand = commands[p3[1]] ?: return false
        return subCommand.handle(p0, p1, p2, p3)
    }

    override fun onTabComplete(
        p0: CommandSender,
        p1: Command,
        p2: String,
        p3: Array<out String>
    ): MutableList<String>? {
        return commands.keys.toMutableList()
    }
}