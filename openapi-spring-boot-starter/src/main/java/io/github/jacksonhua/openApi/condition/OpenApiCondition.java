package io.github.jacksonhua.openApi.condition;

import io.github.jacksonhua.openApi.autoConfig.OpenApiProperties;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;

/**
 * 功能描述: 自定义Condition,用于确认是否生成OpenApi Bean
 *
 * @author whh
 * @version 1.0
 * @date 2025/12/25 0:36
 */
public class OpenApiCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        if (beanFactory == null) {
            return false;
        }
        // 获取 OpenApiProperties Bean
        try {
            OpenApiProperties props = beanFactory.getBean(OpenApiProperties.class);
            return  props.isEnabled();
        }catch (Exception e){
            Environment environment = context.getEnvironment();
            String property = environment.getProperty("whh.openapi.enabled", "true");
            return "true".equals(property);
        }

    }
}