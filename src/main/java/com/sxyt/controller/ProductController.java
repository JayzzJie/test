package com.sxyt.controller;


import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.sxyt.pojo.ProductInfo;
import com.sxyt.service.ProductInfoService;
import com.sxyt.util.Result;


@Controller				
@RequestMapping("/product") 
public class ProductController {

	@Resource
	ProductInfoService productInfoService;
	
	/**
	 * ¼���Ʒ������
	 * @param name
	 * @param tel
	 * @param email
	 * @param address
	 * @param remark
	 * @return
	 */
	@RequestMapping("/addProduct.do")
	@ResponseBody
	public Result<Object> execute(
			String name,String cas,
			String detail,String type,int viewTimes,String image){
		int i = productInfoService.addProduct( name, cas, detail, type, viewTimes, image);
		return new Result(0);
	}
	
	/**
	 * ��Ʒ�б������
	 * @param viewTimes �����������ͬ��ҳ��
	 * @return
	 */
	@RequestMapping("/list.do")
	@ResponseBody
	public Result<Object> viewProducts(int viewTimes){
		List<ProductInfo> list = productInfoService.getProductsByViewTimes(viewTimes);
		if(list==null || list.isEmpty()){
			return new Result(3, new Exception());
		}
		return new Result(list);
	}
	/**
	 * ��Ʒ��ѯ������
	 * @param viewTimes �����������ͬ��ҳ��
	 * @return
	 */
	@RequestMapping("/listBySearch.do")
	@ResponseBody
	public Result<Object> viewProductsBySearch(String searchText){
		List<ProductInfo> list = productInfoService.getProductsBySearch(searchText);
		if(list==null || list.isEmpty()){
			return new Result(3, new Exception());
		}
		return new Result(list);
	}
	
	/**
	 * 
	 * @param request
	 * @return 
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	@RequestMapping("/uploadImage.do")
	@ResponseBody
	public String  springUpload(HttpServletRequest request) throws IllegalStateException, IOException
    {
         long  startTime=System.currentTimeMillis();
         //����ǰ�����ĳ�ʼ����  CommonsMutipartResolver ���ಿ�ֽ�������
        CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(
                request.getSession().getServletContext());
        //���form���Ƿ���enctype="multipart/form-data"
        if(multipartResolver.isMultipart(request))
        {
            //��request��ɶಿ��request
            MultipartHttpServletRequest multiRequest=(MultipartHttpServletRequest)request;
           //��ȡmultiRequest �����е��ļ���
            Iterator iter=multiRequest.getFileNames();
             System.out.println(request.getServletContext().getRealPath("/")+"images\\product\\");
            while(iter.hasNext())
            {
                //һ�α��������ļ�
                MultipartFile file=multiRequest.getFile(iter.next().toString());
                if(file!=null)
                {
                    String path=request.getServletContext().getRealPath("/")+"images\\product\\"+file.getOriginalFilename();
                    System.out.println(file.getOriginalFilename());
                    //�ϴ�
                    file.transferTo(new File(path));
                }
                 
            }
           
        }
        long  endTime=System.currentTimeMillis();
        System.out.println("������������ʱ�䣺"+String.valueOf(endTime-startTime)+"ms");
    return "list.html"; 
    }
	@ExceptionHandler(RuntimeException.class)
	@ResponseBody
	public Result handleUserName(
			RuntimeException e){
		e.printStackTrace();
		return new Result(2,e);
	}
	
}
