package com.yuoumall.push.center.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yuoumall.push.center.entity.bto.SD001.SD001SCREQ;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author ZQY
 * @Date 2020/7/9
 * @Version 1.0
 * @Description
 */

public class ObjectUtil {

    private static final Logger log = LoggerFactory.getLogger(ObjectUtil.class);

    /**
     * 根据属性名获取属性值
     */
    public static Object getFieldValueByName(String fieldName, Object o) {
        try {
            String firstLetter = fieldName.substring(0, 1).toUpperCase();
            String getter = "get" + firstLetter + fieldName.substring(1);
            Method method = o.getClass().getMethod(getter, new Class[]{});
            Object value = method.invoke(o, new Object[]{});
            return value;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

    /**
     * 获取属性名数组
     */
    public static String[] getFiledName(Object o) {
        Field[] fields = o.getClass().getDeclaredFields();
        String[] fieldNames = new String[fields.length];
        for (int i = 0; i < fields.length; i++) {
            System.out.println(fields[i].getType());
            fieldNames[i] = fields[i].getName();
        }
        return fieldNames;
    }

    /**
     * 获取属性类型(type)，属性名(name)，属性值(value)的map组成的list
     */
    public static List getFiledsInfo(Object o) {
        Field[] fields = o.getClass().getDeclaredFields();
        String[] fieldNames = new String[fields.length];
        List list = new ArrayList();
        Map infoMap = null;
        for (int i = 0; i < fields.length; i++) {
            infoMap = new HashMap();
            infoMap.put("type", fields[i].getType().toString());
            infoMap.put("name", fields[i].getName());
            infoMap.put("value", getFieldValueByName(fields[i].getName(), o));
            list.add(infoMap);
        }
        return list;
    }

    /**
     * 获取对象的所有属性值，返回一个对象数组
     */
    public static Object[] getFiledValues(Object o) {
        String[] fieldNames = getFiledName(o);
        Object[] value = new Object[fieldNames.length];
        for (int i = 0; i < fieldNames.length; i++) {
            value[i] = getFieldValueByName(fieldNames[i], o);
        }
        return value;
    }


    /**
     * 获取对象的第一个属性值
     */
    public static Object getFirstFiledValue(Object o) {
        String firstFileName = o.getClass().getDeclaredFields()[0].getName();
        String firstLetter = firstFileName.substring(0, 1).toUpperCase();
        String getter = "get" + firstLetter + firstFileName.substring(1);
        try {
            Method method = o.getClass().getMethod(getter, new Class[]{});
            Object value = method.invoke(o, new Object[]{});
            return value;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

    public static void main(String[] args) {
        Object o = new SD001SCREQ();
        String firstFileName = o.getClass().getDeclaredFields()[0].getName();
        String firstLetter = firstFileName.substring(0, 1).toUpperCase();
        String getter = "get" + firstLetter + firstFileName.substring(1);
        try {
            Method method = o.getClass().getMethod(getter, new Class[]{});
            Object value = method.invoke(o, new Object[]{});
            System.out.println(value);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
}