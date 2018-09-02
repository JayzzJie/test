package com.sxyt.util;

import java.io.Serializable;

/**
 * ǰ�����󣬷���������װ
 * @author Jayzz
 *
 * @param <T>
 */
public class Result<T> implements Serializable {

	public static final int SUCCESS=0;
	public static final int ERROR=1;
	private int state;//����ǰ̨��������״̬��
	private String message;//��Ϣ
	private Object data;//��Ҫ����ǰ̨������
	
	
	
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
