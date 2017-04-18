package com.netease.java;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class JSONPrase {
    public static void main(String[] args) {
        DeliveryPeriod deliveryPeriod=new DeliveryPeriod();
        deliveryPeriod.setStart("9:00");
        deliveryPeriod.setEnd("11:30");
        
        DeliveryPeriod deliveryPeriod2=new DeliveryPeriod();
        deliveryPeriod2.setStart("13:00");
        deliveryPeriod2.setEnd("17:30");
        
        List<DeliveryPeriod> deliveryPeriods=new LinkedList<DeliveryPeriod>();
        deliveryPeriods.add(deliveryPeriod);
        deliveryPeriods.add(deliveryPeriod2);
        
        String json=JSON.toJSONString(deliveryPeriods);
        
       /* JSONArray array=JSONArray.parseArray(json);
        for (Object object : array) {
            String start=((JSONObject)object).getString("start");
            String end=((JSONObject)object).getString("end");  
            System.out.format("start: %s--end: %s\n", start,end);
            try {
                System.out.println("In Delivery Period?: "+isInDeliveryPeriod(start, end));
            }
            catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }*/
        System.out.println("In Delivery Period?: "+isInDeliveryPeriod(json));
    }
    
    private static boolean isInDeliveryPeriod(String start,String end) throws ParseException{
        SimpleDateFormat dateFormat=new SimpleDateFormat("HH:mm");
        Long startLong=dateFormat.parse(start).getTime();
        Long endLong=dateFormat.parse(end).getTime();
        String now=dateFormat.format(new Date());
        System.out.println(now);
        Long nowLong=dateFormat.parse(now).getTime();
        System.out.println(startLong);
        System.out.println(endLong);
        System.out.println(nowLong);
        if(endLong<startLong){
           return false; 
        }
        if(nowLong>=startLong&&nowLong<=endLong){
            return true;
        }else{
            return false;
        }
    }
    
    private static boolean isInDeliveryPeriod(String deliveryPeriodInfos){
        SimpleDateFormat dateFormat=new SimpleDateFormat("HH:mm");
        JSONArray array=JSONArray.parseArray(deliveryPeriodInfos);
        try {
            for (Object object : array) {
                //解析交收时间段信息
                String start=((JSONObject)object).getString("start");
                String end=((JSONObject)object).getString("end");  
               
                Long startLong=dateFormat.parse(start).getTime();
                Long endLong=dateFormat.parse(end).getTime();
                
                String now=dateFormat.format(new Date());
                Long nowLong=dateFormat.parse(now).getTime();
                
                if(endLong<startLong){
                   continue; 
                }
                if(nowLong>=startLong&&nowLong<=endLong){
                    return true;
                }
            } 
        }
        catch (Exception e) {
           
        }   
        return false;
    }
}
