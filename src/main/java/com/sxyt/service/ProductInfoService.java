package com.sxyt.service;

import java.util.List;

import com.sxyt.pojo.ProductInfo;
import com.sxyt.util.Result;

public interface ProductInfoService {

	/**
	 * 根据viewMore的次数查询结果
	 * @param viewTimes
	 * @return
	 */
	List<ProductInfo> getProductsByViewTimes(int viewTimes);
	//ProductInfo findPartnerByName(String name);
	//ProductInfo addPartner(String name, String tel, String email, String address, String remark);

	int addProduct(ProductInfo product);

	int addProduct(String name, String cas, String detail, String type, int viewTimes, String image);

	List<ProductInfo> getProductsBySearch(String searchText);
}
