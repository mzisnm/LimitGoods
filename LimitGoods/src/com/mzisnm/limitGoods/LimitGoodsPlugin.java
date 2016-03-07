package com.mzisnm.limitGoods;

import java.util.HashSet;
import java.util.Set;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author  马哲@China
 * @since   2016年2月24日下午4:19:45
 * @version 
 *
 */
public final class LimitGoodsPlugin extends JavaPlugin{
	private Set<Rule> rules = new HashSet<Rule>();
	
	@Override
	public void onEnable() {
		getLogger().info("LimitGoods onEnable!");
		this.getCommand("basic").setExecutor(new LimitCommandExecutor(this));
	}
	@Override
	public void onDisable() {
		getLogger().info("LimitGoods onDisable!");
	}
	public Set<Rule> getRules() {
		return rules;
	}
	public boolean addRule(Rule rule){
		if(rule==null || rules.contains(rule)){
			return false;
		}
		rules.add(rule);
		return true;
	}
	public Rule getRuleByName(String name){
		if(null==name){
			return null;
		}
		for(Rule _rule: rules){
			if(name.endsWith(_rule.getName())){
				return _rule;
			}
		}
		return null;
	}
}
