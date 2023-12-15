package com.indiumsoft.myapigateway.config;

import com.indiumsoft.myapigateway.interceptor.RequestInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SecurityConfig implements WebMvcConfigurer {

    @Autowired
    RequestInterceptor requestInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry interceptorRegistry) {

        interceptorRegistry.addInterceptor(requestInterceptor);

    }


}
