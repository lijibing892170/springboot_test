package com.ljb.test.poxy;

import com.ljb.test.utils.CommonUtils;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Proxy;
import java.util.Properties;

public class PropertyManage {

    public static IConfig createProperties(InputStream is) {
        try {
            Properties properties = new Properties();
            properties.load(is);
            return (IConfig) Proxy.newProxyInstance(IConfig.class.getClassLoader(), new Class[]{IConfig.class}, new ProperyMapper(properties));
        } catch (IOException e) {
            CommonUtils.logI("PropertyManage", e.getMessage());
        }
        return null;
    }
}
