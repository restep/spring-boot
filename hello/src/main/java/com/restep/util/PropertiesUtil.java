package com.restep.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author restep
 * @date 2019/4/9
 * @ConfigurationProperties(prefix="restep")，表示以restep开头的属性会自动赋值到对象的属性中
 * 比如restep.title会自动赋值到对象属性title中
 */
@Component
@ConfigurationProperties(prefix = "restep")
public class PropertiesUtil {
    private String title;
    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
