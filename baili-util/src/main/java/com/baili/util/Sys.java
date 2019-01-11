package com.baili.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
* @ClassName: SystemUtil 
* @Description: TODO(项目系统工具) 
* @author Yuanquan
* @date 2018年4月23日 下午6:46:26
 */
public class Sys {

	/**
	* @Title: isNull 
	* @Description: TODO(判断字段区) 
	* @param @param str
	* @param @return    设定文件 
	* @return boolean    返回类型
	* @author Yuanquan
	* @throws
	 */
	 public static boolean isNull(String str) {//判定是否为空值
	        //		System.out.println("!!!");
	        if (null == str || str.length() <= 0 || str.equals("null")) {
	            return true;
	        }
	        return false;
	    }

	    public static boolean isNotNull(String str) {//判定是否为空值
	        //      System.out.println("!!!");
	        if (null == str || str.length() <= 0 || str.equals("null") || "".equals(str)) {
	            return false;
	        }
	        return true;
	    }
   /**
    * 时间格式区
    */
	 //获取当前时间
	 public static String getNowDate(){
		 SimpleDateFormat simp=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		 String nowdatetime=simp.format(new Date());
		 return nowdatetime;
	 }
	 //时间格式化
	 public static String getDatetime(Date date){
		 SimpleDateFormat simp=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 return simp.format(date);
	 }
	 //获取时间
	 public static java.sql.Date getSQLDate(){
	 		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	 		try {
				return new java.sql.Date(f.parse(f.format(new Date())).getTime());
			} catch (ParseException e) {
				return null;
			}
	 	}
	 
	 //math 函数方法
	 public static boolean isNumeric(String str){
		 for (int i = str.length();--i>=0;){ 
		 if (!Character.isDigit(str.charAt(i))){
		 return false;
		 }
		 }
		 return true;
		}
	 //字符串操作
	 	/**
	     * 判断是否含有特殊字符
	     * @param str
	     * @return true为包含，false为不包含
	     */
	    public static boolean isNotSpecialChar(String str) {
	        String regEx = "[ _`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]|\n|\r|\t";
	        Pattern p = Pattern.compile(regEx);
	        Matcher m = p.matcher(str);
	        return  m.find();
	    }
	    
	    public static void main(String[] args) {
			System.out.println(isNotSpecialChar("袁泉"));
		}
}

