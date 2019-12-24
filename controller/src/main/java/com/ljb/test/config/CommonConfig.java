package com.ljb.test.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CommonConfig implements WebMvcConfigurer {
    @Value("${file.picture-mapping-path}")//访问图片前缀
    private String pictureMappingPath;
    @Value("${file.root-path}")//文件保存的根目录
    private String rootPath;
    @Value("${file.picture-path}")//图片存储目录
    private String picturePath;

    /**
     * 访问服务器图片目录映射
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(pictureMappingPath).addResourceLocations("file:" + rootPath + picturePath);
    }
}
