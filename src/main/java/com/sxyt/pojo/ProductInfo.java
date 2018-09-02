package com.sxyt.pojo;

import java.io.Serializable;
import java.util.Date;

public class ProductInfo implements Serializable{

	private String id;//id
	private String productName;//产品名 英文
	private String casNo;//cas号
	private String productDetail;//产品简介
	private String imageName;//图片名
	private String type;//分类
	private int viewTimes;//浏览次数
	private Date insertTime;//录入日期
	/**
	 * @return the viewTimes
	 */
	public int getViewTimes() {
		return viewTimes;
	}
	/**
	 * @param viewTimes the viewTimes to set
	 */
	public void setViewTimes(int viewTimes) {
		this.viewTimes = viewTimes;
	}
	/**
	 * @return the insertTime
	 */
	public Date getInsertTime() {
		return insertTime;
	}
	/**
	 * @param insertTime the insertTime to set
	 */
	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}
	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}
	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	/**
	 * @return the casNo
	 */
	public String getCasNo() {
		return casNo;
	}
	/**
	 * @param casNo the casNo to set
	 */
	public void setCasNo(String casNo) {
		this.casNo = casNo;
	}
	/**
	 * @return the productDetail
	 */
	public String getProductDetail() {
		return productDetail;
	}
	/**
	 * @param productDetail the productDetail to set
	 */
	public void setProductDetail(String productDetail) {
		this.productDetail = productDetail;
	}
	/**
	 * @return the imageName
	 */
	public String getImageName() {
		return imageName;
	}
	/**
	 * @param imageName the imageName to set
	 */
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	public ProductInfo() {
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	
}
