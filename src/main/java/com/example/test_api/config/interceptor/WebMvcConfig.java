package com.example.test_api.config.interceptor;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class WebMvcConfig implements WebMvcConfigurer {

    // @Component 를 통해 빈 생성 필요
    // private final TokenValidInterceptor tokenValidInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /*registry.addInterceptor(tokenValidInterceptor)
                .excludePathPatterns("/css/**", "/images/**", "/js/**");*/

        registry.addInterceptor(new TokenValidInterceptor())
//                .addPathPatterns("/**")     // 해당 패턴들만 인터셉터 적용 -> addPathPatterns 메소드 없을 시 전체 적용
                .excludePathPatterns("/css/**", "/images/**", "/js/**", "/webjars/**");     // 해당 패턴의 주소/경로는 인터셉터 호출에서 제외
    }

    /*@Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("HEAD", "OPTIONS", "PATCH", "GET", "PUT", "POST", "DELETE")
                .allowedHeaders("*")
                .maxAge(600);
    }*/
}
