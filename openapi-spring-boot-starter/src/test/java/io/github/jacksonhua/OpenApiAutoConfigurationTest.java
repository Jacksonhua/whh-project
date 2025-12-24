package io.github.jacksonhua;

import io.github.jacksonhua.openApi.autoConfig.OpenApiAutoConfiguration;
import io.github.jacksonhua.openApi.autoConfig.OpenApiProperties;
import io.swagger.v3.oas.models.OpenAPI;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class OpenApiAutoConfigurationTest {
    private final ApplicationContextRunner contextRunner = new ApplicationContextRunner();



@Test
void testCustomOpenAPIContent() {
    this.contextRunner
        .withUserConfiguration(OpenApiAutoConfiguration.class)
        .run(context -> {

//            OpenApiProperties properties = context.getBean(OpenApiProperties.class);
//            System.out.println("properties.toString() = " + properties.toString());
            assertThat(context).hasSingleBean(OpenAPI.class);

            assertThat(context).hasBean("customOpenAPI");
            assertThat(context).hasSingleBean(OpenApiProperties.class);
            OpenAPI openAPI = context.getBean(OpenAPI.class);
            assertThat(openAPI.getInfo()).isNotNull();
            assertThat(openAPI.getInfo().getTitle()).isEqualTo("统一接口文档");
            assertThat(openAPI.getInfo().getDescription()).isEqualTo("基于OpenAPI规范的统一接口文档");
            assertThat(openAPI.getInfo().getVersion()).isEqualTo("1.0.0");
        });
}

}