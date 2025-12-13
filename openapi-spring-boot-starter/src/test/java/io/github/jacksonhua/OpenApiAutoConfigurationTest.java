package io.github.jacksonhua;

import io.swagger.v3.oas.models.OpenAPI;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OpenApiAutoConfigurationTest {
    private final ApplicationContextRunner contextRunner = new ApplicationContextRunner();



@Test
void testCustomOpenAPIContent() {
    this.contextRunner
        .withUserConfiguration(OpenApiAutoConfiguration.class)
        .run(context -> {
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