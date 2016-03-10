package com.mzisnm.limitGoods;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 * @author  马哲@China
 * @since   2016年3月3日上午9:00:59
 * @version 
 *
 */
public class LimitCommandExecutor implements CommandExecutor {

	private final LimitGoodsPlugin plugin;

	public LimitCommandExecutor(LimitGoodsPlugin plugin) {
		this.plugin = plugin; // Store the plugin in situations where you need it.
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		String arg = StringUtils.join(args," ").toLowerCase();
		for (CommendRegexEnum _commend : CommendRegexEnum.values()) {
			if(Pattern.matches(_commend.getRegex(), arg)){
				if(sender.hasPermission(_commend.getPermission())){
					return this.doCommend(_commend,sender, cmd, label, args);
				}else {
					sender.sendMessage("You don't has the permission!");
					return false;
				}
			}
		}
		return false;
	}

	private boolean doCommend(CommendRegexEnum regexEnum, CommandSender sender, Command cmd, String label, String[] args){
		switch (regexEnum) {
			case ENABLE:
				return doEnable(sender, cmd, label, args);
			case DISABLE:
				return doDisable(sender, cmd, label, args);
			case MODE:
				return doMode(sender, cmd, label, args);
			case BAN:
				return doBan(sender, cmd, label, args);
			case BANADD:
				return doBanAdd(sender, cmd, label, args);
			case BANDELETE:
				return doBanDelete(sender, cmd, label, args);
			case BANCLEAR:
				return doBanClear(sender, cmd, label, args);
			case ALLOW:
				return doAllow(sender, cmd, label, args);
			case ALLOWADD:
				return doAllowAdd(sender, cmd, label, args);
			case ALLOWDELETE:
				return doAllowDelete(sender, cmd, label, args);
			case ALLOWCLEAR:
				return doAllowClear(sender, cmd, label, args);
			case SCOPECREATE1:
				return doScopeCreate1(sender, cmd, label, args);
			case SCOPECREATE2:
				return doScopeCreate2(sender, cmd, label, args);
			case SCOPEDELETE:
				return doScopeDelete(sender, cmd, label, args);
			default:
				return false;
		}
	}

	private boolean doEnable(CommandSender sender, Command cmd, String label, String[] args) {
		Rule _rule = plugin.getRuleByName(args[1]);
		if(null==_rule){
			sender.sendMessage("the scope '" + args[1] + "' does not exist!");
			return false;
		}
		_rule.setLimit(true);
		sender.sendMessage("enabled success!");
		return true;
	}

	private boolean doDisable(CommandSender sender, Command cmd, String label, String[] args) {
		Rule _rule = plugin.getRuleByName(args[1]);
		if(null==_rule){
			sender.sendMessage("the scope '" + args[1] + "' does not exist!");
			return false;
		}
		_rule.setLimit(false);
		sender.sendMessage("disabled success!");
		return true;
	}

	private boolean doMode(CommandSender sender, Command cmd, String label, String[] args) {
		Rule _rule = plugin.getRuleByName(args[1]);
		if(null==_rule){
			sender.sendMessage("the scope '" + args[1] + "' does not exist!");
			return false;
		}
		ModeEnum mode = ModeEnum.getMode(args[2]);
		if(mode==ModeEnum.ERROR){
			sender.sendMessage("wrong mode!");
			return false;
		}
		_rule.setMode(mode);
		return true;
	}

	private boolean doBan(CommandSender sender, Command cmd, String label, String[] args) {
		Rule _rule = plugin.getRuleByName(args[1]);
		if(null==_rule){
			sender.sendMessage("the scope '" + args[1] + "' does not exist!");
			return false;
		}
		Set<Material> _set = switchToMaterial(args[2]);
		if(_set==null){
			sender.sendMessage("the goods '" + args[2] + "' does not right!");
			return false;
		}
		_rule.getBanGoods().clear();
		_rule.getBanGoods().addAll(_set);
		return true;
	}

	private boolean doBanAdd(CommandSender sender, Command cmd, String label, String[] args) {
		Rule _rule = plugin.getRuleByName(args[2]);
		if(null==_rule){
			sender.sendMessage("the scope '" + args[2] + "' does not exist!");
			return false;
		}
		Set<Material> _set = switchToMaterial(args[3]);
		if(_set==null){
			sender.sendMessage("the goods '" + args[3] + "' does not right!");
			return false;
		}
		_rule.getBanGoods().addAll(_set);
		return true;
	}

	private boolean doBanDelete(CommandSender sender, Command cmd, String label, String[] args) {
		Rule _rule = plugin.getRuleByName(args[2]);
		if(null==_rule){
			sender.sendMessage("the scope '" + args[2] + "' does not exist!");
			return false;
		}
		Set<Material> _set = switchToMaterial(args[3]);
		if(_set==null){
			sender.sendMessage("the goods '" + args[3] + "' does not right!");
			return false;
		}
		_rule.getBanGoods().removeAll(_set);
		return true;
	}

	private boolean doBanClear(CommandSender sender, Command cmd, String label, String[] args) {
		Rule _rule = plugin.getRuleByName(args[2]);
		if(null==_rule){
			sender.sendMessage("the scope '" + args[2] + "' does not exist!");
			return false;
		}
		_rule.getBanGoods().clear();
		return true;
	}

	private boolean doAllow(CommandSender sender, Command cmd, String label, String[] args) {
		Rule _rule = plugin.getRuleByName(args[1]);
		if(null==_rule){
			sender.sendMessage("the scope '" + args[1] + "' does not exist!");
			return false;
		}
		Set<Material> _set = switchToMaterial(args[2]);
		if(_set==null){
			sender.sendMessage("the goods '" + args[2] + "' does not right!");
			return false;
		}
		_rule.getAllowGoods().clear();
		_rule.getAllowGoods().addAll(_set);
		return true;
	}

	private boolean doAllowAdd(CommandSender sender, Command cmd, String label, String[] args) {
		Rule _rule = plugin.getRuleByName(args[2]);
		if(null==_rule){
			sender.sendMessage("the scope '" + args[2] + "' does not exist!");
			return false;
		}
		Set<Material> _set = switchToMaterial(args[3]);
		if(_set==null){
			sender.sendMessage("the goods '" + args[3] + "' does not right!");
			return false;
		}
		_rule.getAllowGoods().addAll(_set);
		return true;
	}

	private boolean doAllowDelete(CommandSender sender, Command cmd, String label, String[] args) {
		Rule _rule = plugin.getRuleByName(args[2]);
		if(null==_rule){
			sender.sendMessage("the scope '" + args[2] + "' does not exist!");
			return false;
		}
		Set<Material> _set = switchToMaterial(args[3]);
		if(_set==null){
			sender.sendMessage("the goods '" + args[3] + "' does not right!");
			return false;
		}
		_rule.getAllowGoods().removeAll(_set);
		return true;
	}

	private boolean doAllowClear(CommandSender sender, Command cmd, String label, String[] args) {
		Rule _rule = plugin.getRuleByName(args[2]);
		if(null==_rule){
			sender.sendMessage("the scope '" + args[2] + "' does not exist!");
			return false;
		}
		_rule.getAllowGoods().clear();
		return true;
	}

	private boolean doScopeCreate1(CommandSender sender, Command cmd, String label, String[] args) {
		Rule _rule = plugin.getRuleByName(args[2]);
		if(null!=_rule){
			sender.sendMessage("the scope '" + args[2] + "' does already exist!");
			return false;
		}
		
		return false;
	}

	private boolean doScopeCreate2(CommandSender sender, Command cmd, String label, String[] args) {
		Rule _rule = plugin.getRuleByName(args[2]);
		if(null==_rule){
			sender.sendMessage("the scope '" + args[2] + "' does not exist!");
			return false;
		}
		return false;
	}

	private boolean doScopeDelete(CommandSender sender, Command cmd, String label, String[] args) {
		Rule _rule = plugin.getRuleByName(args[2]);
		if(null==_rule){
			sender.sendMessage("the scope '" + args[2] + "' does not exist!");
			return false;
		}
		return false;
	}
	
	private Set<Material> switchToMaterial(String goods){
		Set<Material> _set = new HashSet<Material>();
		String[] _strs = goods.split(",");
		for (String _str : _strs) {
			Material _material = null;
			if(Pattern.matches("^\\d+$", _str)){
				_material = Material.getMaterial(Integer.valueOf(_str));
			}else {
				_material = Material.getMaterial(_str);
			}
			if(null==_material){
				return null;
			}else{
				_set.add(_material);
			}
		}
		return _set;
	}
}
