package io.github.jacksonhua.openApi.autoConfig;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * OpenAPI 自动配置类，当其他项目引入此Starter时自动生效
 * @author whh
 */
@Configuration
@EnableConfigurationProperties(OpenApiProperties.class)
//@Conditional(OpenApiCondition.class)
public class OpenApiAutoConfiguration {



    /**
     * 提供默认的OpenAPI配置，允许用户在自己的项目中自定义覆盖
     * @param properties properties
     * @return OpenAPI对象
     */
    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(prefix = "whh.openapi", name = "enabled", havingValue = "true",matchIfMissing = true)
    public OpenAPI customOpenAPI(OpenApiProperties properties) {
        // 构建联系人信息
        Contact contact = new Contact()
                .name(properties.getContactName())
                .email(properties.getContactEmail())
                .url(properties.getContactUrl());
        
        // 构建许可证信息
        License license = new License()
                .name(properties.getLicenseName())
                .url(properties.getLicenseUrl());
        
        // 构建API基本信息
        Info info = new Info()
                .title(properties.getTitle())
                .description(properties.getDescription())
                .version(properties.getVersion())
                .contact(contact)
                .license(license);
        
        return new OpenAPI().info(info);
    }
}
    