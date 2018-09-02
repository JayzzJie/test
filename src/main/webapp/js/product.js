window.onload = function () {
	$("#view_more_id").on("click", viewMoreProduct);
	$("#search_id").on("click", viewProductBySearch);
	getSearchText();
}

var viewTimes=0;
var path="http://localhost:8080/sxytbio";
function viewMoreProduct(){
	//alert("第"+viewTimes+"次");
	$.ajax({
		url:path+"/product/list.do",
		type:"post",
		data:{"viewTimes":viewTimes},
		dataType:"json",
		success:function(result){
			if (result.state == 0) {
				// 获取返回的数据
				var products = result.data;
				// 循环读取
				for (var i = 0; i < products.length; i++) {
					var productName = products[i].productName;
					var imageName = products[i].imageName;
					var productDetail = products[i].productDetail;
					var id = products[i].id;
					createProduct(id, productDetail, imageName, productName);
				}
			}
			if(result.state == 3){
				alert("All products was loaded, more products is grounding");
			}
		},
		error:function(){
			alert("loading failed, please retry");
		}
	});
	viewTimes++;
	
}

function createProduct(id, productDetail, imageName, productName){
	var product = '<div class="col-md-4 about-grid wow fadeInLeft animated" data-wow-delay=".5s">'+
						'<div class="about-img" id="'+id+'">'+
							'<img src="images/product/'+imageName+'.jpg" class="img-responsive" alt=""/>'+
						'</div>'+
						'<h4>'+productName+'</h4>'+
						'<p>'+productDetail+'</p>'+
					'</div>';
	$('#product_list_area').append(product);
}

function getSearchText(){
	var url = location.search;
	if (url.indexOf("?") != -1) {
        var n1 = url.length;//地址的总长度
        var n2 = url.indexOf("=");//取得=号的位置
        var id = decodeURI(url.substr(n2+1, n1-n2));//从=号后面的内容
        $('#search_text').val(id);
        if(id==""){
        	viewMoreProduct();
        }else{
        	viewProductBySearch();//产品查询结果显示（全部显示 不分页）
        }
	}else{
		viewMoreProduct();
	}
}
//产品查询结果显示（全部显示 不分页）
function viewProductBySearch(){
	var  searchText = $('#search_text').val().trim();
	$.ajax({
		url:path+"/product/listBySearch.do",
		type:"post",
		data:{"searchText":searchText},
		dataType:"json",
		success:function(result){
			if (result.state == 0) {
				// 获取返回的数据
				var products = result.data;
				clearProductList();
				// 循环读取
				for (var i = 0; i < products.length; i++) {
					var productName = products[i].productName;
					var imageName = products[i].imageName;
					var productDetail = products[i].productDetail;
					var id = products[i].id;
					createProduct(id, productDetail, imageName, productName);
				}
			}
			if(result.state == 3){
				alert("sorry， there is no product matched");
			}
		},
		error:function(){
			alert("loading failed, please retry");
		}
	});
}

function clearProductList(){
	$('#product_list_area').html('<div class="clearfix"></div>');
}