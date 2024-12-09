package com.iejnnnmokkk.common.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

/**
 * @author Sun
 * @Demo class GsonUtils
 * @Description TODO
 * @date 2024/12/5 16:26
 */
public class GsonUtils {

    /**
     * 将 JSON 字符串解析为指定的实体类对象
     *
     * @param json
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T fromJson(String json, Class<T> clazz) {
        return new Gson().fromJson(json, clazz);
    }

    /**
     * 将 JSON 字符串解析为 List 集合
     *
     * @param json
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> List<T> fromJsonList(String json, Class<T> clazz) {
        Type listType = TypeToken.getParameterized(List.class, clazz).getType();
        return new Gson().fromJson(json, listType);
    }

    /**
     * 将实体类转为 JSON 字符串
     *
     * @param object
     * @return
     */
    public static String toJson(Object object) {
        return new Gson().toJson(object);
    }
}
