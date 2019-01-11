package com.baili.common.basecontroller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import com.baili.util.Sys;
import com.baili.util.Tools;

/**
 *获取request中携带参数
 */
public class PageData extends HashMap implements Map {
	
    private static final long serialVersionUID = 1L;

    Map map = null;
    HttpServletRequest request;
    public PageData(HttpServletRequest request){
        this.request = request;
        Map properties = request.getParameterMap();
        Map returnMap = new HashMap();
        Iterator entries = properties.entrySet().iterator();
        Entry entry;
        String name = "";
        String value = "";
        while (entries.hasNext()) {
            entry = (Entry) entries.next();
            name = (String) entry.getKey();
            Object valueObj = entry.getValue();
            if(null == valueObj){
                value = "";
            }else if(valueObj instanceof String[]){
                String[] values = (String[])valueObj;
                for(int i=0;i<values.length;i++){
                    value = values[i] + ",";
                }
                value = value.substring(0, value.length()-1);
            }else{
                value = valueObj.toString();
            }
            returnMap.put(name, value);
        }

        String page=""+ request.getParameter("page");
        String limit=""+ request.getParameter("limit");
            /**
             * 识别是否双数据源-存在共有参数
             */
        if(Tools.notEmpty(page) && Tools.notEmpty(limit)){
            /**
             * oracle
             */
            returnMap.put("startpage",Tools.getoraclestartpage(page,limit));//开启值
            returnMap.put("endpage",Tools.getendpage(page,limit));//结束值
            /**
             * mysql
             */
            returnMap.put("offset",Tools.getmysqlstartpage(page,limit));//开启值
            returnMap.put("offlimit",limit);//结束值
        }
        map = returnMap;
    }

    public PageData() {
        map = new HashMap();
    }

    @Override
    public Object get(Object key) {
        Object obj = null;
        if(map.get(key) instanceof Object[]) {
            Object[] arr = (Object[])map.get(key);
            obj = request == null ? arr:(request.getParameter((String)key) == null ? arr:arr[0]);
        } else {
            obj = map.get(key);
        }
        return obj;
    }

    public String getString(Object key) {
        try {
            return (String)get(key);
        } catch (Exception e) {
            return get(key).toString();
        }

    }

    @SuppressWarnings("unchecked")
    @Override
    public Object put(Object key, Object value) {
        return map.put(key, value);
    }

    @Override
    public Object remove(Object key) {
        return map.remove(key);
    }

    public void clear() {
        map.clear();
    }

    public boolean containsKey(Object key) {
        return map.containsKey(key);
    }

    public boolean containsValue(Object value) {
        return map.containsValue(value);
    }

    public Set entrySet() {
        return map.entrySet();
    }

    public boolean isEmpty() {
        return map.isEmpty();
    }

    public Set keySet() {
        return map.keySet();
    }

    @SuppressWarnings({ "unchecked" })
    public void putAll(Map t) {
        map.putAll(t);
    }

    public int size() {
        return map.size();
    }

    public Collection values() {
        return map.values();
    }

}
