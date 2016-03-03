package com.mzisnm.limitGoods;

/**
 * @author  马哲@China
 * @since   2016年2月29日上午8:45:19
 * @version 
 *
 */
public class Scope {
	private int x;
	private int y;
	private int l;//长
	private int w;//宽
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getL() {
		return l;
	}
	public void setL(int l) {
		this.l = l;
	}
	public int getW() {
		return w;
	}
	public void setW(int w) {
		this.w = w;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + l;
		result = prime * result + w;
		result = prime * result + x;
		result = prime * result + y;
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
		Scope other = (Scope) obj;
		if (l != other.l)
			return false;
		if (w != other.w)
			return false;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
}
