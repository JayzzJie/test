package com.sxyt.util;

import java.io.Serializable;

/**
 * 前端请求，返回其结果封装
 * @author Jayzz
 *
 * @param <T>
 */
public class Result<T> implements Serializable {

	public static final int SUCCESS=0;
	public static final int ERROR=1;
	private int state;//返回前台代表结果的状态码
	private String message;//信息
	private Object data;//需要返回前台的数据
	
	
	
	public Result(Object data){
		state = SUCCESS;
		this.data = data;
	}
	
	public Result(Throwable e) {
		state = ERROR;
		message = e.getMessage();
	}
	
	public Result(int state, Throwable e) {
		this.state = state;
		this.message = e.getMessage();
	}
	public Result(String message) {
		state = ERROR;
		this.message = message;
	}
	public Result() {
		super();
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
}
