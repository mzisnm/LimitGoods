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
	private String name;
	private int world;
	private boolean limit = true;//是否启用
	private Scope scope;
	private ModeEnum mode;//模式：ban/allow/banFirst/allowFirst/error
	private Set<Material> banGoods;
	private Set<Material> allowGoods;
	
	public boolean isBanGoods(Material material){
		return banGoods.contains(material);
	}
	public boolean isAllowGoods(Material material){
		return allowGoods.contains(material);
	}
	public ModeEnum getMode() {
		return mode;
	}
	public void setMode(ModeEnum modeEnum) {
		this.mode = modeEnum;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((scope == null) ? 0 : scope.hashCode());
		result = prime * result + world;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rule other = (Rule) obj;
		if (scope == null) {
			if (other.scope != null)
				return false;
		} else if (!scope.equals(other.scope))
			return false;
		if (world != other.world)
			return false;
		return true;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
