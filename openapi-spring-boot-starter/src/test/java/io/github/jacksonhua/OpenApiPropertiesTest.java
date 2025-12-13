package io.github.jacksonhua;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OpenApiPropertiesTest {
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

}