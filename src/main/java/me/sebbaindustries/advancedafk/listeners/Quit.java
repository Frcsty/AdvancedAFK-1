package me.sebbaindustries.advancedafk.listeners;

import me.sebbaindustries.advancedafk.detection.PlayerData;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 * @author sebbaindustries
 * @version 1.0
 */
public class Quit implements Listener {

    /**
     * Activates when player quits
     *
     * @param e Event
     */
    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        // remove player from hashmap
        PlayerData.playerStorageHashMap.remove(p);
    }

}
