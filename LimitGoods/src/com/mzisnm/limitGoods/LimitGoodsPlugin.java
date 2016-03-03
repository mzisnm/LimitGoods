package com.mzisnm.limitGoods;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author  马哲@China
 * @since   2016年2月24日下午4:19:45
 * @version 
 *
 */
public final class LimitGoodsPlugin extends JavaPlugin{
	
	@Override
	public void onEnable() {
		getLogger().info("LimitGoods onEnable!");
		this.getCommand("basic").setExecutor(new LimitCommandExecutor(this));
	}
	@Override
	public void onDisable() {
		getLogger().info("LimitGoods onDisable!");
	}
	
}
