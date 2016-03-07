package com.mzisnm.limitGoods;

import org.apache.commons.lang.StringUtils;

/**
 * @author  马哲@China
 * @since   2016年2月26日下午3:27:25
 * @version 
 * ban/allow/both/banFirst/allowFirst
 */
public enum ModeEnum {
	/**
	 * only validate banGoods
	 */
	BAN(1),
	/**
	 * only validate allowGoods
	 */
	ALLOW(2),
	/**
	 * only validate banGoods,but banGoods=banGoods-allowGoods
	 */
	BANFIRST(3),
	/**
	 * only validate allowGoods,but allowGoods=allowGoods-banGoods
	 */
	ALLOWFIRST(4),
	ERROR(5);
	
	private int mode;
	public int getIntValue() {
		return mode;
	}
	
	private ModeEnum(int mode){
		this.mode = mode;
	}
	public static ModeEnum getMode(String mode){
		if(StringUtils.isBlank(mode)){
			return ERROR;
		}
		try {
			return getMode(Integer.valueOf(mode));
		} catch (NumberFormatException e1) {
		}
		try {
			return ModeEnum.valueOf(mode.toUpperCase());
		} catch (Exception e) {
			return ERROR;
		}
	}
	public static int getIntMode(String mode){
		return getMode(mode).getIntValue();
	}
	public static ModeEnum getMode(int mode){
		for (ModeEnum _mode : ModeEnum.values()) {
			if(_mode.mode==mode){
				return _mode;
			}
		}
		return ERROR;
	}
}
