
# whh-project
我的项目脚手架
# 一、整理常用的依赖，整合自己的dependencies

这是一个完整的Maven依赖版本管理配置文件，基于Spring Boot 2.7.6生态体系。
## 使用方法
```xml

<dependencyManagement>
    <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>io.github.jacksonhua</groupId>
                <artifactId>whh-dependencies</artifactId>
                <version>1.0.4</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>
</dependencyManagement>
```
---

