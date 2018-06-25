package com.xlove.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.xlove.interceptor.MloveInterceptor;

@Configuration
public class MloveWebAppConfigurer extends WebMvcConfigurerAdapter{
	
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        registry.addInterceptor(new MloveInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }
}
