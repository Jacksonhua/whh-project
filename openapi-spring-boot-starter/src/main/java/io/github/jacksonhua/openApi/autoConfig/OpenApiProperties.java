package io.github.jacksonhua.openApi.autoConfig;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * OpenAPI 配置属性类，用于接收应用配置文件中的参数
 * @author whh
 */
@ConfigurationProperties(prefix = "whh.openapi")
@Data
public class OpenApiProperties {

    // API文档标题
    private String title = "统一接口文档";

    // API文档描述
    private String description = "基于OpenAPI规范的统一接口文档";

    // API版本号
    private String version = "1.0.0";

    // 联系人姓名
    private String contactName = "技术团队";

    // 联系人邮箱
    private String contactEmail = "tech@example.com";

    // 联系人URL
    private String contactUrl = "https://www.example.com";

    // 许可证名称
    private String licenseName = "Apache 2.0";

    // 许可证URL
    private String licenseUrl = "https://www.apache.org/licenses/LICENSE-2.0.html";

    private boolean showDemo = false;
    private boolean enabled = true;
}
