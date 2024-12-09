package com.example.config;


import com.example.handler.LoginInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Configuration
@Slf4j
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //跨域问题
        registry.addInterceptor(new HandlerInterceptor() {
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
                if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
                    // 对于 OPTIONS 请求，返回预检响应并允许所有源和方法
                    response.setHeader("Access-Control-Allow-Origin", "*"); // 允许所有源
                    response.setHeader("Access-Control-Allow-Methods", "*"); // 允许所有方法（虽然这不是标准用法，但某些浏览器可能接受）
                    response.setHeader("Access-Control-Allow-Headers", "Token,Content-Type"); // 允许携带 Token 字段和其他可能需要的头
                    response.setHeader("Access-Control-Max-Age", "3600"); // 预检请求的有效时间（秒），可按需调整
                    response.setStatus(HttpServletResponse.SC_OK); // 设置响应状态码为 200 OK
                    return false; // 通常 OPTIONS 请求在 HandlerInterceptor 中处理完毕后不继续执行后续拦截器或处理器
                }
                return true;
            }
        });
//       拦截器
        registry.addInterceptor(new LoginInterceptor())
                //拦截的路径
                .addPathPatterns("/api/*/**")

                //排查不拦截的路径
                .excludePathPatterns("/api/*/register", "/api/*/login");
    }
}