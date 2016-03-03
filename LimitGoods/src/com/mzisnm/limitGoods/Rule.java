package com.mzisnm.limitGoods;

import java.util.Set;

import org.bukkit.Material;

/**
 * @author  马哲@China
 * @since   2016年2月29日上午8:54:00
 * @version 
 *
 */
public class Rule {
	private int world;
	private boolean limit = true;//是否启用
	private Scope scope;
	private Mode mode;//模式：ban/allow/banFirst/allowFirst/error
	private Set<Material> banGoods;
	private Set<Material> allowGoods;
	
	public boolean isBanGoods(Material material){
		return banGoods.contains(material);
	}
	public boolean isAllowGoods(Material material){
		return allowGoods.contains(material);
	}
	public Mode getMode() {
		return mode;
	}
	public void setMode(Mode mode) {
		this.mode = mode;
	}
	public Scope getScope() {
		return scope;
	}
	public void setScope(Scope scope) {
		this.scope = scope;
	}
	public int getWorld() {
		return world;
	}
	public void setWorld(int world) {
		this.world = world;
	}
	public boolean isLimit() {
		return limit;
	}
	public void setLimit(boolean limit) {
		this.limit = limit;
	}
}
