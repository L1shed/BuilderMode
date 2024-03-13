package me.lished.buildermode.listener

import org.bukkit.Bukkit
import org.bukkit.block.Block
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockBreakEvent
import org.bukkit.event.block.BlockPlaceEvent
import org.bukkit.metadata.FixedMetadataValue
import org.bukkit.metadata.MetadataValue
import org.bukkit.plugin.java.JavaPlugin

class BuildermodeListener(private val plugin: JavaPlugin): Listener {
    @EventHandler
    fun onPlace(e: BlockPlaceEvent) {
        val block: Block = e.blockPlaced
        block.setMetadata("placed_by", FixedMetadataValue(plugin, e.player.name))
    }

    @EventHandler
    fun onBlockBreak(event: BlockBreakEvent) {
        val player: Player = event.player
        val block: Block = event.block

        // Retrieve metadata
        val metadataList: List<MetadataValue> = block.getMetadata("placedBy")

        // Check if metadata exists
        if (metadataList.isNotEmpty()) {
            val placedBy: String = metadataList[0].asString()
            if (Bukkit.getPlayer(placedBy) != player) {
                event.isCancelled = true
            }
            player.sendMessage("This block was placed by: $placedBy")
        } else {
            player.sendMessage("no data found")
        }
    }
}