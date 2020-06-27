package com.xl.missyou.core.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


// 指定配置文件的 属性前缀
@ConfigurationProperties(prefix = "xl")
// 指定 配置文件路径 在resource下
@PropertySource(value = "classpath:config/exception-code.properties")
@Component
public class ExceptionCodeConfig {
    private Integer code;
    private Map<Integer,String> codes = new HashMap<>();

    public String getMessage(int code){
        return codes.get(code);
    }

    public Integer getCode() {
        return code;
    }

    public Map<Integer, String> getCodes() {
        return codes;
    }
}
