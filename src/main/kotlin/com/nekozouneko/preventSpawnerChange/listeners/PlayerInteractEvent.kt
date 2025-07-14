package com.nekozouneko.preventSpawnerChange.listeners

import com.nekozouneko.preventSpawnerChange.wrapper.Config
import org.bukkit.Material
import org.bukkit.block.Block
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.ItemMeta
import org.bukkit.inventory.meta.SpawnEggMeta

class PlayerInteractEvent : Listener {
    @EventHandler
    fun onPlayerInteract(event: PlayerInteractEvent) {
        val player: Player = event.player
        val item: ItemStack = event.item ?: return
        val itemMeta: ItemMeta = item.itemMeta ?: return
        val clickedBlock: Block = event.clickedBlock ?: return

        if (player.hasPermission("preventspawnerchange.bypass")) return

        if (itemMeta !is SpawnEggMeta) return
        if (event.action != Action.RIGHT_CLICK_BLOCK) return
        if (
            Config.PreventTypes.isSpawnerEnabled && clickedBlock.type == Material.SPAWNER ||
            Config.PreventTypes.isTrialSpawnerEnabled && clickedBlock.type == Material.TRIAL_SPAWNER
        ){
            event.isCancelled = true
            player.sendMessage(Config.Languages.deniedUse)
        }
    }
}