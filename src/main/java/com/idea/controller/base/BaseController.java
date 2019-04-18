package com.idea.controller.base;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @Program: BaseController
 * @Description: 基础控制器（公有属性）
 * @Author: Mr.Zhao
 * @Create: 2019-04-17 18:28
 **/
public class BaseController {
    private static final long serialVersionUID = 6357869213649815390L;

    /**
     * @param fastJson
     */
    protected JSONObject json = new JSONObject();
    /**
     * fastjson JSONArray
     */
    protected JSONArray jsonArray = new JSONArray();
    /**
     * fastjson用法
     * 对象转json字符串 String json = json.toJSONString(对象);
     * 字符串转json对象 json =json.parseObject(jsonStr);
     * 字符串转java对象 Object object = JSON.parseObject(jsonStr, Object.class);
     * 字符串转list  List<Object> list = JSON.parseArray(jsonStr, Object.class);
     */
}
