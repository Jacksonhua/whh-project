package io.github.jacksonhua;

import io.github.jacksonhua.openApi.autoConfig.OpenApiProperties;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OpenApiPropertiesTest {
    private final ApplicationContextRunner contextRunner = new ApplicationContextRunner();

    @Test
    public void testDefaultValues() {
        OpenApiProperties properties = new OpenApiProperties();
        assertEquals("统一接口文档", properties.getTitle());
        assertEquals("基于OpenAPI规范的统一接口文档", properties.getDescription());
        assertEquals("1.0.0", properties.getVersion());
        assertEquals("技术团队", properties.getContactName());
        assertEquals("tech@example.com", properties.getContactEmail());
        assertEquals("https://www.example.com", properties.getContactUrl());
        assertEquals("Apache 2.0", properties.getLicenseName());
    }
    @Test
    public void testDefaultValues1() {
        this.contextRunner
                .withUserConfiguration(OpenApiProperties.class)
                .run(context -> {
                    assertThat(context).hasSingleBean(OpenApiProperties.class);
                    assertThat(context).hasBean("openApiProperties");
                    OpenApiProperties properties = context.getBean(OpenApiProperties.class);
                    assertEquals("统一接口文档", properties.getTitle());
                    assertEquals("基于OpenAPI规范的统一接口文档", properties.getDescription());
                    assertEquals("1.0.0", properties.getVersion());
                    assertEquals("技术团队", properties.getContactName());
                    assertEquals("tech@example.com", properties.getContactEmail());
                    assertEquals("https://www.example.com", properties.getContactUrl());
                    assertEquals("Apache 2.0", properties.getLicenseName());
                });


    }

}