package com.sxyt.dao;

import java.util.List;

import com.sxyt.pojo.ProductInfo;

public interface ProductInfoDao {
	/**����¼��
	 * @return
	 */
	int addProductInfo(ProductInfo p);
	/**ǰ̨���view more ���صĲ�Ʒ��Ϣ
	 * @return
	 */
	List<ProductInfo> getProductInfoByViewMore();
	/**ǰ̨�����������Ҳ�Ʒʱ���صĲ�Ʒ��Ϣ
	 * @return
	 */
	List<ProductInfo> getProductInfoByInfos(ProductInfo p);
	/**
	 * ����ID��ȡ��Ʒ
	 * @param id
	 * @return
	 */
	ProductInfo getProductInfoById(String id);
	/**
	 * ��Ʒ��ѯ
	 * @param searchText
	 * @return
	 */
	List<ProductInfo> getProductsBySearch(String searchText);
}
