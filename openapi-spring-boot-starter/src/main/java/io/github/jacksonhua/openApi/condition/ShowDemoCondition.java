package io.github.jacksonhua.openApi.condition;

import io.github.jacksonhua.openApi.autoConfig.OpenApiProperties;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 功能描述: 自定义 Condition,用于确认是否启用DemoController
 *
 * @author whh
 * @version 1.0
 * @date 2025/12/24 23:44
 */
public class ShowDemoCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        if (beanFactory == null) {
            return false;
        }

        // 获取 OpenApiProperties Bean
        try {
            OpenApiProperties props = beanFactory.getBean(OpenApiProperties.class);
            return  props.isShowDemo();
        }catch (Exception e){
            Environment environment = context.getEnvironment();
            String property = environment.getProperty("whh.openapi.show-demo", "false");
            return "true".equals(property);
        }
    }
}