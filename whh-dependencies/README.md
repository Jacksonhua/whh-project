
# 整理常用的依赖，整合自己的dependencies

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

## 目录

- [Java 配置](#java-配置)
- [Spring 生态](#spring-生态)
- [数据库相关](#数据库相关)
- [Web 与 API](#web-与-api)
- [通用工具库](#通用工具库)
    - [Apache Commons](#apache-commons)
    - [JSON 处理](#json-处理)
    - [国产工具](#国产工具)
- [安全认证](#安全认证)
- [缓存与消息](#缓存与消息)
- [特殊功能](#特殊功能)
    - [文件处理](#文件处理)
    - [图表](#图表)
    - [网络](#网络)
- [代码增强](#代码增强)
- [监控与诊断](#监控与诊断)
- [测试框架](#测试框架)
- [使用方法](#使用方法)
---

## Java 配置
| 属性 | 版本 | 用途说明 |
|------|------|----------|
| `java.version` | 1.8 | Java 版本 |
| `maven.compiler.source` | ${java.version} | Maven编译器源码版本 |
| `maven.compiler.target` | ${java.version} | Maven编译器目标版本 |
| `project.build.sourceEncoding` | UTF-8 | 项目源码编码 |
| `project.reporting.outputEncoding` | UTF-8 | 项目报告输出编码 |
| `maven-compiler-plugin.version` | 3.11.0 | Maven编译器插件版本 |

---

## Spring 生态
| 属性 | 版本 | 用途说明 |
|------|------|----------|
| `spring-boot.version` | 2.7.6 | Spring Boot 主版本 |
| `spring-cloud.version` | 2021.0.5 | Spring Cloud 版本 |
| `spring-cloud-alibaba.version` | 2021.0.5.0 | Spring Cloud Alibaba 版本 |

---

## 数据库相关
| 属性 | 版本 | 用途说明 |
|------|------|----------|
| `mybatis-plus.version` | 3.5.3.1 | MyBatis Plus ORM框架 |
| `dynamic-datasource.version` | 3.6.1 | 动态数据源 |
| `druid.version` | 1.2.15 | Druid数据库连接池 |
| `mybatis-spring.version` | 2.1.1 | MyBatis Spring集成 |
| `pagehelper.version` | 1.4.6 | 分页插件 |
| `p6spy.version` | 3.9.1 | SQL审计日志 |

---

## Web 与 API
| 属性 | 版本 | 用途说明 |
|------|------|----------|
| `springdoc-openapi.version` | 1.6.15 | SpringDoc OpenAPI 3文档 |
| `knife4j.version` | 4.0.0 | Knife4j API文档增强UI |
| `servlet-api.version` | 4.0.1 | Servlet API |
| `jsoup.version` | 1.15.4 | HTML解析库 |

---

## 通用工具库

### Apache Commons
| 属性 | 版本 | 用途说明 |
|------|------|----------|
| `commons-lang3.version` | 3.12.0 | Apache Commons Lang3 |
| `commons-collections4.version` | 4.4 | Apache Commons Collections4 |
| `commons-io.version` | 2.11.0 | Apache Commons IO |
| `commons-codec.version` | 1.15 | Apache Commons Codec |
| `commons-pool2.version` | 2.11.1 | Apache Commons Pool2 |

### JSON 处理
| 属性 | 版本 | 用途说明 |
|------|------|----------|
| `jackson.version` | 2.13.4 | Jackson JSON处理库 |
| `gson.version` | 2.10 | Google Gson JSON库 |
| `fastjson2.version` | 2.0.25 | 阿里Fastjson2高性能JSON库 |
| `json-path.version` | 2.7.0 | JSON Path表达式库 |

### 国产工具
| 属性 | 版本 | 用途说明 |
|------|------|----------|
| `hutool.version` | 5.8.16 | Hutool工具库 |

---

## 安全认证
| 属性 | 版本 | 用途说明 |
|------|------|----------|
| `sa-token.version` | 1.34.0 | Sa-Token权限认证框架 |
| `jjwt.version` | 0.11.5 | Java JWT库 |
| `bcprov-jdk18on.version` | 1.72 | BouncyCastle加密库（支持国密） |
| `hutool-crypto.version` | 5.8.16 | Hutool加密工具（数据脱敏） |

---

## 缓存与消息
| 属性 | 版本 | 用途说明 |
|------|------|----------|
| `redisson.version` | 3.18.0 | Redisson Redis客户端 |
| `rocketmq.version` | 4.9.4 | RocketMQ消息队列 |

---

## 特殊功能

### 文件处理
| 属性 | 版本 | 用途说明 |
|------|------|----------|
| `poi.version` | 5.2.3 | Apache POI Excel处理 |
| `easyexcel.version` | 3.2.1 | 阿里EasyExcel |
| `pdfbox.version` | 2.0.27 | PDFBox PDF处理 |
| `itextpdf.version` | 7.2.5 | iText PDF生成 |

### 图表
| 属性 | 版本 | 用途说明 |
|------|------|----------|
| `echarts.version` | 5.4.1 | ECharts图表库 |
| `jfreechart.version` | 1.5.3 | JFreeChart Java图表库 |

### 网络
| 属性 | 版本 | 用途说明 |
|------|------|----------|
| `okhttp.version` | 4.10.0 | OkHttp HTTP客户端 |
| `httpclient.version` | 4.5.13 | Apache HttpClient |

---

## 代码增强
| 属性 | 版本 | 用途说明 |
|------|------|----------|
| `mapstruct.version` | 1.5.3.Final | MapStruct对象映射 |
| `lombok-mapstruct-binding.version` | 0.2.0 | Lombok + MapStruct兼容插件 |
| `guava.version` | 31.1-jre | Google Guava工具库 |

---

## 监控与诊断
| 属性 | 版本 | 用途说明 |
|------|------|----------|
| `micrometer.version` | 1.10.5 | Micrometer应用监控 |
| `prometheus.version` | 0.16.0 | Prometheus监控客户端 |

---

## 测试框架
| 属性 | 版本 | 用途说明 |
|------|------|----------|
| `testcontainers.version` | 1.17.6 | TestContainers测试容器 |
| `mockito.version` | 4.11.0 | Mockito模拟测试框架 |
| `oshi.version` | 6.6.5 | OSHI系统信息获取 |

---



