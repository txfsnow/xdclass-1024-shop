package net.xdclass.config;

import feign.RequestInterceptor;
import lombok.extern.slf4j.Slf4j;
import net.xdclass.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;

/**
 * 小滴课堂,愿景：让技术不再难学
 *
 * @Description
 * @Author 二当家小D
 * @Remark 有问题直接联系我，源码-笔记-技术交流群
 * @Version 1.0
 **/

@Configuration
@Slf4j
public class InterceptorConfig  implements WebMvcConfigurer {




    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new LoginInterceptor())
                //拦截的路径
                .addPathPatterns("/api/user/*/**","/api/address/*/**")

                //排查不拦截的路径
                .excludePathPatterns("/api/user/*/send_code","/api/user/*/captcha",
                        "/api/user/*/register","/api/user/*/login","/api/user/*/upload");

    }


}
