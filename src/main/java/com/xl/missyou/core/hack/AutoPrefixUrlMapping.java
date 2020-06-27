package com.xl.missyou.core.hack;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import java.lang.reflect.Method;


public class AutoPrefixUrlMapping extends RequestMappingHandlerMapping {

    @Value("${xl-apiPakeage}")
    private String apiPackageName ;

    @Override
    protected RequestMappingInfo getMappingForMethod(Method method, Class<?> handlerType) {
        RequestMappingInfo requestMappingInfo = super.getMappingForMethod(method, handlerType);

        String prefix = this.getPrefix(handlerType);
        System.out.println(prefix);
        if(requestMappingInfo!=null){
            //   RequestMappingInfo.paths(prefix).build(). 前缀
          return   RequestMappingInfo.paths(prefix).build().combine(requestMappingInfo);
        }
        return  requestMappingInfo;
    }

    private String getPrefix(Class<?> handlerType){
        return handlerType.getPackage().getName().replaceAll(apiPackageName,"").replace(".","/");
    }

}
