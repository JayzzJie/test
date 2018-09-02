package com.sxyt.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.sxyt.dao.ProductInfoDao;
import com.sxyt.pojo.ProductInfo;
import com.sxyt.service.ProductInfoService;

@Service("partnerInfoService")
public class ProductInfoServiceImpl implements ProductInfoService{

	@Resource(name="productInfoDao")
	private ProductInfoDao productInfoDao;

	@Value("#{jdbc.pageSize}") 
	private int pageSize;
	public List<ProductInfo> getProductsByViewTimes(int viewTimes) {
		List<ProductInfo> list = productInfoDao.getProductInfoByViewMore();
		int starIndex = viewTimes*pageSize;
		int endIndex = (viewTimes+1)*pageSize;
		if(list!=null && starIndex>list.size()){
			list=null;
		}
		if(list!=null && !list.isEmpty() && endIndex>list.size()){
			list = list.subList(starIndex, list.size());
		}
		if(list!=null && !list.isEmpty() && !(endIndex>list.size())){
			list = list.subList(starIndex, endIndex);
		}
		return list;
	}
	public int addProduct(ProductInfo product) {
		int i = productInfoDao.addProductInfo(product);
		return i;
	}
	public int addProduct(String name, String cas, String detail, String type, int viewTimes, String image) {
		ProductInfo product = new ProductInfo();
		product.setId(UUID.randomUUID().toString());
		product.setProductName(name);
		product.setCasNo(cas);
		product.setProductDetail(detail);
		product.setType(type);
		product.setViewTimes(viewTimes);
		product.setImageName(image);
		product.setInsertTime(Calendar.getInstance().getTime());
		int i = productInfoDao.addProductInfo(product);
		return i;
	}
	public List<ProductInfo> getProductsBySearch(String searchText) {
		List<ProductInfo> list = productInfoDao.getProductsBySearch(searchText);
		System.out.println(list.size());
		return list;
	}
	
	

}
