package com.restep.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author restep
 * @date 2019/4/8
 */
@SpringBootApplication
public class ReadListApplication extends WebMvcConfigurerAdapter {
    public static void main(String[] args) {
        SpringApplication.run(ReadListApplication.class, args);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addRedirectViewController("/", "/readList");
    }
}
