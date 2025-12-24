# OpenAPI Spring Boot Starter

`whh-openapi-starter` 是一个基于 OpenAPI 规范的统一接口文档规范 Starter，用于简化 Spring Boot 项目的 API 文档配置和生成。

## 功能特性

- **基于 OpenAPI 3.0 规范**：遵循标准的 OpenAPI 规范，生成标准化的 API 文档
- **自动配置**：通过 Spring Boot 自动配置机制，引入依赖后自动生效
- **可自定义配置**：提供 [OpenApiProperties](src/main/java/io/github/jacksonhua/OpenApiProperties.java#L0-L70) 配置类，支持自定义文档信息
- **集成 SpringDoc**：基于 SpringDoc OpenAPI 实现，与 Spring Boot 无缝集成
- **代码生成**：使用 OpenAPI Generator 根据 API 规范自动生成控制器接口和数据模型
- **默认 API 规范**：内置示例 API 规范文件，可作为模板使用

## 快速开始

### 1. 添加依赖

在项目的 [pom.xml](pom.xml) 中添加依赖：

```xml
<dependency>
    <groupId>io.github.jacksonhua</groupId>
    <artifactId>whh-openapi-starter</artifactId>
    <version>0.0.1-SNAPSHOT</version>
</dependency>
<!-- 添加 OpenAPI Generator 插件 -->
<build>
<plugins>
    <plugin>
        <groupId>org.openapitools</groupId>
        <artifactId>openapi-generator-maven-plugin</artifactId>
    </plugin>
</plugins>
</build>

```


### 2. 配置参数

在 `application.yml` 或 `application.properties` 中配置 API 文档信息：

```yaml
openapi:
  title: 我的项目API文档
  description: 项目API接口文档描述
  version: 1.0.0
  contact-name: 开发团队
  contact-email: team@example.com
  contact-url: https://www.example.com
  license-name: Apache 2.0
  license-url: https://www.apache.org/licenses/LICENSE-2.0.html
```


### 3. 使用生成的接口

Starter 会根据 `src/main/resources/openapi/api.yaml` 中定义的 API 规范生成控制器接口，开发者只需实现这些接口即可：

```java
@RestController
public class UsersController implements UsersApi {
    // 实现 UsersApi 中定义的方法
    @Override
    public UserDTO createUser(UserCreateDTO userCreateDTO) {
        // 实现创建用户逻辑
    }
}
```


## 配置属性

| 属性 | 默认值 | 说明 |
|------|--------|------|
| `openapi.title` | 统一接口文档 | API 文档标题 |
| `openapi.description` | 基于OpenAPI规范的统一接口文档 | API 文档描述 |
| `openapi.version` | 1.0.0 | API 版本号 |
| `openapi.contact-name` | 技术团队 | 联系人姓名 |
| `openapi.contact-email` | tech@example.com | 联系人邮箱 |
| `openapi.contact-url` | https://www.example.com | 联系人URL |
| `openapi.license-name` | Apache 2.0 | 许可证名称 |
| `openapi.license-url` | https://www.apache.org/licenses/LICENSE-2.0.html | 许可证URL |

## 生成的 API 接口

当前 Starter 根据 [api.yaml](classes\openapi\api.yaml) 文件生成了用户管理相关的接口：

- `GET /users` - 获取用户列表（支持分页）
- `POST /users` - 创建新用户
- `GET /users/{id}` - 获取用户详情
- `PUT /users/{id}` - 更新用户信息
- `DELETE /users/{id}` - 删除用户





## 项目结构

```
src
├── main
│   ├── java/io/github/jacksonhua
│   │   ├── OpenApiAutoConfiguration.java  # 自动配置类
│   │   └── OpenApiProperties.java         # 配置属性类
│   └── resources/openapi
│       └── api.yaml                       # API 规范文档
└── test
    └── java/io/github/jacksonhua
        ├── OpenApiAutoConfigurationTest.java
        └── OpenApiPropertiesTest.java
```


## API 规范文件

Starter 使用 `src/main/resources/openapi/api.yaml` 作为 API 规范文件，您可以根据项目需求修改此文件来定义自己的 API 接口。

## 许可证

Apache License, Version 2.0

## 开发者

- **王豪华** - [asd1194190200@qq.com](mailto:asd1194190200@qq.com)

# ISSUE 
## 返回ResponseEntity<T> 和 <T> 的思考
1. 对 HTTP 协议的控制力
   这是两者最本质的区别。

ResponseEntity<T>：它是一个包含了 HTTP 状态码 (Status Code)、响应头 (Headers) 和 响应体 (Body) 的完整对象。你可以手动控制任何细节。

示例：你可以根据逻辑返回 201 Created（创建成功）或 204 No Content（删除成功），而不仅仅是默认的 200 OK。

直接返回 UserDTO：你只能控制 响应体 (Body)。Spring MVC 默认会认为这次请求是成功的，从而自动封装成 200 OK 返回给客户端。
2. 灵活性与语义化
   ResponseEntity 更灵活：


```
@GetMapping("/{id}")
public ResponseEntity<UserDTO> getUser(@PathVariable String id) {
UserDTO user = userService.findById(id);
if (user == null) {
return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // 返回 404
}
return ResponseEntity.ok(user); // 返回 200 + 数据
}
```
UserDTO 比较死板： 如果你直接返回 UserDTO 却想返回 404 状态码，通常必须通过抛出异常（配合 @ControllerAdvice）来更改状态码。

3. 开发效率与代码简洁度
   直接返回 UserDTO（更简洁）： 代码看起来非常直观，就像在写普通的 Java 方法。在现代企业级开发中，很多团队会配合全局结果包装类（如 Result<T>）来统一格式。


```
@GetMapping("/{id}")
public UserDTO getUser(@PathVariable String id) {
return userService.findById(id);
}
```
ResponseEntity（稍显繁琐）： 每个接口都需要手动包装一层 ResponseEntity.ok(...)，代码量会稍多一些。
4. 异常处理机制的差异
   ResponseEntity：适合在 Controller 内部根据业务逻辑分支，显式地决定返回什么状态码。

   直接返回对象：通常依赖 “契约式开发”。如果出错了，由 Service 层抛出自定义异常，由全局异常处理器（@RestControllerAdvice）捕获并统一返回非 200 的状态码。
---

|:----:|:----:|:----:|
| 状态码控制 |	固定（默认 200），需通过异常改变  |	极其灵活，可任意指定
| 响应头控制 |	无法控制 |	可任意指定
| 代码可读性 |	极简，像普通方法 |	略显臃肿
|适用场景 |	内部系统、标准 CRUD、已有全局异常处理 |	RESTful API 规范要求严格、需要设置 Header、需要动态状态码
---

实际开发建议：

如果你追求严格的 RESTful 风格：建议使用 ResponseEntity，它能更精准地表达 HTTP 语义。 

如果你在做常规的企业级业务开发：建议直接返回自定义类（或者统一的 Result<T> 包装类）。通过 GlobalExceptionHandler 来处理 404、400、500 等异常情况，这样可以让 Controller 的逻辑最简化。

如果你在写面向公众的 Open API：建议严格遵循 RESTful 风格。因为外部开发者期望通过标准 HTTP 状态码（如 401 鉴权失败、429 限流）来快速判断错误类型，而不是去翻阅你自定义的几百个 code 码。
如果你在写公司内部的前后端分离项目：“200 OK + Result<T>” 往往更高效。此时 HTTP 协议被降级为一种“传输通道”，真正的协议是你定义的 Result 对象。
## 关于全局统一接口返回结构的思考
1. 在api.yml中

api.mustache 244行修改Void
添加