package com.baili.api.manage.cross;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.baili.api.common.service.ApiCallService;
import com.baili.api.entity.crossorder.AddressParam;
import com.baili.api.entity.crossorder.CargoParamList;

/**
* @ClassName: CrossApi  调用1688跨境 采购-api
* @author Alex-晓帅
* @date 2018年10月24日 上午11:02:14
 */

@Component
public class CrossApi {

	@Value("${alibaba.token.clientid}")
	private String clientid;
	
	@Value("${alibaba.token.appSecretKey}")
	private String appSecretKey;

	@Value("${alibaba.token.alitoken}")
	private String alitoken;


	/**
     * 获取地址码
	 * "北苑街道柳青八区9幢2单元4楼（义乌市仕辰贸易有限公司）"
     * @param token
     */
    public  String  getaddresscode(String addressInfo){
		 String urlHead="https://gw.open.1688.com/openapi/";
		 String urlPath="param2/1/com.alibaba.trade/alibaba.trade.addresscode.parse/"+clientid;
		 HashMap<String, String> map=new HashMap<String, String>();
		 map.put("access_token", alitoken);
		 map.put("client_id", clientid);
		 map.put("client_secret", appSecretKey);
		 map.put("addressInfo", addressInfo);
		 return  ApiCallService.callApiTest(urlHead, urlPath, appSecretKey, map);
	}
	/**
	 *获取订单信息
	 */
	public  String  getorderdetail(String orderid){
		String urlHead="https://gw.open.1688.com/openapi/";
		String urlPath="param2/1/com.alibaba.trade/alibaba.trade.get.buyerView/"+clientid;
		HashMap<String, String> map=new HashMap<String, String>();
		map.put("access_token", alitoken);
		map.put("client_id", clientid);
		map.put("client_secret", appSecretKey);
		map.put("webSite","1688");
		map.put("orderId", orderid);
		return  ApiCallService.callApiTest(urlHead, urlPath, appSecretKey, map);
	}
	/**
	 * 创建订单
	 */
	public  String  createorder(AddressParam addres, List<CargoParamList> product, String token){
		String urlHead="https://gw.open.1688.com/openapi/";
		String urlPath="param2/1/com.alibaba.trade/alibaba.trade.createCrossOrder/"+clientid;
		HashMap<String, String> map=new HashMap<String, String>();
		map.put("access_token", token);
		map.put("client_id", clientid);
		map.put("client_secret", appSecretKey);
		map.put("flow","general");
		map.put("addressParam", JSON.toJSONString(addres));
		map.put("cargoParamList",JSON.toJSONString(product));
		return  ApiCallService.callApiTest(urlHead, urlPath, appSecretKey, map);
	}
	/**
	 * 创建付款链接
	 */
	public  String  createpayurl(List<String> orderid){
		String urlHead="https://gw.open.1688.com/openapi/";
		String urlPath="param2/1/com.alibaba.trade/alibaba.alipay.url.get/"+clientid;
		HashMap<String, String> map=new HashMap<String, String>();
		map.put("access_token", alitoken);
		map.put("client_id", clientid);
		map.put("client_secret", appSecretKey);
		map.put("orderIdList",JSON.toJSONString(orderid));
		return  ApiCallService.callApiTest(urlHead, urlPath, appSecretKey, map);
	}
	/**
	 * 获取物流信息 发件人 收件人 物流单号
	 */
	public  String  getlogistics(String orderid){
		String urlHead="https://gw.open.1688.com/openapi/";
		String urlPath="param2/1/com.alibaba.logistics/alibaba.trade.getLogisticsInfos.buyerView/"+clientid;
		HashMap<String, String> map=new HashMap<String, String>();
		map.put("access_token", alitoken);
		map.put("client_id", clientid);
		map.put("client_secret", appSecretKey);
		map.put("orderId", orderid);
		map.put("fields", "company,name,sender,receiver,sendgood");
		map.put("webSite", "1688");
		return  ApiCallService.callApiTest(urlHead, urlPath, appSecretKey, map);
	}
	/**
	 * 获取物流轨迹信息
	 */
	public  String  getLogisticsTraceInfo(String orderid){
		String urlHead="https://gw.open.1688.com/openapi/";
		String urlPath="param2/1/com.alibaba.logistics/alibaba.trade.getLogisticsTraceInfo.buyerView/"+clientid;
		HashMap<String, String> map=new HashMap<String, String>();
		map.put("access_token", alitoken);
		map.put("client_id", clientid);
		map.put("client_secret", appSecretKey);
		map.put("orderId", orderid);
		map.put("webSite", "1688");
		return  ApiCallService.callApiTest(urlHead, urlPath, appSecretKey, map);
	}
	/**
	 * 取消订单交易
	 */
	public  String  tradecancel(String orderid){
		String urlHead="https://gw.open.1688.com/openapi/";
		String urlPath="param2/1/com.alibaba.trade/alibaba.trade.cancel/"+clientid;
		HashMap<String, String> map=new HashMap<String, String>();
		map.put("access_token", alitoken);
		map.put("client_id", clientid);
		map.put("client_secret", appSecretKey);
		map.put("tradeID", orderid);
		map.put("cancelReason","buyerCancel");
		map.put("webSite", "1688");
		return  ApiCallService.callApiTest(urlHead, urlPath, appSecretKey, map);
	}
	/**
	 * 获取授权用户信息
	 */
	public  String  getaccountbasic(String domain){//旺铺点名
		String urlHead="https://gw.open.1688.com/openapi/";
		String urlPath="param2/1/com.alibaba.account/alibaba.account.basic/"+clientid;
		HashMap<String, String> map=new HashMap<String, String>();
		map.put("access_token", alitoken);
		map.put("client_id", clientid);
		map.put("client_secret", appSecretKey);
		map.put("domain", domain);
		return  ApiCallService.callApiTest(urlHead, urlPath, appSecretKey, map);
	}
	
}