package com.netease.java;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class PraseJSON {
    public static void main(String[] args) {
        List<CommodityTODelivery> list=new LinkedList<CommodityTODelivery>();
        
        CommodityTODelivery commodityTODelivery=new CommodityTODelivery();
        commodityTODelivery.setCommodityId("龙贵银");
        List<String> deliveries=new LinkedList<String>();
        deliveries.add("银锭100g");
        deliveries.add("银锭500g");
        commodityTODelivery.setDeliveryCommodityIds(deliveries);
        
        CommodityTODelivery commodityTODelivery2=new CommodityTODelivery();
        commodityTODelivery2.setCommodityId("龙贵钯");
        List<String> deliveries2=new LinkedList<String>();
        deliveries2.add("银钯100g");
        deliveries2.add("银钯500g");
        deliveries2.add("银钯1000g");
        commodityTODelivery2.setDeliveryCommodityIds(deliveries2);
        
        list.add(commodityTODelivery);
        list.add(commodityTODelivery2);
        
        String json=JSON.toJSONString(list);
        Map<String,List<Object>> relationshops=parseTradeToDelivery(json);
        for (String string : relationshops.keySet()) {
            List<Object> objects=relationshops.get(string);
            System.out.print(string+" : ");
            for (Object object : objects) {
                System.out.print(object+" ");
            }
            System.out.println("");
        }
    }
    
    
    private static Map<String,List<Object>> parseTradeToDelivery(String json){
        Map<String,List<Object>> result=new HashMap<String,List<Object>>();
        JSONArray array=JSONArray.parseArray(json);
        for (Object object : array) {
            String commodityID=((JSONObject)object).getString("commodityId");
            String deliveryCMDs=((JSONObject)object).getString("deliveryCommodityId");
            List<Object> array2=JSONArray.parseArray(deliveryCMDs);
            result.put(commodityID, array2);
        } 
        return result;
    }
}
