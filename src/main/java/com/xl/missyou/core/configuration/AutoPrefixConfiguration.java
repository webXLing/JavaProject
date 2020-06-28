package com.xl.missyou.core.configuration;

import com.xl.missyou.core.hack.AutoPrefixUrlMapping;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@Component
// 实现接口 加 加入容器  就能让sbring boot 知道 何时去调用
/**
 * 用于 api下的控制器 自动添加 文件前缀 无需手写
 */
public class AutoPrefixConfiguration implements WebMvcRegistrations {
    @Override
    public RequestMappingHandlerMapping getRequestMappingHandlerMapping() {
        return new AutoPrefixUrlMapping();
    }
}
