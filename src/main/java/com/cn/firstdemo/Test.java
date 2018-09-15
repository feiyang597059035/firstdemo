package com.cn.firstdemo;

import java.math.BigDecimal;

public class Test {
    public static void main(String[] args) {

        /*  // 1.JSON：fastJson的解析器，用于JSON格式字符串与JSON对象及javaBean之间的转换
        // 2.JSONObject：fastJson提供的json对象
        // 3.JSONArray：fastJson提供json数组对象
        
        // 当个字符转换为json
        String yy = "ss";
        String jsonString = JSON.toJSONString(yy);
        // System.out.println(jsonString);
        // json 转换为string
        String stringJosn = String.valueOf(jsonString);
        // System.out.println(stringJosn);
        
        Map<String, String> map = new HashMap<String, String>();
        map.put("dd", "rr");
        map.put("ff", "dd");
        String mapJson = JSON.toJSONString(map);
        // System.out.println(mapJson);
        // json 转换为jsonObject
        JSONObject jsonObject = JSONObject.parseObject(mapJson);
        String dd = jsonObject.getString("dd");
        String ff = jsonObject.getString("ee");
        // json 转换为map
        Map<String, String> map2 = JSONObject.parseObject(mapJson, Map.class);
        // System.out.println(map2.get("dd"));
        Map<String, String> map3 = JSON.toJavaObject(JSON.parseObject(mapJson), Map.class);
        // System.out.println(map3.get("dd"));
        // System.out.println(dd);
        // System.out.println(ff);
        // System.out.println(jsonObject);
        
        TUser user = new TUser();
        user.setName("ds");
        user.setPassword("sd");
        String objectJson = JSON.toJSONString(user);
        // System.out.println(objectJson);
        // json 转为jsonobject
        jsonObject = JSONObject.parseObject(objectJson);
        // System.out.println(jsonObject.get("name"));
        
        // json 转为javabean
        TUser tUser = JSON.parseObject(objectJson, TUser.class);
        TUser tt = JSON.toJavaObject(JSON.parseObject(objectJson), TUser.class);
        
        List<TUser> list = new ArrayList<TUser>();
        list.add(user);
        TUser user2 = new TUser();
        user2.setName("ds");
        user2.setPassword("sd");
        list.add(user2);
        String listJson = JSON.toJSONString(list);
        String listArrJson = JSONArray.toJSONString(list);
        String ss = JSONArray.toJSONString(yy);
        // System.out.println(listArrJson);
        // System.out.println(listJson);
        // System.out.println(ss);
        
        // json 转换为jsonArr
        JSONArray jsonArray = JSONArray.parseArray(listJson);
        for (int i = 0; i < jsonArray.size(); i++) {
            jsonObject = jsonArray.getJSONObject(i);
            System.out.println(jsonObject.getString("name"));
        }
        // json 转换为list
        List<TUser> list2 = (List<TUser>)JSONArray.parseArray(listJson, TUser.class);
        System.out.println(jsonArray);
        
        // map<string,object>
        Map<String, TUser> map4 = new HashMap<String, TUser>();
        map4.put("user", user);
        String mapobjectJson = JSON.toJSONString(map4);
        // System.out.println(mapobjectJson);
        // json 转换为jsonObject
        jsonObject = JSONObject.parseObject(mapobjectJson);
        String userJson = jsonObject.getString("user");
        
        TUser uTUser = JSON.toJavaObject(JSON.parseObject(userJson), TUser.class);
        TUser ssh = JSON.parseObject(userJson, TUser.class);
        System.out.println(jsonObject.getString("user"));*/

        /*    LinkedList<String> linkedList = new LinkedList();
        linkedList.addFirst("ss");
        linkedList.add("dd");
        linkedList.add("ee");
        linkedList.addLast("rr");
        linkedList.addFirst("bb");
        for (int i = 0; i < args.length; i++) {
        
        }
        System.out.println(linkedList);*/
        /*ConcurrentHashMap<K, V>
        Stack<String> stack = new Stack<String>();
        Vector<String> vector = new Vector<String>();
        stack.add("2");
        stack.add("1");
        System.out.println(stack.pop());*/

        /*  BigDecimal discountPrice = new BigDecimal(13200);
        Double discount = Double.valueOf("12.9");
        discountPrice = discountPrice.multiply(new BigDecimal(100 - discount)).divide(new BigDecimal(100));
        System.out.println(discountPrice);
        BigDecimal total = discountPrice.multiply(new BigDecimal(1));*/

        /*JSONObject jsonResult = new JSONObject();
        jsonResult.put("asOrderId", "2222");*/
        /*double minTotalAmount = 0L; // 最小报价
        double maxTotalAmount = 0L; // 最大报价
        double detailMinTotalAmount = 0L;
        double detailMaxTotalAmount = 0L;
        float f = 4.8f;
        Long minUnitPrice = 4l;
        Long maxUnitPrice = 4L;
        Integer qInteger = 1;
        detailMinTotalAmount = multiply(Float.parseFloat(String.valueOf(minUnitPrice)), qInteger.floatValue());
        
        detailMaxTotalAmount = multiply(Float.parseFloat(String.valueOf(maxUnitPrice)), qInteger.floatValue());
        
        System.out.println(Math.round(detailMinTotalAmount));
        System.out.println(Math.round(detailMaxTotalAmount));*/

        System.out.println(gets());

    }

    public static String gets() {
        try {
            System.out.println(111);
            Long iLong = 1L / 0;
            return "ss";
        } catch (Exception e) {
            System.out.println("222");

        } finally {
            System.out.println("3333");
        }
        System.out.println(7777);
        return "vv444";
        /*return "vv";*/
    }

    public static double multiply(Float value1, Float value2) {
        BigDecimal b1 = new BigDecimal(Double.toString(value1));
        BigDecimal b2 = new BigDecimal(Double.toString(value2));
        return b1.multiply(b2).doubleValue();
    }

}
