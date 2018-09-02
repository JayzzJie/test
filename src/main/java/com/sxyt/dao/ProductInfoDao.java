package com.sxyt.dao;

import java.util.List;

import com.sxyt.pojo.ProductInfo;

public interface ProductInfoDao {
	/**单个录入
	 * @return
	 */
	int addProductInfo(ProductInfo p);
	/**前台点击view more 返回的产品信息
	 * @return
	 */
	List<ProductInfo> getProductInfoByViewMore();
	/**前台根据条件查找产品时返回的产品信息
	 * @return
	 */
	List<ProductInfo> getProductInfoByInfos(ProductInfo p);
	/**
	 * 根据ID获取产品
	 * @param id
	 * @return
	 */
	ProductInfo getProductInfoById(String id);
	/**
	 * 产品查询
	 * @param searchText
	 * @return
	 */
	List<ProductInfo> getProductsBySearch(String searchText);
}
