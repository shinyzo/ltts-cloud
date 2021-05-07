package com.lming.ltts.common.jwt.config;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ArrayUtil;
import com.lming.ltts.common.jwt.interceptor.JwtInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author: liangming.zhang
 * Date : 2021/4/27 - 16:56
 * Description:
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private JwtProperties jwtProperties;

    @Autowired
    private JwtInterceptor jwtInterceptor;

    public static String[] DEFAULT_IGNORE_URLS = {
            "/v2/api-docs","/doc.html","/swagger-resources/**",
            "/webjars/css/**", "/webjars/js/**"
        };


    /**
     * 添加拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        //拦截路径可自行配置多个 可用 ，分隔开
        registry.addInterceptor(jwtInterceptor)
                .addPathPatterns(getAuthUrls())
                .excludePathPatterns(getIgnoreUrls());
    }


    private List<String> getAuthUrls(){
        List<String> authUrls = new ArrayList<>();
        if(CollectionUtil.isEmpty(jwtProperties.getAuthUrls())){
            authUrls.add("/**");
        }
        return authUrls;
    }

    private List<String> getIgnoreUrls(){
        List<String> ignoreAuthUrls = new ArrayList<>();
        ignoreAuthUrls.addAll(Arrays.asList(DEFAULT_IGNORE_URLS));
        if(CollectionUtil.isNotEmpty(jwtProperties.getIgnoreUrls())){
            ignoreAuthUrls.addAll(jwtProperties.getIgnoreUrls());
        }
        return ignoreAuthUrls;
    }


    /**
     * 跨域支持
     *
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowCredentials(true)
                .allowedMethods("GET", "POST", "DELETE", "PUT", "PATCH", "OPTIONS", "HEAD")
                .maxAge(3600 * 24);
    }


}
