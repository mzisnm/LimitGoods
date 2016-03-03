package com.mzisnm.limitGoods;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;


/**
 * @author  马哲@China
 * @since   2016年3月1日上午8:55:57
 * @version 
 *
 */
public enum CommendRegexEnum {
	ENABLE("^enable "+Constant.scope+"$","mz.limit.enable"){
		@Override
		public boolean doCommend(CommandSender sender, Command cmd, String label, String[] args) {
			// TODO Auto-generated method stub
			return false;
		}
	}, 
	DISABLE("^disable "+Constant.scope+"$","mz.limit.disable") {
		@Override
		public boolean doCommend(CommandSender sender, Command cmd, String label, String[] args) {
			// TODO Auto-generated method stub
			return false;
		}
	},
	MODE("^mode "+Constant.scope+" 1|2|3|4|(ban)|(allow)|(banFirst)|(allowFirst)$","mz.limit.mode") {
		@Override
		public boolean doCommend(CommandSender sender, Command cmd, String label, String[] args) {
			// TODO Auto-generated method stub
			return false;
		}
	},
	BAN("^ban "+Constant.scope+" ("+Constant.scope+")|([0-9]+)$","mz.limit.ban") {
		@Override
		public boolean doCommend(CommandSender sender, Command cmd, String label, String[] args) {
			// TODO Auto-generated method stub
			return false;
		}
	},
	BANADD("^ban add "+Constant.scope+" "+Constant.goods+"$","mz.limit.ban") {
		@Override
		public boolean doCommend(CommandSender sender, Command cmd, String label, String[] args) {
			// TODO Auto-generated method stub
			return false;
		}
	},
	BANDELETE("^ban delete "+Constant.scope+" "+Constant.goods+"$","mz.limit.ban") {
		@Override
		public boolean doCommend(CommandSender sender, Command cmd, String label, String[] args) {
			// TODO Auto-generated method stub
			return false;
		}
	},
	BANCLEAR("^ban clear "+Constant.scope+" "+Constant.goods+"$","mz.limit.ban") {
		@Override
		public boolean doCommend(CommandSender sender, Command cmd, String label, String[] args) {
			// TODO Auto-generated method stub
			return false;
		}
	},
	ALLOW("^allow "+Constant.scope+" "+Constant.goods+"$","mz.limit.allow") {
		@Override
		public boolean doCommend(CommandSender sender, Command cmd, String label, String[] args) {
			// TODO Auto-generated method stub
			return false;
		}
	},
	ALLOWADD("^allow add "+Constant.scope+" "+Constant.goods+"$","mz.limit.allow") {
		@Override
		public boolean doCommend(CommandSender sender, Command cmd, String label, String[] args) {
			// TODO Auto-generated method stub
			return false;
		}
	},
	ALLOWDELETE("^allow delete "+Constant.scope+" "+Constant.goods+"$","mz.limit.allow") {
		@Override
		public boolean doCommend(CommandSender sender, Command cmd, String label, String[] args) {
			// TODO Auto-generated method stub
			return false;
		}
	},
	ALLOWCLEAR("^allow clear "+Constant.scope+" "+Constant.goods+"$","mz.limit.allow") {
		@Override
		public boolean doCommend(CommandSender sender, Command cmd, String label, String[] args) {
			// TODO Auto-generated method stub
			return false;
		}
	},
	SCOPECREATE1("^scope create "+Constant.scope+" \\d+,\\d+ \\d+ \\d+$","mz.limit.scope.create") {
		@Override
		public boolean doCommend(CommandSender sender, Command cmd, String label, String[] args) {
			// TODO Auto-generated method stub
			return false;
		}
	},
	SCOPECREATE2("^scope create "+Constant.scope+" \\d+,\\d+ \\d+,\\d+$","mz.limit.scope.create") {
		@Override
		public boolean doCommend(CommandSender sender, Command cmd, String label, String[] args) {
			// TODO Auto-generated method stub
			return false;
		}
	},
	SCOPEDELETE("^scope delete "+Constant.scope+"$","mz.limit.scope.delete") {
		@Override
		public boolean doCommend(CommandSender sender, Command cmd, String label, String[] args) {
			// TODO Auto-generated method stub
			return false;
		}
	};
	
	private String regex;
	private String permission;
	
	public abstract boolean doCommend(CommandSender sender, Command cmd, String label, String[] args);
	
	private CommendRegexEnum(String regex,String permission) {
		this.regex = regex;
		this.permission = permission;
	}

	public String getRegex() {
		return regex;
	}

	public String getPermission() {
		return permission;
	}
}
