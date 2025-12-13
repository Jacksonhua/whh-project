package io.github.jacksonhua;

import lombok.Data;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * OpenAPI 配置属性类，用于接收应用配置文件中的参数
 * @author whh
 */
@ConfigurationProperties(prefix = "openapi")
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

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getVersion() {
        return version;
    }

    public String getContactName() {
        return contactName;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public String getContactUrl() {
        return contactUrl;
    }

    public String getLicenseName() {
        return licenseName;
    }

    public String getLicenseUrl() {
        return licenseUrl;
    }
}
