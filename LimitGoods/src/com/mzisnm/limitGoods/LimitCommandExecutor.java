package com.mzisnm.limitGoods;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
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
		String arg = StringUtils.join(args,",").toLowerCase();
		for (CommendRegexEnum _commend : CommendRegexEnum.values()) {
			if(Pattern.matches(_commend.getRegex(), arg)){
				if(sender.hasPermission(_commend.getPermission())){
					return _commend.doCommend(sender, cmd, label, args);
				}else {
					sender.sendMessage("You don't has the permission!");
					return false;
				}
			}
		}
		return false;
	}

}
