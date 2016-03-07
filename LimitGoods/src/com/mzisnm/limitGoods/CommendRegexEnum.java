package com.mzisnm.limitGoods;



/**
 * @author  马哲@China
 * @since   2016年3月1日上午8:55:57
 * @version 
 *
 */
public enum CommendRegexEnum {
	ENABLE("^enable "+Constant.scope+"$","mz.limit.enable"), 
	DISABLE("^disable "+Constant.scope+"$","mz.limit.disable"),
	MODE("^mode "+Constant.scope+" 1|2|3|4|(ban)|(allow)|(banFirst)|(allowFirst)$","mz.limit.mode"),
	BAN("^ban "+Constant.scope+" "+Constant.goods+"$","mz.limit.ban"),
	BANADD("^ban add "+Constant.scope+" "+Constant.goods+"$","mz.limit.ban"),
	BANDELETE("^ban delete "+Constant.scope+" "+Constant.goods+"$","mz.limit.ban"),
	BANCLEAR("^ban clear "+Constant.scope+" "+Constant.goods+"$","mz.limit.ban"),
	ALLOW("^allow "+Constant.scope+" "+Constant.goods+"$","mz.limit.allow"),
	ALLOWADD("^allow add "+Constant.scope+" "+Constant.goods+"$","mz.limit.allow"),
	ALLOWDELETE("^allow delete "+Constant.scope+" "+Constant.goods+"$","mz.limit.allow"),
	ALLOWCLEAR("^allow clear "+Constant.scope+" "+Constant.goods+"$","mz.limit.allow"),
	SCOPECREATE1("^scope create "+Constant.scope+" \\d+,\\d+ \\d+ \\d+$","mz.limit.scope.create"),
	SCOPECREATE2("^scope create "+Constant.scope+" \\d+,\\d+ \\d+,\\d+$","mz.limit.scope.create"),
	SCOPEDELETE("^scope delete "+Constant.scope+"$","mz.limit.scope.delete");
	
	private String regex;
	private String permission;
	
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
