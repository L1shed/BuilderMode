package me.lished.buildermode

import me.lished.buildermode.command.BuildermodeCommand
import me.lished.buildermode.listener.BuildermodeListener
import org.bukkit.plugin.java.JavaPlugin

class BuilderMode : JavaPlugin() {
    override fun onEnable() {
        getCommand("buildermode")!!.setExecutor(BuildermodeCommand())
        server.pluginManager.registerEvents(BuildermodeListener(this), this)
    }
}
