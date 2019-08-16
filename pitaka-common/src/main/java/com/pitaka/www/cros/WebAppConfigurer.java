package com.pitaka.www.cros;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 跨域请求配置 CORS 具体参数可根据具体要求调整,此处暂时设置为所以请求都进行跨域允许访问
 * @author rx
 * @created 2018-8-10 11:01:51
 */
@Configuration
public class WebAppConfigurer{

    /**
     * configuration.setAllowCredentials():允许cookies跨域
     * configuration.addAllowedHeader():允许访问头信息,*代表全部
     * configuration.setMaxAge():预检请求的缓存时间(秒) 即在这个时间段里,对于相同的跨域请求不会在预查了
     * configuration.addAllowedMethod():允许请求的方法,*代表全部
     * @return
     */
    @Bean
    public CorsFilter corsFilter(){
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowCredentials(true);
        configuration.addAllowedOrigin("*");
        configuration.addAllowedHeader("*");
        configuration.setMaxAge(18000L);
        configuration.addAllowedMethod("GET");
        configuration.addAllowedMethod("PUT");
        configuration.addAllowedMethod("POST");
        configuration.addAllowedMethod("PATCH");
        configuration.addAllowedMethod("DELETE");
        configuration.addAllowedMethod("OPTIONS");
        source.registerCorsConfiguration("/**",configuration);
        return new CorsFilter(source);
    }

}
