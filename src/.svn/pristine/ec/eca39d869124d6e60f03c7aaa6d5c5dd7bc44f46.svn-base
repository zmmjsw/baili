package com.baili.api.manage;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baili.api.common.service.ApiCallService;

/**
* @ClassName: ApiTest 
* @Description: TODO(Alibaba接口参数) 
* @author Alex-晓帅
* @date 2018年11月12日 下午3:32:54
 */

public class ApiTest {



	private static String client_id = "8753130"; //公司帐号        
	private static String appSecretKey = "bCm18oe1jaj";
	/* String client_id = "8753130"; //公司帐号        
	 String appSecretKey = "bCm18oe1jaj";
	 String access_token="4dc182c8-ca6e-48d2-9b9d-0ac4e122c4db";*/
	private static String access_tokennew="1660c87c-dc1c-4f58-9542-fc838956a8d5";//主账号授权
	public static void main(String[] args) {
		//getOrderDetail();//获取订单信息
		//getaddresscode();//获取地址
		//getProductDetail();//获取非跨境产品信息
		//getbuyaddress();//获取买家地址
		//getBuyerOrderList();
		getAccountList();
		//oauth2subaccountadd();//进行授权
	//	oauth2subaccountauthlist();//查看授权列表
		
		//crossproductList();//获取跨进产品列表信息
		//crossproducdetail();//获取跨境产品详情信息
		//syncProductListPushed();//添加铺货信息
	}
	
	
	/**
	 * 获取买家地址信息
	 */
	public static  void  getbuyaddress(){
		 String urlHead="https://gw.open.1688.com/openapi/";
		 String urlPath="param2/1/com.alibaba.product/alibaba.trade.receiveAddress.get/"+client_id;
		 HashMap<String, String> map=new HashMap<String, String>();
		 map.put("access_token", "4dc182c8-ca6e-48d2-9b9d-0ac4e122c4db");
		map.put("client_id", client_id);
		 map.put("client_secret", appSecretKey);
		 /*  map.put("webSite","1688");
		 map.put("productID", "559027887882");*/
		 String result1="";
		 try{
			 result1 = ApiCallService.callApiTest(urlHead, urlPath, appSecretKey, map);
			 System.out.println(JSON.toJSONString(result1));
			// System.out.println("这是订单的详情："+result1);
		 }catch(Exception e){
			 System.out.println(e.getMessage());
		 }
	}
	
	//获取产品信息
	public  static void   getProductDetail(){
		 String urlHead="https://gw.open.1688.com/openapi/";
		 String urlPath="param2/1/com.alibaba.product/alibaba.product.get/"+client_id;
		 HashMap<String, String> map=new HashMap<String, String>();
		 map.put("access_token", "4dc182c8-ca6e-48d2-9b9d-0ac4e122c4db");
		 map.put("client_id", client_id);
		 map.put("client_secret", appSecretKey);
		 map.put("webSite","1688");
		 map.put("productID", "559027887882");
		 String result1="";
		 try{
			 result1 = ApiCallService.callApiTest(urlHead, urlPath, appSecretKey, map);
			 System.out.println(JSON.toJSONString(result1));
			// System.out.println("这是订单的详情："+result1);
		 }catch(Exception e){
			 System.out.println(e.getMessage());
		 }
	}
	
	public static void getOrderDetail(){
		 String urlHead="https://gw.open.1688.com/openapi/";
		 String urlPath="param2/1/com.alibaba.trade/alibaba.trade.get.buyerView/"+client_id;
		 HashMap<String, String> map=new HashMap<String, String>();
		// map.put("access_token", "8414f419-16c9-4267-a4db-0c7e825a1301");
		 map.put("access_token", "1660c87c-dc1c-4f58-9542-fc838956a8d5");
		 map.put("client_id", client_id);
		 map.put("client_secret", appSecretKey);
		 map.put("webSite","1688");
		 map.put("orderId", "248533504657536660");
		 //sellerID
		 //sellerLoginId   旺旺号名称
		 String result1="";
		 try{
			 result1 = ApiCallService.callApiTest(urlHead, urlPath, appSecretKey, map);
			 System.out.println(result1);
			 System.out.println(JSON.toJSONString(result1));
			// System.out.println("这是订单的详情："+result1);
		 }catch(Exception e){
			 System.out.println(e.getMessage());
		 }
	}
	
	//alibaba.trade.addresscode.parse
	/**
	 * 根据地址解析地区码
	 */
	public static void getaddresscode(){
		 String urlHead="https://gw.open.1688.com/openapi/";
		 String urlPath="param2/1/com.alibaba.trade/alibaba.trade.addresscode.parse/"+client_id;
		 HashMap<String, String> map=new HashMap<String, String>();
		 map.put("access_token", access_tokennew);
		 map.put("client_id", client_id);
		 map.put("client_secret", appSecretKey);
		 map.put("addressInfo", "江苏省 苏州市 昆山市 陆家镇 丰夏路16号北方物流园内北门大仓库3楼(上海竹亭贸易)");
		 String result1 = ApiCallService.callApiTest(urlHead, urlPath, appSecretKey, map);
		 System.out.println("返回结果:"+result1);
	}
	
	
	/**
	 * 获取订单列表
	 */
	public static void getBuyerOrderList(){
		 String urlHead="https://gw.open.1688.com/openapi/";
		 String urlPath="param2/1/com.alibaba.trade/alibaba.trade.getBuyerOrderList/"+client_id;
		 HashMap<String, String> map=new HashMap<String, String>();
		 map.put("access_token", "4dc182c8-ca6e-48d2-9b9d-0ac4e122c4db");
		 map.put("client_id", client_id);
		 map.put("client_secret", appSecretKey);
		 map.put("pageSize", 50+"");
		 map.put("page", 1+"");
		 Date date1=new Date();
	    /* Calendar calendar = new GregorianCalendar(); 
	     calendar.setTime(date1); 
	     calendar.add(calendar.DATE,-3);//把日期往后增加一天.整数往后推,负数往前移动 
	     Date date=calendar.getTime();  */ //这个时间就是日期往后推一天的结果 
		 String result1 = ApiCallService.callApiTest(urlHead, urlPath, appSecretKey, map);
		 System.out.println("返回结果:"+result1);
	}
	//获取子账号列表
	public static void getAccountList(){
		 String urlHead="https://gw.open.1688.com/openapi/";
		 String urlPath="param2/1/com.alibaba.account/alibaba.subAccount.list/"+client_id;
		 HashMap<String, String> map=new HashMap<String, String>();
		 map.put("access_token",access_tokennew);
		 map.put("client_id", client_id);
		 map.put("client_secret", appSecretKey);
		 String result1 = ApiCallService.callApiTest(urlHead, urlPath, appSecretKey, map);
		 JSONObject  jsonong=JSONObject.parseObject(result1);
		 
		 System.out.println("返回结果:"+result1);
	}//gw.open.1688.com  
	//子账号授权 system.oauth2:subaccount.auth.add
	
	public static void oauth2subaccountadd(){
		 String urlHead="https://gw.open.1688.com/openapi/";
		 String urlPath="param2/1/system.oauth2/subaccount.auth.add/"+client_id;
		 HashMap<String, String> map=new HashMap<String, String>();
		 //map.put("access_token", "4dc182c8-ca6e-48d2-9b9d-0ac4e122c4db");
		 map.put("access_token", "1660c87c-dc1c-4f58-9542-fc838956a8d5");
		 map.put("client_id", client_id);
		 map.put("client_secret", appSecretKey);
		 ArrayList<String>  strArray = new ArrayList<String> ();
		 strArray.add("竹亭01:zt241");
		 System.out.println(JSON.toJSONString(strArray));
		 map.put("subUserIdentityList",JSON.toJSONString(strArray));
		 String result1 = ApiCallService.callApiTest(urlHead, urlPath, appSecretKey, map);
		 System.out.println("返回结果:"+result1);
	}
	/**
	 * 子账号 取消授权
	 */
	public static void oauth2subaccountcancel(){
		 String urlHead="https://gw.open.1688.com/openapi/";
		 String urlPath="param2/1/system.oauth2/subaccount.auth.cancel/"+client_id;
		 HashMap<String, String> map=new HashMap<String, String>();
		 //map.put("access_token", "4dc182c8-ca6e-48d2-9b9d-0ac4e122c4db");
		 map.put("access_token", "4dc182c8-ca6e-48d2-9b9d-0ac4e122c4db");
		 map.put("client_id", client_id);
		 map.put("client_secret", appSecretKey);
		 ArrayList<String>  strArray = new ArrayList<String>();
		 strArray.add("竹亭01:zt064");
		 System.out.println(JSON.toJSONString(strArray));
		 map.put("subUserIdentityList",JSON.toJSONString(strArray));
		 String result1 = ApiCallService.callApiTest(urlHead, urlPath, appSecretKey, map);
		 System.out.println("返回结果:"+result1);
	}
	
	//批量查询子账号授权
	public static void oauth2subaccountauthlist(){
		 String urlHead="https://gw.open.1688.com/openapi/";
		 String urlPath="param2/1/system.oauth2/subaccount.auth.list/"+client_id;
		 HashMap<String, String> map=new HashMap<String, String>();
		 map.put("access_token", "1660c87c-dc1c-4f58-9542-fc838956a8d5");
		 map.put("client_id", client_id);
		 map.put("client_secret", appSecretKey);
		 ArrayList<String>  strArray = new ArrayList<String> ();
		 strArray.add("竹亭01:zt066");
		 System.out.println(JSON.toJSONString(strArray));
		 map.put("subUserIdentityList",JSON.toJSONString(strArray));
		 String result1 = ApiCallService.callApiTest(urlHead, urlPath, appSecretKey, map);
		 System.out.println("返回结果:"+result1);	
	}
	
	/*********************************商品铺货***************************************************/
	/**
	 * 获取铺货列表officeid 集合
	 */
	public static void crossproductList(){
		String uri = "http://gw.open.1688.com/openapi/"+client_id;
		//生成签名串
		String urlHead = "http://gw.open.1688.com/openapi/";
		String urlPath = "param2/1/com.alibaba.product/alibaba.cross.productList/" + client_id;
		//String urlPath1 = "param2/1/com.alibaba.product/alibaba.cross.productList/" + client_id;
		Map<String, String> params = new HashMap<String, String>();
        params.put("access_token",access_tokennew);
        params.put("productIdList", "[\"44756617644\"]");//520825948284
		String result = "";
		try {
			result = ApiCallService.callApiTest(urlHead, urlPath, appSecretKey,params);
		} catch (Exception e) {
			result = e.getMessage();
		}
		System.out.println(result);
	}
	/**
	 * 商品详情
	* @date   2018年10月29日 上午10:20:40 
	* @throws
	 */
	public static void crossproducdetail(){
		String uri = "http://gw.open.1688.com/openapi/"+client_id;
		//生成签名串
		String urlHead = "http://gw.open.1688.com/openapi/";
		String urlPath = "param2/1/com.alibaba.product/alibaba.cross.productInfo/" + client_id;
		//String urlPath1 = "param2/1/com.alibaba.product/alibaba.cross.productList/" + client_id;
		Map<String, String> params = new HashMap<String, String>();
        params.put("access_token",access_tokennew);
    	params.put("productId","44756617644");
		String result = "";
		try {
			result = ApiCallService.callApiTest(urlHead, urlPath, appSecretKey,params);
		} catch (Exception e) {
			result = e.getMessage();
		}
		System.out.println(result);
	}
	
	/**
	 * 添加铺货
	 */
	public static void syncProductListPushed(){
		//生成签名串
		String urlHead = "http://gw.open.1688.com/openapi/";
		String urlPath = "param2/1/com.alibaba.product.push/alibaba.cross.syncProductListPushed/" + client_id;
		String aaString = "520324398724";
		Map<String, String> params = new HashMap<String, String>();
        params.put("access_token", "4dc182c8-ca6e-48d2-9b9d-0ac4e122c4db");
        //params.put("productIdList", "[\"525930373758\"]");
        params.put("productIdList", "[\""+aaString+"\"]");
		String result = "";
		try {
			result = ApiCallService.callApiTest(urlHead, urlPath, appSecretKey,params);
		} catch (Exception e) {
			result = e.getMessage();
		}
		System.out.println(result);
	}
	
	

}
