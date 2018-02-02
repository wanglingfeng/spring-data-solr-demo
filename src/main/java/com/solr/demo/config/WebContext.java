package com.solr.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

@Configuration
public class WebContext {

    @Bean
    public WebMvcConfigurerAdapter mvcViewConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("search");
                registry.addViewController("/monitor").setViewName("monitor");
            }

            @Override
            public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
                argumentResolvers.add(new PageableHandlerMethodArgumentResolver());
            }
        };
    }
}
