package me.lished.buildermode

import org.bukkit.plugin.java.JavaPlugin

class BuilderMode : JavaPlugin() {
    override fun onEnable() {
        getCommand("buildermode").setExecutor(Build)
    }
}
