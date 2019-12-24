package com.ljb.test;

import com.ljb.test.poxy.IConfig;
import com.ljb.test.poxy.PropertyManage;
import com.ljb.test.utils.CommonUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

@SpringBootApplication
public class TestApplication {
    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }

//    public static void main(String[] args) {
//        try {
//            File file = ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX + "config/db.properties");
//            FileInputStream is = new FileInputStream(file);
//            IConfig iConfig = PropertyManage.createProperties(is);
//            CommonUtils.logI("url", iConfig.url());
//            CommonUtils.logI("user", iConfig.user());
//            CommonUtils.logI("password", iConfig.password());
//            CommonUtils.logI("drivePath", iConfig.drivePath());
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//    }

}
