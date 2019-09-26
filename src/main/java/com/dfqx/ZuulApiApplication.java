package com.dfqx;

import com.dfqx.config.filter.AccessFilter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@SpringBootApplication
public class ZuulApiApplication {
    public static void main(String[] args){
        new SpringApplicationBuilder(ZuulApiApplication.class).web(true).run(args);
    }
    @Bean
    public AccessFilter accessFilter(){
        return new AccessFilter();
    }

    //自定义 服务路径映射规则  服务名-v1   映射为  /v1/服务名
//    @Bean
//    public PatternServiceRouteMapper serviceRouteMapper(){
//        return new PatternServiceRouteMapper(
//                "(?<name>^.+)-(?<version>v.+$)",
//                "${version}/${name}"
//        );
//    }
}
