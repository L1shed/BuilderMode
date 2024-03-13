package me.lished.buildermode.command

import me.lished.buildermode.manager.BuildermodeManager
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class BuildermodeCommand : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>?): Boolean {
        val player = sender as Player
        if (BuildermodeManager.builders.contains(player)) {
            BuildermodeManager.builders.remove(player)
            player.sendMessage("Builder mode disabled.")
        } else {
            BuildermodeManager.builders.add(player)
            player.sendMessage("Builder mode enabled.")
        }
    }

}
