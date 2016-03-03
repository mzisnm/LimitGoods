package com.mzisnm.limitGoods;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 * @author  马哲@China
 * @since   2016年2月25日下午5:26:59
 * @version 
 *
 */
public class PlayerListener implements Listener {
    private final LimitGoodsPlugin plugin;

    public PlayerListener(LimitGoodsPlugin instance) {
        plugin = instance;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        plugin.getLogger().info(event.getPlayer().getName() + " joined the server! :D");
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        plugin.getLogger().info(event.getPlayer().getName() + " left the server! :'(");
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
    }
}
