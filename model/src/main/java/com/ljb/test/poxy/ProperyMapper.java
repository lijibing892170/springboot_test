package com.ljb.test.poxy;

import com.ljb.test.annotation.Property;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Properties;

public class ProperyMapper implements InvocationHandler {
    private Properties properties;

    public ProperyMapper(Properties properties) {
        this.properties = properties;
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        Property property = method.getAnnotation(Property.class);

        if (null == properties || null == property) return null;

        String key = property.value();

        if (null == key || "".equals(key)) return null;

        String value = properties.getProperty(key);

        Class<?> type = method.getReturnType();
        if (type.isPrimitive()) {//判断参数是不是标准类型
            if (type.equals(int.class)) {
                return Integer.parseInt(value);
            } else if (type.equals(double.class)) {
                return Double.parseDouble(value);
            } else if (type.equals(float.class)) {
                return Float.parseFloat(value);
            } else if (type.equals(long.class)) {
                return Long.parseLong(value);
            } else if (type.equals(boolean.class)) {
                return Long.parseLong(value);
            }
        }

        return value;
    }
}
