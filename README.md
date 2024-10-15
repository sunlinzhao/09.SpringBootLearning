<h2 id="nOtZp"> SpringBoot 框架简介</h2>
> 官网：[https://spring.io/](https://spring.io/)
>

<h3 id="tQc9s">优势 ⭐</h3>
+ 基于 spring4.0 设计，**<font style="color:#DF2A3F;">简化 spring 程序的设计和开发过程</font>**；
+ **<font style="color:#DF2A3F;">集成大量的框架</font>**，使用版本冲突和不稳定性得到一个很好的解决；
+ 可以创建独立的 spring 应用程序，基于 maven 或 gradle 插件，生成 jar 文件或 war 文件；
+ **<font style="color:#DF2A3F;">内嵌了容器</font>**：Tomcat、Jetty、Undertow；
+ 使程序直接**<font style="color:#DF2A3F;">通过主方法运行</font>**起来；
+ 提供了 "starter" 项目对象模型，来**<font style="color:#DF2A3F;">简化 maven 配置</font>**；
+ 尽可能**<font style="color:#DF2A3F;">自动配置 spring 容器</font>**和第三方类库完全不需要 xml 配置，没有代码生成；

<h3 id="cvF35">学习的前置条件</h3>
+ spring
+ springmvc
+ idea
+ mybatis
+ redis

<h3 id="ta8Y6">系统要求</h3>
+ JDK 8 ~ JDK 17 版本；
+ SpringFrameWork 5.3.16 版本；
+ Maven 3.5+ 版本；
+ Tomcat 9.0 版本；（内置）
+ Servlet 4.0 版本；

<h2 id="FpVww">搭建 SpringBoot 环境</h2>
> [https://docs.spring.io/spring-boot/tutorial/first-application/index.html#getting-started.first-application.pom](https://docs.spring.io/spring-boot/tutorial/first-application/index.html#getting-started.first-application.pom)
>

<h3 id="HO9dN">创建 springboot 项目</h3>
<h4 id="SWI4d">方式一：使用 Maven 项目 （手动）</h4>
1. 新建 Maven 项目

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1727696658661-1214da39-f966-42c2-a8fa-3e11a53d09c1.png)

2. 配置 pom.xml 文件

> + springboot 版本使用 `2.6.4`；
> + `spring-boot-starter-parent` POM 提供了 <font style="color:#E4495B;">Spring Boot 及其依赖的版本管理</font>；
> + 可以不用手动定义每个依赖的版本，Spring Boot 自动<font style="color:#E4495B;">提供一个兼容性良好的依赖版本</font>集；
>

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>com.slz.springboot</groupId>
  <artifactId>SpringBootLearning</artifactId>
  <version>1.0-SNAPSHOT</version>
  <packaging>pom</packaging>

  <!--  -->
  <parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>2.6.4</version>
  </parent>

  <modules>
    <module>springboot_create_1</module>
  </modules>

  <properties>
    <maven.compiler.source>11</maven.compiler.source>
    <maven.compiler.target>11</maven.compiler.target>
  </properties>
</project>
```

>  项目中引入了 `spring-boot-starter-web`，这将<font style="color:#E4495B;">确保内嵌 Tomcat 服务器正确配置 </font>
>

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>

  <parent>
    <groupId>com.slz.springboot</groupId>
    <artifactId>SpringBootLearning</artifactId>
    <version>1.0-SNAPSHOT</version>
  </parent>

  <groupId>com.slz.springboot</groupId>
  <artifactId>springboot_create_1</artifactId>
  <version>1.0-SNAPSHOT</version>
<!-- 引入自动配置依赖spring-boot-starter-web -->
  <dependencies>
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
  </dependencies>
</project>
```

3. 编写 Controller 类 （非必选）

```java
@RestController
public class IndexController {

    @GetMapping("/index")
    public Object index(){
        return "hello springboot";
    }
}
```

4. 编写启动类，启动类一般放在根包下，便于扫描 Spring 组件

> `<font style="color:#DF2A3F;">@SpringBootApplication</font>` 是一个组合注解，包含了以下三个功能：
>
> 1. `<font style="color:#E4495B;">@SpringBootConfiguration</font>`：作为 Spring 配置类；
> 2. `<font style="color:#E4495B;">@EnableAutoConfiguration</font>`：启用自动配置；
> 3. `<font style="color:#E4495B;">@ComponentScan</font>`：自动扫描项目中的 Spring 组件；
>

```java
@SpringBootApplication
public class AppServer {
    public static void main(String[] args) {
        SpringApplication.run(AppServer.class, args);
    }
}
```

5. 运行启动类

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1727697620127-2c8a8115-7657-4234-9497-764a69fe05a4.png)

> 上述，表明启动成功，默认使用 8080 端口，我们可以访问路径 [http://localhost:8080/index](http://localhost:8080/index)
>

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1727697692568-5b33f5d4-ce0c-4bd6-a73c-89acd0611685.png)

<h4 id="ymyBB">方式二：使用 Spring lnitializr 官网（自动）</h4>
> 官网脚手架：[https://start.spring.io/](https://start.spring.io/)
>

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728365026073-1ad25aef-c43d-4f60-b07a-9a2d45fe2920.png)

1. 在 IDEA 种新建一个模块，选择 `<font style="color:#E4495B;">Spring lnitializr</font>`<font style="color:#E4495B;"> </font>选项并作相应配置；

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1727698154529-e7586e75-02a6-4c2f-862a-658a9c56222b.png)

2. 添加需要的依赖项，这里以 web 为例

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1727698315583-4ed69bad-f28e-4e91-bc96-14ddc899f297.png)

3. 创建项目

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1727698405752-a9ff4f52-7c29-413c-943e-b184f901edc6.png)

4. 在 pom.xml 中修改对应 springboot 版本，以及 JDK 版本

```xml
<parent>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-parent</artifactId>
  <version>2.6.4</version>
  <relativePath/> <!-- lookup parent from repository -->
</parent>
<properties>
  <java.version>11</java.version>
</properties>
```

> 如果父模块已经配置并指定了springboot 版本，子模块可以不用配置
>

5. 运行启动类

> 端口默认 8080
>

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1727698955064-c1bc71e9-d1a0-4952-b9a5-3ce033b2b5db.png)

<h4 id="FI8lZ">方式三：使用 Spring Initlalizr 阿里云（自动）</h4>
> 因为有可能出现官网连接不上的情况
>

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728364832100-e9b1f974-8f87-41fe-a1ec-d078335fe829.png)

1. 更改服务器网址为：[https://start.aliyun.com](https://start.aliyun.com)

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728363825513-c78486a4-dbf7-48d0-8174-10b7cc7967ec.png)

2. 选择依赖项

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728363974205-7acb1d11-b3fd-4c7a-9738-e95b05010d7d.png)

3. 更改合适版本

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728364291216-6132f8d0-d2e1-4dd9-bb95-21fbb62ccc88.png)

4. 与官网创建的区别

<font style="background-color:#FBDE28;">使用 </font>`<font style="color:#DF2A3F;background-color:#FBDE28;">spring-boot-dependencies</font>`<font style="background-color:#FBDE28;">依赖，而不使用父模块 </font>`<font style="color:#DF2A3F;background-color:#FBDE28;">spring-boot-starter-parent</font>`

```xml
<dependencyManagement>
  <dependencies>
    <!--  功能等同于 spring-boot-starter-parent，只是将 spring-boot-starter-parent 的依赖范围设置为 provided -->
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-dependencies</artifactId>
      <version>${spring-boot.version}</version>
      <type>pom</type>
      <scope>import</scope>
    </dependency>
  </dependencies>
</dependencyManagement>
```

<h4 id="Y0q86">方式四：使用在线脚手架</h4>
1. 官网脚手架：[https://start.spring.io/](https://start.spring.io/)
2. 阿里云脚手架：[https://start.aliyun.com](https://start.aliyun.com)

略……

<h3 id="gnrmm">spring-boot-starter-parent</h3>
`spring-boot-starter-parent`是所有 springboot 项目要继承的项目

> `spring-boot-starter-parent`在其中，依赖了一个`spring-boot-dependencies`，在里面规范了使用的各个第三方依赖的版本号，因此模块中导入依赖时，不必写版本号，这样**<font style="color:#DF2A3F;">避免了版本冲突</font>**。
>
> ![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728365886458-712fd19d-70ed-45ef-98a6-a01b8fcf3e65.png)
>

<h3 id="UjDw0">springboot 启动类的位置</h3>
官网规范说明文档：[https://docs.spring.io/spring-boot/reference/using/structuring-your-code.html#using.structuring-your-code.locating-the-main-class](https://docs.spring.io/spring-boot/reference/using/structuring-your-code.html#using.structuring-your-code.locating-the-main-class)

启动类一般放在**<font style="background-color:#FBDE28;">根包</font>**下，便于扫描 Spring 组件

> `<font style="color:#DF2A3F;">@SpringBootApplication</font>` 是一个组合注解，包含了以下三个功能：
>
> 1. `<font style="color:#E4495B;">@SpringBootConfiguration</font>`：作为 Spring 配置类；
> 2. `<font style="color:#E4495B;">@EnableAutoConfiguration</font>`：启用自动配置；
> 3. `<font style="color:#E4495B;">@ComponentScan</font>`：自动扫描项目中的 Spring 组件；
>

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728366658619-67aa552e-09f8-4f73-9871-e1c55b3a8b69.png)

<h3 id="dhsRc">springboot 内置服务器（三种）</h3>
> `spring-boot-starter-web`默认引入的依赖是 `spring-boot-starter-tomcat`，是以 `org.apache.tomcat.embed`嵌入式的 servlet 容器形式导入。自己指定的话需要：
>
> 1. 取消默认依赖 `<font style="color:#DF2A3F;"></exclusion></font>`
> 2. 引入指定依赖 `<font style="color:#DF2A3F;"><dependency></font>`
>

1. 默认内置的服务器时 **<font style="background-color:#FBDE28;">tomcat</font>**；
2. **<font style="background-color:#FBDE28;">jetty</font>**：更轻量级的容器；
+ 更改默认的内置服务器：<font style="color:#DF2A3F;">自己指定的依赖需要写版本号</font>

```xml
<dependencies>
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
    <!-- 取消 tomcat 服务器 -->
    <exclusions>
      <exclusion>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-tomcat</artifactId>
      </exclusion>
    </exclusions>
  </dependency>
  <!-- 加入jetty服务器 -->
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-jetty</artifactId>
    <version>2.6.4</version>
  </dependency>
</dependencies>
```

+ 再次启动：

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728367883911-deeea906-8852-4f39-909e-63d4e319142f.png)

3. **<font style="background-color:#FBDE28;">undertow</font>**：不常用
+ 引入依赖

```xml
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
            <!-- 取消 tomcat 服务器 -->
            <exclusions>
                <exclusion>
                    <groupId>org.springframework.boot</groupId>
                    <artifactId>spring-boot-starter-tomcat</artifactId>
                </exclusion>
            </exclusions>
        </dependency>
        <!-- 加入jetty服务器 -->
<!--        <dependency>-->
<!--            <groupId>org.springframework.boot</groupId>-->
<!--            <artifactId>spring-boot-starter-jetty</artifactId>-->
<!--            <version>2.6.4</version>-->
<!--        </dependency>-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-undertow</artifactId>
            <version>2.6.4</version>
        </dependency>
    </dependencies>
```

+ 再次启动

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728368071810-0c1e2f58-45d0-40d7-bbcb-7fe9f2739f9d.png)

<h3 id="hqRPM">springboot 配置文件（三种）</h3>
<h4 id="rlZpL">配置文件使用</h4>
配置文件如果不能被 IDEA 识别，可以手动添加：

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728368780031-3f2d95e5-2248-459e-9e58-f4a5f8a5ca31.png)

1. **<font style="background-color:#FBDE28;">properties</font>**：键值对形式，相同前缀不能合并（<font style="color:#DF2A3F;">默认自动创建</font>）

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728368943901-3d9020d0-e7d5-457b-b8b4-db5a839ea8b3.png)

2. **<font style="background-color:#FBDE28;">yml</font>**：层级关系形式，相同前缀可以合并，使用YAML语法，支持更复杂的结构化数据（<font style="color:#DF2A3F;">主要使用</font>）

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728368951552-c6827876-5087-44b8-9084-af406541f128.png)

3. **<font style="background-color:#FBDE28;">yaml</font>**：与 yml 相同

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728368954700-40a02454-5d86-45dd-8578-da1580736b06.png)

<h4 id="AjS1p">配置文件优先级 ⭐</h4>
> 在Spring Boot中，**<font style="color:#DF2A3F;">配置文件的优先级是一个重要的概念</font>**，因为它<font style="background-color:#FBDE28;">决定了哪些配置会被最终加载和使用</font>。以下是关于properties、yml（或yaml）文件优先级的一些关键点：
>

这三种配置文件优先级顺序：`**<font style="color:#DF2A3F;">properties > yml > yaml</font>**`

扩展：

> Spring Boot 支持多种配置文件，并按照一定的优先级顺序加载它们。以下是常见的几种配置文件及其优先级顺序：
>
> 1. 命令行参数具有最高优先级。
> 2. `application.properties` 和 `application.yml` 通常位于src/main/resources目录下。
> 3. `bootstrap.properties` 和 `bootstrap.yml` 用于引导阶段的配置。
> 4. 环境变量和JVM系统属性也有较高的优先级。
> 5. 其他配置文件根据其位置有不同的优先级。
>

<h3 id="gLiW9">以 jar 包方式运行 springboot</h3>
> 官方文档：[https://docs.spring.io/spring-boot/tutorial/first-application/index.html#getting-started.first-application.executable-jar.maven](https://docs.spring.io/spring-boot/tutorial/first-application/index.html#getting-started.first-application.executable-jar.maven)
>

1. 需要在 pom 文件中引入插件：

```xml
<build>
	<plugins>
		<plugin>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-maven-plugin</artifactId>
		</plugin>
	</plugins>
</build>
```

2. 配置以 jar 方式打包：

```xml
<groupId>com.slz.springboot</groupId>
<artifactId>springboot_create_2</artifactId>
<version>0.0.1-SNAPSHOT</version>
<name>springboot_create_2</name>
<packaging>jar</packaging>
```

3. 运行 `mvn package`，生成的 jar 包，在 target 目录下

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728370447674-8c658789-e63b-495d-b181-96211612000f.png)

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728370478541-39ba336d-984f-4f95-bedc-66e472cf2d4e.png)

4. 运行 jar 包

> java -jar .\springboot_create_2\target\springboot_create_2-0.0.1-SNAPSHOT.jar
>

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728370705166-2590dd45-7048-45a6-9e5a-ddab62e6a77d.png)

成功启动！

<h2 id="DhK3y">SpringBoot 整合 Swagger3</h2>
![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728385522387-e9ada6be-5311-4162-a057-b96c91f45115.png)

> 官网：[https://swagger.io/](https://swagger.io/)
>

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728371037753-c492719d-8b3c-4419-adca-63d140b537c1.png)

**API 开发**：前后端分离开发时代的到来，后端程序员，<font style="color:#DF2A3F;">开发接口</font>并实时更新接口的数据操作，前端需要取后端接口提供的数据。

**Swagger 3：**也称为OpenAPI 3，是一个广泛使用的 API 文档和设计工具，用于描述 <font style="color:#DF2A3F;">RESTful API</font>。它可以帮助开发者<font style="color:#DF2A3F;">生成 API 文档</font>，并提供交互式UI来测试API。在Spring Boot项目中，使用Swagger 3非常常见

<h3 id="wH3OQ">整合 swagger3 步骤</h3>
1. **<font style="background-color:#FBDE28;">步骤1</font>**：pom 中引入依赖

```xml
<!--  springboot 引入 swagger3 依赖-->
<dependency>
  <groupId>io.springfox</groupId>
  <artifactId>springfox-boot-starter</artifactId>
  <version>3.0.0</version>
</dependency>
```

2. **<font style="background-color:#FBDE28;">步骤2</font>**：编写 swagger 的一个配置类

```java
// @Configuration : 配置类，相当于 applicationContext.xml文件中 <beans> 标签
@Configuration
public class Swagger3Config {
    @Bean // Bean 注解，将返回值放入 Spring 容器，相当于 applicationContext.xml文件中 <bean> 标签
    public Docket apiConfig() { // 方法名可以任意，返回值类型必须是 Docket
        // Swagger3 使用 OAS_30， Swagger2 使用 SWAGGER_2
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .select()
                // 设置通过什么方式定位到需要生成文档的接口
                // 定位了方法上的 @ApiOperation 注解
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any()) // 设置哪些接口暴露给Swagger展示，any() 表示所有, regex() 表示正则匹配
                .build();
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("swagger3")
                .description("swagger3接口文档")
                .contact(new Contact("sunlinzhao", "https://github.com/sunlinzhao", "2436949535@qq.com"))
                .version("1.0")
                .build();
    }
}
```

3. **<font style="background-color:#FBDE28;">步骤3</font>**：配置 application.yml，解决路径匹配问题

```yaml
spring:
  mvc:
    pathmatch:
      # 默认策略：PathPatternParser，更严格且功能强大。
      # 传统策略：AntPathMatcher，更宽松且易于理解。
      # 1. 迁移旧项目：如果你正在从旧版本的Spring Boot迁移到新版本，可能需要使用AntPathMatcher以保持一致的行为。
      # 2. 解决特定问题：如果你遇到某些路径匹配问题，可以尝试使用AntPathMatcher来简化匹配逻辑。
      matching-strategy: ant_path_matcher
```

4. **<font style="background-color:#FBDE28;">步骤4</font>**：controller 添加注解

> + `<font style="color:#DF2A3F;">@Api(tags = "学生信息管理")</font>` // 用在类上, 表示对类的说明, tags 说明该类的作用;
> + `<font style="color:#DF2A3F;">@ApiOperation("查询学生列表")</font>` // 用在方法上，说明方法用途和作用
>

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728376161476-c65a3aef-e657-41f8-8620-2bf7abdf6a00.png)

5. **<font style="background-color:#FBDE28;">步骤5</font>**：启动类 添加注解，`<font style="color:#DF2A3F;">@EnableOpenApi</font>`，开启 swagger3

```java
@SpringBootApplication
@EnableOpenApi // 开启 swagger3
//@EnableSwagger2 // 启用 swagger2
public class SpringbootSwagger3Application {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootSwagger3Application.class, args);
    }
}
```

6. **<font style="background-color:#FBDE28;">步骤6</font>**：启动项目，访问 [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728376721537-c9633d3a-0b2f-46ed-b83e-0f3986ed46bd.png)

7. **<font style="background-color:#FBDE28;">步骤7</font>**：测试接口，**<font style="color:#DF2A3F;">通过 swagger3 可以很方便地进行接口调试</font>**

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728376847200-74cef292-3095-4bb3-811b-aafc67edf8fa.png)

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728376873920-f486985c-7929-4019-b77a-37a580a5d42b.png)

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728376924476-5bacd047-6ef3-4e08-a465-b3b2184a81d6.png)

<h3 id="psYEK">对参数的描述</h3>
<h4 id="DXwiI">方式一：@ApiImplicitParams</h4>
用在方法上：

```java
    @ApiImplicitParams(
            @ApiImplicitParam(
                    name = "id",
                    value = "学生id",
                    required = true,
                    dataType = "Integer",
                    dataTypeClass = Integer.class,
                    paramType = "path" //  paramType 表示参数类型, 包括：path, query, body, header, form
            )
    )
```

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728377724093-d8d1e41c-3dd4-4136-bb6b-4b67f07f7920.png)

<h4 id="EM18R">方式二：@ApiParam</h4>
```java
@GetMapping("/selectByName")
@ApiOperation("根据姓名查询学生信息")
public Object selectByName(@ApiParam(name = "name", value = "学生姓名", required = true) String name) {
    return new Student(null, name, "男", 18);
}
```

<h4 id="KR8Xt">方式三：@ApiModel</h4>
> 对于参数是复杂对象时
>

```java
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "学生信息", description = "学生信息")
public class Student {
    @ApiModelProperty(value = "学生id", required = true, example = "12")
    private Integer id;
    @ApiModelProperty(value = "学生姓名", required = true, example = "张三")
    private String name;
    @ApiModelProperty(value = "学生性别", required = true, example = "男")
    private String gender;
    @ApiModelProperty(value = "学生年龄", required = true, example = "18")
    private Integer age;
}
```

```java
@PostMapping("/add")
@ApiOperation("添加学生信息")
public Object add(@RequestBody Student student) {
    return student;
}
```

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728383510217-29f30131-92a4-495f-9aec-b6d058306b0e.png)

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728383562802-ffb08461-6c07-4283-9546-7ca6ce64535e.png)

<h4 id="UsbMd">RestFul 风格 API</h4>
![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728383759453-fdbb0fe9-74ac-426b-a92d-297a331fa12e.png)

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728383794171-c85e1875-5d63-4dba-8d51-fa4b5e500017.png)

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728383990158-aed08146-85ef-4fbd-a382-62374ec67836.png)

<h3 id="fj4yj">不同类型参数区别 ⭐</h3>
> paramType 属性可以取以下几种值：
>
> 1. **<font style="background-color:#FBDE28;">path</font>**：路径参数，通过 `<font style="color:#DF2A3F;">@PathVariable</font>` 获取。
> 2. **<font style="background-color:#FBDE28;">query</font>**：查询参数，通过 `<font style="color:#DF2A3F;">@RequestParam</font>` 获取。
> 3. **<font style="background-color:#FBDE28;">body</font>**：请求体参数，通过 `<font style="color:#DF2A3F;">@RequestBody</font>` 获取。
> 4. **<font style="background-color:#FBDE28;">header</font>**：头部参数，通过 `<font style="color:#DF2A3F;">@RequestHeader</font>` 获取。
> 5. **<font style="background-color:#FBDE28;">form</font>**：表单参数，通过 `<font style="color:#DF2A3F;">@RequestParam</font>` 获取。
>

+ ✅ 区别1：
    - **路径参数**：使用 {} 包裹参数名，例如 /users/{userId}。
        * 用于标识具体的资源或资源集合，通常用于获取或更新特定资源；
    - **查询参数**：使用 ? 开始，多个参数之间用 & 分隔，例如 /users?name=John&age=30。
        * 用于传递额外的信息或过滤条件，通常用于筛选或分页查询数据；
+ ✅ 区别2：
    - **请求体参数**：主要用于传递复杂的数据结构，如对象或数组。
        * 使用 JSON 或 XML 格式进行编码;
            + 例如：Content-Type: application/json
            + 例如：Content-Type: application/xml
    - **表单参数**：主要用于提交表单或简单的键值对数据。
        * 使用 application/x-www-form-urlencoded 编码
            + 例如：Content-Type: application/x-www-form-urlencoded

<h2 id="B0SVw">SpringBoot 设置热启动（自动重启）</h2>
<h3 id="GG2d4">springboot 的启动 banner 修改 👁️‍🗨️</h3>
> <font style="color:rgb(42, 47, 69);">banner 网页上的横幅广告/标语，默认为：</font>
>
> ![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728384963359-29a23807-eab4-4ce9-93d6-553b4da89b12.png)
>

<font style="background-color:#FBDE28;">通过修改 application.yml 配置来修改 banner</font>

1. 替换为文字

在线文字 banner 生成：[https://www.bootschool.net/ascii](https://www.bootschool.net/ascii)

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728385475394-6890140f-faa0-40e3-913f-bb552228ae07.png)

创建 banner.txt

```plain
#     #          #         #                      #   #   #        #        #                     
    ##   ###         ##  ########                     ##  ##  ##       ###########          ##        
    ##   ##          ##       ##                      ##  ##  ##       ##  ##  ##          ####       
   ##   ##    #     ##       ##                       ##  ##  ##       ##########          ####       
   #    ########    ## #    #                         ##  ##  ## #     ##  ##  ##          ####       
  ###  ## #  ##   #######   ##                      ###############    ##########          ####       
  ### #   ## #      ## ##   ## #                      ##  ##  ##       #   ##  #           ####       
 # ##   # ##        ## ##########                     ##  ##  ##         ##  ##             ##        
   ##   #####      ## ##    ##        ##              ##  ##  ##        ##    ###           ##        
   ##  ##### #     ## ##    ##       ####             ##  ##  ##       ####   # ####        ##        
   ##  ## ## ##     ###     ##       ####             ##  ######     ##  ##   ## ##                   
   ## ##  ##  ##     ###    ##        ##              ##  #   #          ##   ##            ##        
   ###    ##  #     ## ##   ##         #              ##                 ##   ##           ####       
   ##     ##       ##  ## # ##        #               ##        #       ##    ##            ##        
   ##   ####       #   #   ###       #               #############      #     ##                      
   #      #       #         #                         #                #      #
```

配置 <font style="background-color:#FBDE28;">application.yml </font>

```yaml
spring:
  banner:
    location: classpath:banner.txt
```

运行结果：

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728385648256-c041ef06-512a-4185-9e36-58c855e3713d.png)

2. 替换为图片

```yaml
spring:
  banner:
    #    location: classpath:banner.txt
    image:
      location: classpath:banner.png
```

banner.png

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728385956950-bb6b1183-ba8e-4e8b-bb17-f861b7dcf110.png)

运行结果：

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728385990174-2d0a956f-fea0-42fb-bd76-1b9b083518cb.png)

<h3 id="KOizA">springboot 设置自动重启 👁️‍🗨️</h3>
<h4 id="MI2uG">自动重启设置</h4>
1. **<font style="background-color:#FBDE28;">步骤1</font>**：在 pom 中引入相关依赖，springboot 热部署工具 <font style="color:#DF2A3F;">devtools</font>

```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-devtools</artifactId>
</dependency>
```

2. **<font style="background-color:#FBDE28;">步骤2</font>**：IDEA 设置中勾选

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728387869726-f64c1b81-db2c-4c9f-9fba-b5aa58d8de7a.png)

3. <font style="background-color:#FBDE28;">步骤3</font>：快捷键 `crtl + shift + alt + /`，弹出菜单，选择注册表

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728386592997-2c78c95d-925b-4cd3-9b89-d785a810d0a6.png)

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728387051626-6f9378bf-018f-436a-a095-6bdf309c40d5.png)

> <font style="color:#DF2A3F;background-color:#FBDE28;">注意</font><font style="color:#DF2A3F;">：有些高版本的注册表中找不到 </font>`<font style="color:#DF2A3F;">compiler</font><font style="color:#DF2A3F;">.automake.allow.when.app.running</font>`<font style="color:#DF2A3F;">，需要到</font><font style="color:#DF2A3F;">高级设置里开启</font>
>

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728388111370-18a49d31-80ad-4df5-a1af-82d23041c4da.png)

4. **<font style="background-color:#FBDE28;">步骤4</font>**：重启服务器

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728387214860-0a0e1ac7-9434-41f6-b1e3-4fa28dc1fe62.png)

说明设置成功，测试一下：修改 java 程序，切换到网页，再返回 idea，发现已重启

<h4 id="T3WXW">自动重启原理</h4>
springboot 提供的重启技术，通过两个类的**<font style="background-color:#FBDE28;">加载器</font>**（ClassLoader）来完成：

+  不会更改的类被加载到 `<font style="color:#DF2A3F;">BaseClassLoader</font>`<font style="color:#DF2A3F;"> </font>中；
    - 不会更改的类包括：第三方 jar 包
+ 会更改的类被加载到 `<font style="color:#DF2A3F;">RestartClassLoader</font>`<font style="color:#DF2A3F;"> </font>中，项目启动时被创建；

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728388787708-0a893eac-1698-43b3-a86b-56469f0f1bc5.png)

> 因此，**<font style="color:#DF2A3F;background-color:#FBDE28;">自动重启比较快</font>**
>

<h4 id="sHTry">开启/关闭自动重启</h4>
修改 application.yml 配置文件：

```yaml
spring:
  devtools: # 默认为 true, 作用：设置自动重启, 为 false 时关闭自动重启
    add-properties: true
```

> **<font style="background-color:#FBDE28;">注意</font>**：<font style="color:rgb(77, 77, 77);">线上环境运行时是不可能使用热部署功能的，所以需要强制关闭此功能，通过配置可以关闭此功能。</font>
>

<h4 id="veYLV">排除自动重启的资源</h4>
> 有一些资源，在发生更改时，不一定需要触发自动重启，比如 thymeleaf 模板。<font style="color:rgb(77, 77, 77);">配置中默认不参与热部署的目录信息如下：</font>
>
> + <font style="color:rgba(0, 0, 0, 0.75);">/META-INF/maven</font>
> + <font style="color:rgba(0, 0, 0, 0.75);">/META-INF/resources</font>
> + <font style="color:rgba(0, 0, 0, 0.75);">/resources</font>
> + <font style="color:rgba(0, 0, 0, 0.75);">/static</font>
> + <font style="color:rgba(0, 0, 0, 0.75);">/public</font>
> + <font style="color:rgba(0, 0, 0, 0.75);">/templates</font>
>

<font style="color:rgba(0, 0, 0, 0.75);">修改 application.yml 配置文件：</font>

```yaml
spring:
  devtools: # 默认为 true, 作用：设置自动重启, 为 false 时关闭自动重启
    add-properties: true
    restart:
      exclude: static/**, templates/**, public/** # 排除重启的文件
```

<h2 id="TuRB0">SpringBoot 配置文件</h2>
<h3 id="KRhJR">配置文件加载顺序 ⭐</h3>
springboo t启动时会自动査找和加载 `application.properties` 和 `application.yml` 或者 `application.yaml`，按照以下顺序查找，一旦找到符合要求的就不继续往下找了：

```plain
-file:./config/
-file:./
-classpath:/config/
-classpath:./
```

> 所以，**<font style="color:#DF2A3F;background-color:#FBDE28;">优先级</font>**：
>
> 1. 按照所在位置，根据查找排序；
> 2. 位置相同的情况下，`properties` > `yml` > `yaml`
>

<h3 id="GcbYS">指定配置文件名字</h3>
1. 方式一：通过运行时传参指定 `--spring.config.name=my`

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728391456197-5436035b-a5fc-465d-b20d-ac6ce90a5404.png)

2. 方式二：jar 包运行时，通过命令行传参指定 

```bash
java -jar .\springboot_create_2\target\springboot_create_2-0.0.1-SNAPSHOT.jar --spring.config.name=my

```

<h3 id="BTSus">yaml 文件详解</h3>
<h4 id="k2GJc">yaml 语法格式</h4>
1. yaml <font style="color:#DF2A3F;">以数据为中心</font>，比 properties 和 xml 更适合做配置文件：
+ 和 properties 文件相比，更简洁；`<font style="color:#8A8F8D;">bean.id="" /n bean.name=""</font>`
+ 和 xml 文件相比，少了结构化代码，数据更直接；`<font style="color:#8A8F8D;"><bean id="" name=""></bean></font>`
2. yaml 以空格缩进程度来控制<font style="color:#DF2A3F;">层级关系</font>；
3. yaml <font style="color:#DF2A3F;">大小写敏感</font>；
4. yaml 支持<u><font style="background-color:#FBDE28;">字面值</font></u>、<u><font style="background-color:#FBDE28;">对象</font></u>、<u><font style="background-color:#FBDE28;">数组</font></u>数据结构、也支持<u><font style="background-color:#FBDE28;">复合</font></u>结构；
5. 数据和前缀属性之间要<font style="color:#DF2A3F;">有空格</font>；
6. 字符串可以不加引号，如果需要处理<font style="color:#DF2A3F;">特殊字符就需要加双引号</font>，如  \ "" 
7. 使用集合、数组的时候，需要使用 <font style="color:#DF2A3F;">"-"</font>，后面<font style="color:#DF2A3F;">有空格</font>；

```yaml
spring:
  devtools:
    add-properties: true
    restart:
      exclude: static/**, templates/**, public/**
  banner:
        location: classpath:banner.txt
```

<h4 id="qchUp">yaml 基本数据类型</h4>
```yaml
sysUser: 张三 # String
age: 22 # int
money: 3145.12 # double
birthday: 2019/01/01 # Date, 默认格式：yyyy/MM/dd，其它格式则不能转换
```

```java
@RestController
@RequestMapping("/test")
public class TestController {
    @Value("${sysUser}")
    private String sysUser;
    @Value("${age}")
    private Integer age;
    @Value("${money}")
    private Double money;
    @Value("${birthday}")
    private Date birthday;
    @GetMapping
    public String show(){
        return sysUser + " : " + age + " : " + money + " : " + birthday;
    }
}
```

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728450052279-31138c94-2f48-49c3-ace3-49fa098bfa5c.png)

<h4 id="uXKcB">yaml 将数据封装到实体对象</h4>
```yaml
com:
  slz:
    springboot:
      model:
        users:
          name: 张三
          gender: 男
          age: 22
          money: 3145.12
          birthday: 2019/01/01
```

```java
@RestController
@RequestMapping("/users")
public class UsersController {
    @Resource // 属性注入
    private Users users;
    @GetMapping
    public Object show() {
        return users;
    }
}
```

1. 方式一：使用 `<font style="color:#DF2A3F;">@Value</font>` 对对象属性，进行**<font style="color:#DF2A3F;">属性注入</font>**

```java
@Data
@Component // 作为 spring 组件，能够被扫描到
public class Users {
    @Value("${com.slz.springboot.model.users.name}")
    private String name;
    @Value("${com.slz.springboot.model.users.gender}")
    private String gender;
    @Value("${com.slz.springboot.model.users.age}")
    private Integer age;
    @Value("${com.slz.springboot.model.users.money}")
    private Double money;
    @Value("${com.slz.springboot.model.users.birthday}")
    private LocalDate birthday;
}
```

2. 方式二：使用 `<font style="color:#DF2A3F;">@ConfigurationProperties</font>`对对象属性，进行**<font style="color:#DF2A3F;">属性绑定</font>**

> `@ConfigurationProperties` 是 Spring Boot 提供的一个非常有用的注解，用于将配置文件（如 application.properties 或 application.yml）中的属性值**<font style="color:#DF2A3F;">自动绑定</font>**到 Java 对象中。这使得配置管理变得更加简单和直观。
>
> **<font style="color:#DF2A3F;">注意：属性名与配置文件应相同</font>**
>

**<font style="background-color:#FBDE28;">需要在 pom 中引入依赖</font>**

```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-configuration-processor</artifactId>
  <optional>true</optional>
</dependency>
```

**<font style="background-color:#FBDE28;">添加注解</font>**

```java
@Data
@Component // 作为 spring 组件，能够被扫描到
@ConfigurationProperties(prefix = "com.slz.springboot.model.users")
public class Users {
    private String name;
    private String gender;
    private Integer age;
    private Double money;
    private LocalDate birthday;
}
```

**<font style="background-color:#FBDE28;">结果</font>**

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728454180297-ef7a72f2-ed7a-42c1-9916-b037ce31b375.png)

<h5 id="oLz4e"><font style="color:#DF2A3F;">@ConfigurationProperties 注解</font></h5>
在 springboot 自动配置中就用到了该注解，通过配置文件	前缀，获取配置属性值

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728458317519-f0c56bb0-72be-4365-9528-e5a4b37419d4.png)

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728458418893-7430c6c6-77ef-47e7-8694-0be4ef24fb44.png)

<h4 id="Ip7U2">yaml 将数据封装到 Environment 对象</h4>
> <font style="color:#DF2A3F;">Environment</font> 接口在 Spring 框架中主要用于<u><font style="color:#DF2A3F;">获取和管理应用程序的环境信息</font></u>，包括配置属性、活动配置文件以及系统属性和环境变量。通过 Environment 接口，您可以轻松地访问和管理这些信息，从而实现更加灵活和动态的配置管理。
>

Spring 将**<u>不同来源的属性配置</u>**数据全部封装在 <font style="color:#DF2A3F;">Environment</font> 接口中，并通过<font style="color:#DF2A3F;">getProperties</font> 方法以**<u>字符串</u>**形式返回数据

```yaml
sysUser: 张三 # String
age: 22 # int
money: 3145.12 # double
birthday: 2019/01/01 # Date, 默认格式：yyyy/MM/dd，其它格式则不能转换

# 对象
com:
  slz:
    springboot:
      model:
        users:
          name: 张三
          gender: 男
          age: 22
          money: 3145.12
          birthday: 2019/01/01
```

```java
@RestController
@RequestMapping("/env")
public class EnvController {
    @Resource
    private Environment env;
    @GetMapping
    public String show() {
        return env.getProperty("sysUser") + "\n"
        + env.getProperty("age") + "\n"
        + env.getProperty("money") + "\n"
        + env.getProperty("birthday") + "\n"
        + env.getProperty("com.slz.springboot.model.users.name") + "\n"
        + env.getProperty("com.slz.springboot.model.users.gender");
    }
}
```

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728455634344-7bea163e-1a72-4e2e-9370-90d3cdc0c31d.png)

<h4 id="wXnje">yaml 集合数据类型</h4>
<h5 id="vVjGt">基本数据类型集合</h5>
```yaml
# collect
collect:
  # list
  list1:
    - 张三
    - 22
    - 3145.12
    - 2019/01/01
  list2: [张三, 22, 3145.12, 2019/01/01]
  # set
  set1:
    - A
    - B
    - C
    - A
  set2: [A, B, C, A]
  # map
  map1:
    k1: v1
    k2: v2
    k3: v3
  map2: {k1: v1, k2: v2, k3: v3}
```

```java
@RestController
@RequestMapping("/collect")
public class CollectController {
    @Resource
    private Collect collect;
    @GetMapping
    public Object show() {
        return collect;
    }
}
```

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728456954484-a16f9389-7b93-4646-bcf4-17411df05b07.png)

<h5 id="MMddw">对象集合</h5>
```java
@Data
@Component
public class Stu {
    private String name;
    private Integer age;
}
```

```java
@Data
@Component
@ConfigurationProperties(prefix = "oc")
public class Oc {
    private List<Stu> stus1;
    private List<Stu> stus2;
}
```

```yaml
oc:
  # obj
  stus1:
    - name: 张三
      age: 22
    - name: 李四
      age: 23
  stus2:
    - { "name": "张三", "age": 22 }
    - { "name": "李四", "age": 23 }
```

```java
@RestController
@RequestMapping("/collect")
public class CollectController {
    @Resource private Oc oc;
    @GetMapping("/oc")
    public Object showOc() {
        return oc;
    }
}
```

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728457645524-73899dc2-c08b-4fce-8017-fe617baa0460.png)

<h4 id="QJBsO">yaml 松弛绑定</h4>
springboot 使用一些<font style="color:#DF2A3F;background-color:#FBDE28;">宽松的规则</font>将 Environment 属性绑定到标注了注解 `<font style="color:#DF2A3F;">@ConfigurationProperties</font>` 的 bean，因此，Environment 属性名和 bean 属性名称之间<font style="color:#DF2A3F;background-color:#FBDE28;">不需要完全匹配</font>，例：

+ context-path 绑定到contextPath；
+ PORT 绑定到 port；

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728459268063-b47872e9-8d00-4481-b768-0ba72c550e4e.png)

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728459285740-3032e50b-3286-4d7c-bf01-b8130b7f0862.png)

> user-name / userName / user_name / USER_NAME 都能绑定到 userName
>

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728459619694-b0454de5-87d1-4cfa-9039-b18fe2d9c32d.png)

<h4 id="gNvEl">yaml 文件使用 el 配置 ⭐</h4>
<h5 id="dBJFQ">引用其它属性值</h5>
```yaml
server:
  port: 8080

users:
  customer:
    url: localhost:${server.port}
```

通过 `<font style="color:#DF2A3F;">${server.port}</font>`方式，可以引用其它属性值

<h5 id="LH3n3">引用随机值</h5>
```yaml
teacher:
  id: ${random.uuid}
  age: ${random.int(30,50)}
  money: ${random.double(100,200)}
```

可以调用 <font style="color:#DF2A3F;">random</font> 函数生成随机值（random调用的是java程序）

<h3 id="O3R0o">spring 多环境配置 👁️‍🗨️</h3>
spring profiles 允许用户根据配置文件（dev / test / prod）来注册 bean。

> 因此，当应用程序在开发环境中运行时，只有某些bean可以加载，而在生产环境中，某些其他 bean 可以加载。
>

+ **命名规范**：`**<font style="color:#DF2A3F;">application-{profiles}.yml</font>**`

> application-dev.yml / application-test.yml / application-prod.yml
>

+ **案例**：在开发环境中`<font style="color:#DF2A3F;">application-dev.yml</font>`，使用 8080 端口，在生产环境中`<font style="color:#DF2A3F;">application-prod.yml</font>`，使用 8081 端口；

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728460459226-a7cdc51a-6021-4586-9336-ca8efbc528b1.png)

```yaml
# 开发环境
server:
  port: 8080
```

```yaml
# 生产环境
server:
  port: 8081
```

<h4 id="McDvM">方式一：**通过主配置文件指定**</h4>
在**<font style="color:#DF2A3F;">主配置文件</font>**`**<font style="color:#DF2A3F;">application.yml</font>**`**<font style="color:#DF2A3F;">中之指定</font>**激活哪个环境的配置文件

```yaml
spring:
  profiles:
    active: prod # 激活生产环境，运行在端口 8081
```

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728460642815-9d19f93b-68f9-44a6-be34-ca91f373dcc5.png)

<h4 id="Rv0f7">方式二：通过启动参数指定</h4>
**<font style="color:#DF2A3F;background-color:#FBDE28;">在启动时通过参数指定，优先级大于 yaml 配置文件指定</font>**

通过启动参数 `<font style="color:#DF2A3F;">-Dspring.profiles.active=dev</font>`

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728461737543-c33c3bea-3a16-4ecc-bbf3-a5b9bc31e3c3.png)

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728461815464-96a819cb-be3f-4551-9386-7e189b80d924.png)

<h4 id="vL7Dp">方式三：jar 包运行时命令行参数</h4>
`<font style="color:#DF2A3F;">java -jar 包名.jar --spring.profiles.active=dev</font>`

<h4 id="Zezy1">@Profile 注解指定加载 Bean 的环境</h4>
`<font style="color:#DF2A3F;">@Profile</font>` 是 Spring 框架中的一个注解，用于根据不同的环境（profiles）来<u><font style="color:#DF2A3F;">选择性地加载特定的 Bean 或配置类</font></u>。这个注解在多环境开发中非常有用，可以让你根据不同环境（如开发环境、测试环境、生产环境）来启用不同的配置。

> + 主要作用
>     - **<font style="background-color:#FBDE28;">选择性地加载 Bean</font>**
>     - 根据当前激活的 profile 来决定是否加载某个 Bean。
> + 动态配置
>     - 在不同的环境中启用不同的配置类或组件，使得配置更加灵活。
>

**案例**：现有一个接口，来实现支付处理，一个实现类，来模拟便用支付主支付，一个实现类来模拟便用微信支付，支付的方式随着运行环境的不同，选用不同的处理方式。

**实现**：

```java
public interface Pay {
    String pay();
}
```

```java
@Component
@Profile("dev") // 在开发环境中加载此实现类
public class AliPay implements Pay{
    @Override
    public String pay() {
        return "支付宝支付";
    }
}
```

```java
@Component
@Profile("prod") // 在生产环境中加载此实现类
public class WcPay implements Pay{
    @Override
    public String pay() {
        return "微信支付";
    }
}
```

```java
@RestController
@RequestMapping("/pay")
public class PayController {
    @Resource
    private Pay pay;

    @GetMapping
    public String show() {
        return pay.pay();
    }
}
```

> 激活 dev，dev 运行在 8080 端口
>

```yaml
spring:
  profiles:
    active: dev
```

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728463064227-4817f087-ab89-419b-9939-106f4df782d1.png)

> 激活 prod，prod 运行在 8081 端口
>

```yaml
spring:
  profiles:
    active: prod
```

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728463108622-a6748449-c851-44f6-ba16-3ca8ddc97633.png)

<h2 id="qupXx">SpringBoot 整合 Junit</h2>
1. **<font style="background-color:#FBDE28;">步骤1</font>**：在 pom 中引入依赖；

```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-test</artifactId>
  <scope>test</scope>
</dependency>
```

2. **<font style="background-color:#FBDE28;">步骤2</font>**：编写 java 程序;

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728472505147-fe87fc90-56e9-4241-8456-947da62d6d71.png)

3. **<font style="background-color:#FBDE28;">步骤3</font>**：编写测试程序，放在 `src/test/java` 路径下；

> + `<font style="color:#DF2A3F;">@SpringBootTest</font>` 注解标注在测试类上；
> + `<font style="color:#DF2A3F;">@Test</font>` 注解标注在测试方法上；
>
> 其中，`@SpringBootTest(classes = SpringbootJunitApplication.class)` 指定启动类。如果不指定，则默认启动类为测试类所在包的根路径在的启动类（<font style="color:#8A8F8D;">此时若启动类不在就会报错</font>）
>

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728472853039-bc1f1508-f541-4d75-b232-7227d047daa1.png)

```java
@SpringBootTest(classes = SpringbootJunitApplication.class)
class SpringbootJunitApplicationTests {
    @Resource
    private UserService userService;
    @Test
    void contextLoads() {
        List<Users> users = userService.selectAll();
        users.forEach(System.out::println);
    }
    @Test
    void test() {
        System.out.println("hello world");
    }
}
```

4. **<font style="background-color:#FBDE28;">步骤4</font>**：运行测试类

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728472902880-f442d628-044b-4107-92f3-46716e4c8dfc.png)

<h2 id="Yzutz">SpringBoot 整合 Mybatis</h2>
<h3 id="cTCTe">准备工作</h3>
1. pom 引入相关依赖

```xml
<dependencies>
  <!-- spring web -->
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
  </dependency>
  <!-- springboot 整合 mybatis -->
  <dependency>
      <groupId>org.mybatis.spring.boot</groupId>
      <artifactId>mybatis-spring-boot-starter</artifactId>
      <version>2.3.2</version>
  </dependency>
  <!-- 热启动工具 -->
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-devtools</artifactId>
    <scope>runtime</scope>
    <optional>true</optional>
  </dependency>
  <!-- 数据库驱动 -->
  <dependency>
      <groupId>mysql</groupId>
      <artifactId>mysql-connector-java</artifactId>
  </dependency>
  </dependency>
  <!--lombok 注解工具 -->
  <dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <optional>true</optional>
  </dependency>
  <!--springboot 整合 junit  -->
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-test</artifactId>
    <scope>test</scope>
  </dependency>
  <!--  springboot 整合 swagger3 API工具-->
  <dependency>
      <groupId>io.springfox</groupId>
      <artifactId>springfox-boot-starter</artifactId>
      <version>3.0.0</version>
  </dependency>
</dependencies>
```

2. 编写 Swagger 配置类

```java
// @Configuration : 配置类，相当于 applicationContext.xml文件中 <beans> 标签
@Configuration
public class Swagger3Config {
    @Bean // Bean 注解，将返回值放入 Spring 容器，相当于 applicationContext.xml文件中 <bean> 标签
    public Docket apiConfig() { // 方法名可以任意，返回值类型必须是 Docket
        // Swagger3 使用 OAS_30， Swagger2 使用 SWAGGER_2
        return new Docket(DocumentationType.OAS_30)
        .apiInfo(apiInfo())
        .select()
        // 设置通过什么方式定位到需要生成文档的接口
        // 定位了方法上的 @ApiOperation 注解
        .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
        .paths(PathSelectors.any()) // 设置哪些接口暴露给Swagger展示，any() 表示所有, regex() 表示正则匹配
        .build();
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
        .title("swagger3")
        .description("swagger3接口文档")
        .contact(new Contact("sunlinzhao", "https://github.com/sunlinzhao", "2436949535@qq.com"))
        .version("1.0")
        .build();
    }
}
```

3. 配置 application.yml 

```yaml
server:
  port: 8080

# 配置数据库连接相关属性
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/test
    username: root
    password: root

# 配置 mvc, swagger3 的匹配策略
  mvc:
    pathmatch:
      matching-strategy: ant_path_matcher
# 配置 devtools
  devtools: # 默认为 true, 作用：设置自动重启, 为 false 时关闭自动重启
    add-properties: false
    restart:
      exclude: static/**, templates/**, public/** # 排除重启的文件
```

4. 编写代码

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728480273007-e38f485e-6deb-4232-8df4-7f61fb3b17d1.png)

> **<font style="background-color:#FBDE28;">注意</font>**： mapper 接口添加 `<font style="color:#DF2A3F;">@Mapper </font>`注解，或者启动类配置 Mapper 扫描基准包 `<font style="color:#DF2A3F;">@MapperScan(basePackages = "com.slz.springboot.mapper")</font>`
>

```java
//@Mapper
@Repository
public interface StudentMapper {
    @Select("select * from student")
    List<Student> selectAll();
}
```

启动类自动扫描 mapper

```java
@SpringBootApplication
@EnableOpenApi
// 扫描 mapper
@MapperScan(basePackages = "com.slz.springboot.mapper")
public class SpringbootMybatisApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootMybatisApplication.class, args);
    }
}
```

<h3 id="PZkOJ">打开 mybatis 控制台日志</h3>
配置 application.yml 文件

```yaml
# 配置 mybatis 控制台日志
mybatis:
  configuration:
    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl
```

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728481946736-1bf67387-614e-4caf-a303-6a1024d5e3d3.png)

<h3 id="hvF4V">整合 mybatis 分页处理 👁️‍🗨️ </h3>
1. pom 引入分页插件依赖 pagehelper

```xml
<!-- 分页插件 pagehelper-->
<dependency>
  <groupId>com.github.pagehelper</groupId>
  <artifactId>pagehelper-spring-boot-starter</artifactId>
  <version>1.4.1</version>
</dependency>
```

2. 使用 pagehelper

```java
@ApiOperation("分页查询")
@GetMapping("/page/{start}/{size}")
public Object page(@PathVariable Integer start, @PathVariable Integer size) {
    // 开启分页查询
    PageHelper.startPage(start, size);
    List<Student> students = studentService.selectAll();
    // 封装分页信息
    PageInfo<Student> pageInfo = new PageInfo<>(students);
    return pageInfo;
}
```

3. 可以在 application.yml 配置 pagehelper，（不配置也可以，有默认值）

```yaml
pagehelper:
  auto-dialect: true # 自动识别数据库类型
```

4. 测试接口

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728537034757-d5983d55-7ef6-4f57-a773-377bd5ab5f93.png)

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728538678737-9b9520af-40ec-4aed-b5c3-13a205658097.png)

```json
{
  "total": 12,
  "list": [
    {
      "id": 7,
      "name": "张xx",
      "gender": "男",
      "age": 7
    },
    {
      "id": 8,
      "name": "张xx",
      "gender": "男",
      "age": 13
    },
    {
      "id": 9,
      "name": "张xx",
      "gender": "男",
      "age": 12
    }
  ],
  "pageNum": 3,
  "pageSize": 3,
  "size": 3,
  "startRow": 7,
  "endRow": 9,
  "pages": 4,
  "prePage": 2,
  "nextPage": 4,
  "isFirstPage": false,
  "isLastPage": false,
  "hasPreviousPage": true,
  "hasNextPage": true,
  "navigatePages": 8,
  "navigatepageNums": [
    1,
    2,
    3,
    4
  ],
  "navigateFirstPage": 1,
  "navigateLastPage": 4
}
```

<h3 id="Fv7Bl">mybatis 配置 mapper.xml 映射文件位置 👁️‍🗨️ </h3>
> 1. 如果使用<font style="color:#DF2A3F;">注解</font>编写 sql 语句，也不需要配置 mapper.xml 位置；
> 2. 如果使用 mapper.xml 编写 sql 语句：
>     1. mapper.xml 与 mapper.java 接口<font style="color:#DF2A3F;">在同一路径下</font>，需要在 pom 中配置xml<font style="background-color:#FBDE28;">打包位置</font>（pom中配置 Resource），保证出现在 target 中；
>
> ![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728539215394-8c54ef80-f3aa-4dd4-ab7f-92be620d1cc0.png)
>
>     2. mapper.xml 与 mapper.java 接口<font style="color:#DF2A3F;">不在同一路径下</font>，需要通过 application.yml 配置 mapper.xml 位置；
>
> ![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728539289260-e8688bfe-b719-4b43-a64f-519647d34122.png)
>

**<font style="background-color:#FBDE28;">application.yml  配置 mapper.xml 位置</font>**：

```yaml
# 配置 mybatis 控制台日志
mybatis:
  configuration:
    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl
  # 配置 mapper 文件位置
  mapper-locations: classpath:mapper/*.xml
```

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728539600697-84c989e3-159a-4d55-968d-ce224acdac93.png)

<h3 id="cfCiv">mybatis 配置实体类位置 👁️‍🗨️ </h3>
> 配置别名
>

```yaml
# 配置 mybatis 控制台日志
mybatis:
  configuration:
    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl
  # 配置 mapper 文件位置
  mapper-locations: classpath:mapper/*.xml
  # 配置实体类包位置
  type-aliases-package: com.slz.springboot.entity
```

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728539855016-8efae04f-1411-46b5-a01f-5d343386192f.png)

<h2 id="wh0w2">Mybatis-Plus ⭐</h2>
<h3 id="BY85v">mybatis-plus 简介</h3>
> 官网：[https://baomidou.com/](https://baomidou.com/)
>
> 官方文档：[https://baomidou.com/introduce/](https://baomidou.com/introduce/)
>

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728540818934-a531ad7f-fba8-4c51-8da5-b736c6c49390.png)

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728540263607-24a32b67-5ecb-44ef-8933-5a351e8456e3.png)

MyBatis-Plus  (简称 MP) 是一个 MyBatis 的增强工具，在 MyBatis 的基础上只做增强不做改变，为**<font style="color:#DF2A3F;">简化开发、提高效率</font>**而生。

+ **<font style="color:rgb(53, 56, 65);">无侵入</font>**<font style="color:rgb(53, 56, 65);">：只做增强不做改变，引入它不会对现有工程产生影响，如丝般顺滑</font>
+ **<font style="color:rgb(53, 56, 65);">损耗小</font>**<font style="color:rgb(53, 56, 65);">：启动即会自动注入基本 CURD，性能基本无损耗，直接面向对象操作</font>
+ **<font style="color:rgb(53, 56, 65);background-color:#FBDE28;">强大的 CRUD 操作</font>**<font style="color:rgb(53, 56, 65);">：内置通用 Mapper、通用 Service，仅仅通过少量配置即可实现单表大部分 CRUD 操作，更有强大的条件构造器，满足各类使用需求</font>
+ **<font style="color:rgb(53, 56, 65);">支持 Lambda 形式调用</font>**<font style="color:rgb(53, 56, 65);">：通过 Lambda 表达式，方便的编写各类查询条件，无需再担心字段写错</font>
+ **<font style="color:rgb(53, 56, 65);">支持主键自动生成</font>**<font style="color:rgb(53, 56, 65);">：支持多达 4 种主键策略（内含分布式唯一 ID 生成器 - Sequence），可自由配置，完美解决主键问题</font>
+ **<font style="color:rgb(53, 56, 65);">支持 ActiveRecord 模式</font>**<font style="color:rgb(53, 56, 65);">：支持 ActiveRecord 形式调用，实体类只需继承 Model 类即可进行强大的 CRUD 操作</font>
+ **<font style="color:rgb(53, 56, 65);">支持自定义全局通用操作</font>**<font style="color:rgb(53, 56, 65);">：支持全局通用方法注入（ Write once, use anywhere ）</font>
+ **<font style="color:rgb(53, 56, 65);background-color:#FBDE28;">内置代码生成器</font>**<font style="color:rgb(53, 56, 65);">：采用代码或者 Maven 插件可快速生成 Mapper 、 Model 、 Service 、 Controller 层代码，支持模板引擎，更有超多自定义配置等您来使用</font>
+ **<font style="color:rgb(53, 56, 65);background-color:#FBDE28;">内置分页插件</font>**<font style="color:rgb(53, 56, 65);">：基于 MyBatis 物理分页，开发者无需关心具体操作，配置好插件之后，写分页等同于普通 List 查询</font>
+ **<font style="color:rgb(53, 56, 65);">分页插件支持多种数据库</font>**<font style="color:rgb(53, 56, 65);">：支持 MySQL、MariaDB、Oracle、DB2、H2、HSQL、SQLite、Postgre、SQLServer 等多种数据库</font>
+ **<font style="color:rgb(53, 56, 65);">内置性能分析插件</font>**<font style="color:rgb(53, 56, 65);">：可输出 SQL 语句以及其执行时间，建议开发测试时启用该功能，能快速揪出慢查询</font>
+ **<font style="color:rgb(53, 56, 65);">内置全局拦截插件</font>**<font style="color:rgb(53, 56, 65);">：提供全表 delete 、 update 操作智能分析阻断，也可自定义拦截规则，预防误操作</font>

![](https://cdn.nlark.com/yuque/0/2024/jpeg/42892034/1728541863359-14191920-bfb3-4769-ae18-9991b49397f5.jpeg)



<h3 id="hOhcR">单独使用 mybatis</h3>
1. **<font style="background-color:#FBDE28;">步骤1</font>**：创建一个 Maven 项目

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728545779084-9549b647-e32e-4c3f-9e43-f60c579aec6e.png)

2. pom 引入依赖，并配置资源文件打包位置

```xml
<dependencies>
  <dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>3.8.1</version>
    <scope>test</scope>
  </dependency>
  <dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.22</version>
  </dependency>
  <dependency>
    <groupId>org.mybatis</groupId>
    <artifactId>mybatis</artifactId>
    <version>3.5.9</version>
  </dependency>
  <dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.28</version>
  </dependency>
</dependencies>
<build>
  <resources>
    <resource>
      <directory>src/main/java</directory>
      <includes>
        <include>**/*.xml</include>
        <include>**/*.properties</include>
      </includes>
    </resource>
    <resource>
      <directory>src/main/resources</directory>
      <includes>
        <include>**/*.xml</include>
        <include>**/*.properties</include>
      </includes>
    </resource>
  </resources>
</build>
```

3. 配置 mybatisConfig.xml 文件

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE configuration PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
"http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
  <properties resource="db.properties"/>
  <typeAliases>
    <package name="com.slz.mybatis_plus.entity"/>
  </typeAliases>
  <environments default="dev">
    <environment id="dev">
      <transactionManager type="JDBC"></transactionManager>
      <dataSource type="POOLED">
        <property name="driver" value="${jdbc.driver}"/>
        <property name="url" value="${jdbc.url}"/>
        <property name="username" value="${jdbc.username}"/>
        <property name="password" value="${jdbc.password}"/>
      </dataSource>
    </environment>
  </environments>
  <mappers>
    <package name="com.slz.mybatis_plus.mapper"/>
  </mappers>
</configuration>
```

4. 测试程序

```java
public class App 
{
    public static void main( String[] args ) throws IOException {
        SqlSession session = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatisConfig.xml")).openSession();
        TeamMapper mapper = session.getMapper(TeamMapper.class);
        List<Team> teams = mapper.selectAll();
        teams.forEach(System.out::println);
        session.close();
    }
}
```

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728545951758-02fd6565-1cc6-47c3-b477-747b8f786c12.png)

<h3 id="q83vt">单独使用 mybatis-plus</h3>
1. pom 引入依赖

```xml
<!-- mybatis-plus 依赖 -->
<dependency>
  <groupId>com.baomidou</groupId>
  <artifactId>mybatis-plus</artifactId>
  <version>3.5.1</version>
</dependency>
<!-- 高版本 mybatis-plus 需要依赖 spring-core-->
<dependency>
  <groupId>org.springframework</groupId>
  <artifactId>spring-core</artifactId>
  <version>5.3.15</version>
</dependency>
</dependencies>
<!-- mybatis-plus 包含了mybatis，所以 mybatis 依赖可以不要  -->
<!--    <dependency>-->
<!--      <groupId>org.mybatis</groupId>-->
<!--      <artifactId>mybatis</artifactId>-->
<!--      <version>3.5.9</version>-->
<!--    </dependency>-->
```

**<font style="background-color:#FBDE28;">mybatis-plus 内置了mybatis，所以 mybatis 依赖可以不要</font>**

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728546806857-49f7149d-6ed5-4981-8c02-f5bb6abeef55.png)

2. XxxMapper 接口继承泛型接口 `**<font style="color:#DF2A3F;">BaseMapper<T></font>**`，无需编写 mapper.xml 文件，即可获得 CRUD 功能

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728547073972-c0e99e25-fa91-4299-8a1f-f354879243c2.png)

```java
public interface TeamMapper extends BaseMapper<Team> {
}
```

3. `SqlSessionFactoryBuilder()` 替换为 `**<font style="color:#DF2A3F;">MybatisSqlSessionFactoryBuilder()</font>**`

```java
public class App 
{
    public static void main( String[] args ) throws IOException {
        //        SqlSession session = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatisConfig.xml")).openSession();
        SqlSession session = new MybatisSqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatisConfig.xml")).openSession();
        TeamMapper mapper = session.getMapper(TeamMapper.class);
        List<Team> teams = mapper.selectList(null);
        teams.forEach(System.out::println);
        session.close();
    }
}
```

4. 测试运行

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728547291821-dff384fc-b2a5-4f65-9026-4fb907b7ecc2.png)

<h3 id="V0CxC">spring 整合 mybatis-plus 👁️‍🗨️</h3>
1. pom 引入依赖，并配置资源文件打包位置

```xml
<dependencies>
    <dependency>
      <groupId>org.projectlombok</groupId>
      <artifactId>lombok</artifactId>
      <version>1.18.22</version>
    </dependency>
    <dependency>
      <groupId>mysql</groupId>
      <artifactId>mysql-connector-java</artifactId>
      <version>8.0.28</version>
    </dependency>
    <dependency>
      <groupId>com.baomidou</groupId>
      <artifactId>mybatis-plus</artifactId>
      <version>3.5.1</version>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-webmvc</artifactId>
      <version>5.3.15</version>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-jdbc</artifactId>
      <version>5.3.15</version>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-test</artifactId>
      <version>5.3.15</version>
    </dependency>
    <dependency>
      <groupId>com.alibaba</groupId>
      <artifactId>druid</artifactId>
      <version>1.2.8</version>
    </dependency>
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>4.13.1</version>
      <scope>test</scope>
    </dependency>
  </dependencies>
  <build>
    <resources>
      <resource>
        <directory>src/main/java</directory>
        <includes>
          <include>**/*.xml</include>
          <include>**/*.properties</include>
        </includes>
      </resource>
      <resource>
        <directory>src/main/resources</directory>
        <includes>
          <include>**/*.xml</include>
          <include>**/*.properties</include>
        </includes>
      </resource>
    </resources>
  </build>
```

2. 配置 applicationContext.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xmlns:context="http://www.springframework.org/schema/context"
  xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/context https://www.springframework.org/schema/context/spring-context.xsd">
  <!--    配置属性文件位置-->
  <context:property-placeholder location="classpath:db.properties"/>
  <!--    配置数据库-->
  <bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource" init-method="init" destroy-method="close">
    <property name="url" value="${jdbc.url}"/>
    <property name="username" value="${jdbc.username}"/>
    <property name="password" value="${jdbc.password}"/>
  </bean>
  <!--    配置sqlSessionFactory -->
  <bean id="sqlSessionFactory" class="com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean">
    <property name="dataSource" ref="dataSource"/>
    <!--        实体类基准包-->
    <property name="typeAliasesPackage" value="com.slz.spring.entity"/>
    <!--        映射文件xml位置-->
    <!--        <property name="mapperLocations" value="classpath:mapper/*.xml"/>-->
  </bean>
  <!--    配置 mapper 扫描-->
  <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
    <property name="basePackage" value="com.slz.spring.mapper"/>
  </bean>
</beans>
```

3. 实体类与 Mapper 接口

```java
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Team {
    private Integer id;
    private String name;
}
```

```java
public interface TeamMapper extends BaseMapper<Team> {
}
```

4. 测试程序

```java
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class AppTest {
    @Resource
    private TeamMapper teamMapper;
    @Test
    public void Test() {
        teamMapper.selectList(null).forEach(System.out::println);
    }
}
```

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728551236267-60d6c478-b3c0-4bd6-9ebc-bbecd1d556b1.png)

<h2 id="M1e31">SpringBoot 整合 Mybatis-Plus ⭐</h2>
<h3 id="zzfzG">简单使用</h3>
> Maven 项目
>

1. pom 导入依赖 

```xml
<dependencies>
  <!--        spring-web -->
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
  </dependency>
  <!--        mysql 数据库驱动-->
  <dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
  </dependency>
  <!--        lombok -->
  <dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <optional>true</optional>
  </dependency>
  <!--        spring-test -->
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-test</artifactId>
    <scope>test</scope>
  </dependency>
  <!--        mybatis-plus -->
  <dependency>
    <groupId>com.baomidou</groupId>
    <artifactId>mybatis-plus-boot-starter</artifactId>
    <version>3.5.1</version>
  </dependency>
</dependencies>
```

2. application.yml 配置数据源

```yaml
spring:
  # 配置数据库连接信息
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/test?serverTimezone=GMT%2B8
    username: root
    password: root
```

3. 编写实体类和Mapper接口

```java
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Team {
    private Integer id;
    private String name;
}
```

```java
public interface TeamMapper extends BaseMapper<Team> {
}
```

4. 编写启动类和测试类

```java
@SpringBootApplication
@MapperScan("com.slz.springboot.mapper")
public class SpringbootMybatisPlusApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootMybatisPlusApplication.class, args);
    }

}
```

```java
@SpringBootTest
class SpringbootMybatisPlusApplicationTests {
    @Resource
    private TeamMapper teamMapper;
    @Test
    void contextLoads() {
        teamMapper.selectList(null).forEach(System.out::println);
    }
}
```

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728563678386-31fe501d-37a4-4d17-8571-df21529ff83a.png)

<h3 id="fUViY">开启 mybatis-plus 控制台日志</h3>
配置 application.yml

```yaml
# 配置 mybatis-plus
mybatis-plus:
  configuration:
    # 配置控制台日志
    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl
```

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728568092167-eb9a6023-f4d1-46c8-8f4a-c25a49cd11a8.png)

<h3 id="Wyz95">实体类相关注解 @TableXxxx</h3>
+ `<font style="color:#DF2A3F;">@Table("team")</font>`：标注在<font style="background-color:#FBDE28;">实体类</font>上，指定实体类映射的数据库表名 team；
+ `<font style="color:#DF2A3F;">@TableId(value="id", type="IdType.AUTO")</font>`：标注在实体类的<font style="background-color:#FBDE28;">属性</font>上，指定主键字段为 id，并且主键生成策略为自增；
+ `<font style="color:#DF2A3F;">@TableField</font>`：标注在实体类的<font style="background-color:#FBDE28;">属性</font>上，有如下用法：
    - 当数据库字段与属性**<u>不一致</u>**时，指定映射的数据库字段名；`<font style="color:#DF2A3F;">@TableField(value="name")</font>`
    - 当数据库字段**<u>不存在</u>**该属性时；`<font style="color:#DF2A3F;">@TableField(exist=false)</font>`
    - **<u>敏感字段</u>**查询时隐藏；`<font style="color:#DF2A3F;">@TableField(select=false)</font>`

<h3 id="n62Xt">BaseMapper 使用 👁️‍🗨️</h3>
<h4 id="Zod6l">插入数据</h4>
```java
int res = teamMapper.insert(new Team(null, "汪汪"));
```

需要设置主键生成策略，否则插入结果不符合预期：

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728567963029-ef107f80-d9d0-4544-80f4-a0e2b65465b1.png)

```java
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("team")
public class Team {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String name;
}
```

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728568145373-952d2c24-7786-4bd9-a738-664abe615f48.png)

<h4 id="s4XR0">删除数据</h4>
<h5 id="KdOpC">物理删除</h5>
+ 按 Id 删除 `<font style="color:#DF2A3F;">int deleteById(Serializable id)</font>`
+ 根据实体对象 Id 删除 `<font style="color:#DF2A3F;">int deleteById(T entity)</font>`
+ 按条件删除 `<font style="color:#DF2A3F;">int deleteByMap(Map<String, Object> columnMap)</font>`

```java
Map<String, Object> map = new HashMap<>();
map.put("name", "汪汪");
teamMapper.deleteByMap(map);
```

+ 根据 Id 或实体批量删除`<font style="color:#DF2A3F;">int deleteBatchIds(Collection<?> idList)</font>`

<h5 id="euQdh">逻辑删除 👁️‍🗨️</h5>
1. **<font style="background-color:#FBDE28;">步骤1</font>**：在 application.yml 中配置逻辑删除

```yaml
# 配置 mybatis-plus
mybatis-plus:
  configuration:
    # 配置控制台日志
    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl
  global-config:
  # 配置全局逻辑删除
    db-config:
      logic-delete-field: del # 逻辑删除字段名
      logic-delete-value: 1 # 逻辑已删除值, 默认 1
      logic-not-delete-value: 0 # 逻辑未删除值, 默认 0
```

2. **<font style="background-color:#FBDE28;">步骤2</font>**：实体类添加逻辑删除属性字段，与配置要一致

```java
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("team")
public class Team {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String name;
    @TableLogic
    private int del;
}
```

> mybatis-plus 3.3 之后可以不用添加 `<font style="color:#DF2A3F;">@TableLogic</font>` 注解到逻辑删除字端上
>

3. **<font style="background-color:#FBDE28;">步骤3</font>**：数据库表添加逻辑删除字段列，与配置要一致

```sql
alter table team
add del tinyint(1) default 0 not null
```

4. 测试逻辑删除

```java
teamMapper.deleteById(230789125);
teamMapper.selectList(null).forEach(System.out::println);
```

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728626574678-cfc2c70e-7180-4d5b-93ea-fd134c324980.png)

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728626636418-60cc7aea-8068-4153-bdec-d94fb2d9f8b4.png)

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728626814577-5df5bae0-bc01-495f-9ff9-7174d13691ea.png)

<h4 id="RgQdG">Wrapper 条件构造器 ⭐</h4>
> 文档：[https://baomidou.com/guides/wrapper/](https://baomidou.com/guides/wrapper/)
>

<font style="color:rgb(53, 56, 65);">MyBatis-Plus 提供了一套强大的</font>**<font style="background-color:#FBDE28;">条件构造器</font>**<font style="color:rgb(53, 56, 65);">（Wrapper），用于构建复杂的数据库查询条件</font>

+ <font style="color:rgb(53, 56, 65);">Wrapper 类允许开发者以</font><u><font style="color:#DF2A3F;">链式调用</font></u><font style="color:rgb(53, 56, 65);">的方式构造查询条件；</font>
+ <font style="color:rgb(53, 56, 65);">无需编写</font><u><font style="color:#DF2A3F;">繁琐的 SQL 语句</font></u><font style="color:rgb(53, 56, 65);">，从而提高开发效率；</font>
+ <font style="color:rgb(53, 56, 65);">并</font><u><font style="color:#DF2A3F;">减少 SQL 注入</font></u><font style="color:rgb(53, 56, 65);">的风险；</font>

**<font style="color:rgb(53, 56, 65);background-color:#FBDE28;">主要使用类</font>**<font style="color:rgb(53, 56, 65);">：Wrapper 是接口，</font>AbstractWrapper 实现了**<font style="color:rgb(53, 56, 65);"> </font>**<font style="color:rgb(53, 56, 65);">Wrapper，以下是其子类</font>

> <font style="color:rgb(53, 56, 65);">QueryWrapper、UpdateWrapper、LambdaQueryWrapper、LambdaUpdateWrapper</font>
>

<h5 id="UHOLY"><font style="color:rgb(53, 56, 65);">查询示例</font></h5>
1. 简单查询

> 根据封装的实体对象查询
>

```java
@Test
void testSelect() {
    Team team = new Team();
    team.setId(1);
    QueryWrapper<Team> wrapper = new QueryWrapper<>(team);
    teamMapper.selectList(wrapper).forEach(System.out::println);
}
```

2. 复杂查询

> 链式调用添加复杂查询条件
>

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728628857911-3893ebb5-50a6-4d38-b5c7-2776b37bea26.png)

```java
@Test
void testQueryWrapper() {
    QueryWrapper<Team> wrapper = new QueryWrapper<>();
    wrapper.like("name", "张")
    .eq("id", 8);
    teamMapper.selectList(wrapper).forEach(System.out::println);
}
```

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728628824330-170ff2a1-f3fc-41ea-b29e-15d4d56d1ef4.png)

<h5 id="fxZTl">lambda 表达式查询</h5>
> 作用：防止字段名字写错
>

```java
@Test
void testSelect() {
    LambdaQueryWrapper<Team> wrapper = new LambdaQueryWrapper<>();
    wrapper.like(Team::getName, "张");
    teamMapper.selectList(wrapper).forEach(System.out::println);
}
```

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728629488280-81e08381-4b51-4500-a6f4-69bfdd1d7c0f.png)

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728629634403-c41867ca-60b7-4d3d-99db-4ea963cd99bb.png)

<h5 id="XMPyT">动态 sql 条件判断</h5>
> import com.mysql.cj.util.StringUtils; 导入这个字符串工具类
>

`wrapper.like(boolean condition, R column, Object val)`

+ 当 `boolean condition` 条件判断为<font style="color:#DF2A3F;">真</font>时，<font style="color:#DF2A3F;">才添加</font>后面的查询判断条件 `R column, Object val`
+ 当 `boolean condition` 条件判断为<font style="color:#DF2A3F;">假</font>时，<font style="color:#DF2A3F;">不添加</font>后面的查询判断条件；

```java
@Test
void testQueryWrapper() {
    QueryWrapper<Team> wrapper = new QueryWrapper<>();
    Team team = new Team();
    team.setName("张");
    wrapper.like(!StringUtils.isNullOrEmpty(team.getName()), "name", team.getName());
    teamMapper.selectList(wrapper).forEach(System.out::println);
}
}
```

<h4 id="N73yk">更新数据</h4>
1. updateById

```java
@Test
void testUpdate() {
    Team team = new Team();
    team.setId(8);
    team.setName("张fei");
    teamMapper.updateById(team);
}
```

2. UpdateWrapper 只作更新条件判断

```java
@Test
void testUpdate() {
    UpdateWrapper<Team> wrapper = new UpdateWrapper<>();
    Team team = new Team();
    team.setName("汪汪");
    wrapper.like("name", "张");
    // 将带张字的队名改为汪汪
    teamMapper.update(team, wrapper);
}
```

3. UpdateWrapper 判断更新条件并设置值

```java
@Test
void testUpdate() {
    UpdateWrapper<Team> wrapper = new UpdateWrapper<>();
    wrapper.like("name", "张").set("name", "kkk");
    teamMapper.update(null, wrapper);
}
```

4. LambdaUpdateWrapper

```java
@Test
void testUpdate() {
    LambdaUpdateWrapper<Team> wrapper = new LambdaUpdateWrapper<>();
    wrapper.like(Team::getName, "k").set(Team::getName, "勇士");
    teamMapper.update(null, wrapper);
}
```

<h4 id="tp6jN">查询数据</h4>
> 略
>

+ 条件<font style="color:#DF2A3F;">或</font>运算查询

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728635906952-38ff9984-8cf9-4963-88eb-85ab23f73131.png)

+ 条件<font style="color:#DF2A3F;">与&或</font>运算查询

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728636007673-a53f4ea9-79ce-4df2-a140-ada0c627d0dd.png)

+ 查询结果<font style="color:#DF2A3F;">排序</font>

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728636243957-a4d4a0d3-b4b1-4441-b212-655c00b08c58.png)

+ <font style="color:#DF2A3F;">子查询</font>处理

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728636362792-a82dca97-2900-4fd8-b600-24acb08d975a.png)

<h3 id="UTvAy">分页查询 👁️‍🗨️</h3>
> 官方文档：[https://baomidou.com/plugins/pagination/](https://baomidou.com/plugins/pagination/)
>

1. **<font style="background-color:#FBDE28;">步骤1</font>**：创建 MybatisPlusConfig 配置类

```java
@Configuration
public class MybatisPlusConfig {
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(){
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL)); // 如果配置多个插件, 切记分页最后添加
        // 如果有多数据源可以不配具体类型, 否则都建议配上具体的 DbType
        return interceptor;
    }
}
```

2. **<font style="background-color:#FBDE28;">步骤2</font>**：使用 Page & SelectPage

```java
@Test
void testSelect() {
    Page<Team> page = new Page<>(2, 3);
    QueryWrapper<Team> wrapper = new QueryWrapper<>();
    wrapper.like("name", "勇");
    // 获取查询结果
    teamMapper.selectPage(page, wrapper).getRecords().forEach(System.out::println);
    System.out.println("总记录数：" + page.getTotal() + "，总页数：" + page.getPages() +
                       "，是否有上一页" + page.hasPrevious());
}
```

Page 的属性：

| <font style="color:rgb(53, 56, 65);">属性名</font> | <font style="color:rgb(53, 56, 65);">类型</font> | <font style="color:rgb(53, 56, 65);">默认值</font> | <font style="color:rgb(53, 56, 65);">描述</font> |
| :---: | :---: | :---: | :---: |
| <font style="color:rgb(53, 56, 65);">records</font> | <font style="color:rgb(53, 56, 65);">List<T></font> | <font style="color:rgb(53, 56, 65);">emptyList</font> | <font style="color:rgb(53, 56, 65);">查询数据列表</font> |
| <font style="color:rgb(53, 56, 65);">total</font> | <font style="color:rgb(53, 56, 65);">Long</font> | <font style="color:rgb(53, 56, 65);">0</font> | <font style="color:rgb(53, 56, 65);">查询列表总记录数</font> |
| <font style="color:rgb(53, 56, 65);">size</font> | <font style="color:rgb(53, 56, 65);">Long</font> | <font style="color:rgb(53, 56, 65);">10</font> | <font style="color:rgb(53, 56, 65);">每页显示条数，默认 10</font> |
| <font style="color:rgb(53, 56, 65);">current</font> | <font style="color:rgb(53, 56, 65);">Long</font> | <font style="color:rgb(53, 56, 65);">1</font> | <font style="color:rgb(53, 56, 65);">当前页</font> |
| <font style="color:rgb(53, 56, 65);">orders</font> | <font style="color:rgb(53, 56, 65);">List<OrderItem></font> | <font style="color:rgb(53, 56, 65);">emptyList</font> | <font style="color:rgb(53, 56, 65);">排序字段信息</font> |
| <font style="color:rgb(53, 56, 65);">optimizeCountSql</font> | <font style="color:rgb(53, 56, 65);">boolean</font> | <font style="color:rgb(53, 56, 65);">true</font> | <font style="color:rgb(53, 56, 65);">自动优化 COUNT SQL</font> |
| <font style="color:rgb(53, 56, 65);">optimizeJoinOfCountSql</font> | <font style="color:rgb(53, 56, 65);">boolean</font> | <font style="color:rgb(53, 56, 65);">true</font> | <font style="color:rgb(53, 56, 65);">自动优化 COUNT SQL 是否把 join 查询部分移除</font> |
| <font style="color:rgb(53, 56, 65);">searchCount</font> | <font style="color:rgb(53, 56, 65);">boolean</font> | <font style="color:rgb(53, 56, 65);">true</font> | <font style="color:rgb(53, 56, 65);">是否进行 count 查询</font> |
| <font style="color:rgb(53, 56, 65);">maxLimit</font> | <font style="color:rgb(53, 56, 65);">Long</font> | | <font style="color:rgb(53, 56, 65);">单页分页条数限制</font> |
| <font style="color:rgb(53, 56, 65);">countId</font> | <font style="color:rgb(53, 56, 65);">String</font> | | <font style="color:rgb(53, 56, 65);">XML 自定义 count 查询的 statementId</font> |


> `<font style="color:#DF2A3F;">selectMapsPage</font>`<font style="color:#DF2A3F;">：会将分页查询结果，以Map<字段名，字段值>形式返回；</font>
>

<h4 id="JewEM">自定义查询和分页 ⭐</h4>
1. **<font style="background-color:#FBDE28;">步骤1</font>**：配置 xml 映射文件扫描路径，和实体类扫描包

```yaml
# 配置 mybatis-plus
mybatis-plus:
  # 配置扫描的 mapper.xml 文件
  mapper-locations: classpath:mapper/*.xml
  # 配置扫描的实体类
  type-aliases-package: com.slz.springboot.entity
```

2. **<font style="background-color:#FBDE28;">步骤2</font>**：编写 mapper 接口

```java
public interface TeamMapper extends BaseMapper<Team> {
    List<Team> selectCustom();
    Page<Team> selectCustomPage(@Param("page")Page<Team> page, @Param("name")String name);
}
```

3. **<font style="background-color:#FBDE28;">步骤3</font>**：编写 mapper.xml 映射文件

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
"http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.slz.springboot.mapper.TeamMapper">

  <select id="selectCustom" resultType="Team">
    select * from team where del=0
  </select>
  <select id="selectCustomPage" resultType="Team">
    select * from team where del=0 and name like concat('%',#{name},'%')
  </select>
</mapper>
```

4. **<font style="background-color:#FBDE28;">步骤4</font>**：测试程序

```java
@Test
void testCustom() {
    Page<Team> page = new Page<>(2, 3);
    teamMapper.selectCustomPage(page, "勇");
    page.getRecords().forEach(System.out::println);
    System.out.println("总记录数：" + page.getTotal() + "，总页数：" + page.getPages());
    teamMapper.selectCustom().forEach(System.out::println);
}
```

<h3 id="No3bO">主键生成策略 👁️‍🗨️</h3>
1. 5种策略

代理主键：与业务逻辑无关

+ **<font style="background-color:#FBDE28;">auto</font>**：数据库ID<font style="color:#DF2A3F;">自增</font>
+ **<font style="background-color:#FBDE28;">assign_id</font>**：通过<font style="color:#DF2A3F;">雪花算法</font>，生成id(number或string)，<font style="color:#DF2A3F;">19位数字（数据库需要使用bigint或varchar）</font>
+ **<font style="background-color:#FBDE28;">assign_uuid</font>**：使用UUID，主键 string 类型 <font style="color:#DF2A3F;">32位长的字符串</font>(包含数字和字母)

自然主键：与业务逻辑相关

+ **<font style="background-color:#FBDE28;">Input</font>**：<font style="color:#DF2A3F;">用户输入</font>ID
+ **<font style="background-color:#FBDE28;">none</font>**：<font style="color:#DF2A3F;">没有指定</font>主键的类型:
    - 注解里使用，则跟随全局配置；
    - 全局配置里使用，相当于input；
2. 全局设置

> 全局配置之后，不需要再使用`<font style="color:#DF2A3F;">@TableId</font>`去指定
>

```yaml
# 配置 mybatis-plus
mybatis-plus:
  global-config:
    db-config:
      id-type: assign_id # 全局主键类型
```

> 扩展：
>
> 雪花算法（Snowflake Algorithm）是由Twitter公司开源的一种分布式ID生成算法。它主要用于生成全局唯一的、递增的、紧凑的ID序列，适用于分布式环境下的应用：
>
> + 唯一性：通过时间戳、机器ID和序列号的组合来保证；
> + 排序性：因为大部分位数用于存储时间戳，所以生成的ID在大多数情况下是递增的；
> + 可扩展性：通过分配不同的机器ID给不同的服务器或进程，可以水平扩展ID生成的能力；
> + 高性能：生成ID的操作主要是位运算，消耗资源少，速度快
>

```java
@Data
@TableName("xhids")
public class XueHuaId {
    private Long id;
    private LocalDate time;
}
```

```java
@Test
void contextLoads() {
    xueHuaIdMapper.insert(new XueHuaId());
}
```

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728645365469-82d5f913-0c32-4cc5-8c18-0275fc640806.png)

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728645407762-0f64f43e-8271-4289-b52f-ee88dbef371c.png)

<h3 id="GC4H3">自动填充功能 ⭐</h3>
> 官方文档：[https://baomidou.com/guides/auto-fill-field/](https://baomidou.com/guides/auto-fill-field/)
>
> 应用场景：
>
> + 记录创建时间（createTime）和修改时间（updateTime）;
> + 记录创建者（createUser）和修改者（updateUser）;
> + 记录某些状态变更的时间点，例如订单状态、用户状态等；
>

1. **<font style="background-color:#FBDE28;">步骤1</font>**：创建实体类，并用注解标注需要自动填充的段

`@TableField(fill =<font style="color:#D22D8D;"> FieldFill.INSERT</font>)` 插入时填充字段

`@TableField(fill = <font style="color:#D22D8D;">FieldFill.INSERT_UPDATE</font>)`  插入和更新时填充字段

```java
@Data
@TableName("goods")
public class Goods {
    private String id;
    private String name;
    private Double price;
    @TableField(value = "createTime", fill = FieldFill.INSERT) // 插入时填充字段
    private LocalDateTime createTime; // 创建时间
    @TableField(value = "updateTime", fill = FieldFill.INSERT_UPDATE) // 插入和更新时填充字段
    private LocalDateTime updateTime; // 修改时间
    private Integer del; // 逻辑删除标志
}
```

2. **<font style="background-color:#FBDE28;">步骤2</font>**：编写处理器，实现`<font style="color:#DF2A3F;">MetaObjectHandler</font>`接口的 <font style="color:#DF2A3F;">insertFill </font>和 <font style="color:#DF2A3F;">updateFill </font>方法

```java
@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("开始插入填充...");
        this.strictInsertFill(metaObject, "createTime", LocalDateTime.class, LocalDateTime.now());
        this.strictInsertFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now());
    }
    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("开始更新填充...");
        this.strictUpdateFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now());
    }
}
```

> 方法里设置的填充字段名要与数据库对应
>

3. **<font style="background-color:#FBDE28;">步骤3</font>**：编写 mapper 接口

```java
public interface GoodsMapper extends BaseMapper<Goods> {
}
```

4. **<font style="background-color:#FBDE28;">步骤4</font>**：编写测试程序

```java
@Test
void contextLoads() {
    UpdateWrapper<Goods> wrapper = new UpdateWrapper<>();
    wrapper.set("name", "魅族手机").eq("id", "1844714135451881474");
    goodsMapper.update(null, wrapper);
}
```

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728649112071-e225105b-bcea-44fc-a097-0090f2403ced.png)

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728649484199-0090594c-c7ce-4a5b-99ce-5a52393b526c.png)

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728649516085-9556fd1e-fb90-4018-9162-af952d8a4a5a.png)

<h3 id="ZUD8R">通用枚举</h3>
> 官方文档：[https://baomidou.com/guides/auto-convert-enum/](https://baomidou.com/guides/auto-convert-enum/)
>
> 应用场景：(<font style="color:#DF2A3F;">数据库-数据字典</font>)
>
> + 男 1 女 0
> + 入库 1 出库 0
> + 未完成 0 已完成 1 未开始 -1
> + ……
>

1. **<font style="background-color:#FBDE28;">步骤1</font>**：创建枚举类
+ 方法一：实现 `<font style="color:#DF2A3F;">IEnum<Integer></font>`接口，并实现 `<font style="color:#DF2A3F;">Integer getValue()</font>`方法

```java
public enum GoodsStatusEnum implements IEnum<Integer> {
    IN(0, "入库"),
    OUT(1, "出库");

    //    @EnumValue
    private final Integer code;
    private final String desc;

    GoodsStatusEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }
    // 重写 toString() 方法，查询时返回描述，而非 0 1
    @Override
    public String toString() {
        return desc;
    }

    @Override
    public Integer getValue() {
        return code;
    }
}
```

+ 方法二：使用 `<font style="color:#DF2A3F;">@EnumValue</font>`注解标注枚举类 code

```java
public enum GoodsStatusEnum {
    IN(0, "入库"),
    OUT(1, "出库");

    @EnumValue
    private final Integer code;
    private final String desc;

    GoodsStatusEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }
    // 重写 toString() 方法，查询时返回描述，而非 0 1
    @Override
    public String toString() {
        return desc;
    }
}
```

2. **<font style="background-color:#FBDE28;">步骤2</font>**：添加枚举类属性到实体类，并修改数据库字段

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728887870898-c8b4c2cf-bb29-466a-8931-390da2cc0e37.png)

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728887902333-d9fbe94b-2dc9-4f29-a4fe-5f3b1790cc89.png)

3. **<font style="background-color:#FBDE28;">步骤3</font>**：application.yml** **配置通用枚举类扫描包

```yaml
# 配置 mybatis-plus
mybatis-plus:
  # 配置扫描枚举类
  type-enums-package: com.slz.springboot.enums
```

4. **<font style="background-color:#FBDE28;">步骤4</font>**：测试程序

```java
@Test
void contextLoads() {
    Goods goods = new Goods();
    goods.setName("小米手机");
    goods.setPrice(4997.0);
    goods.setStatus(GoodsStatusEnum.OUT);
    //        goodsMapper.insert(goods);
    QueryWrapper<Goods> wrapper = new QueryWrapper<>();
    wrapper.like("name", "华为");
    goodsMapper.selectList(wrapper).forEach(System.out::println);
}
```

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728888042221-11a222cb-1dee-42fe-b0a3-243a77159341.png)

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728888059776-9208801d-67cf-4fb1-a947-0ca900d209d2.png)

<h3 id="BuZsh">通用 Service</h3>
> 官方文档：[https://baomidou.com/guides/data-interface/#service-interface](https://baomidou.com/guides/data-interface/#service-interface)
>

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728890494517-18404409-e4d7-4cf9-a63c-6e8a3ed0f3db.png)

1. XxxService 接口继承 IService<T> 接口

```java
public interface GoodsService extends IService<Goods>{
}
```

2. XxxServiceImpl 类继承 ServiceImpl<M,T> 类，并实现 XxxService 接口

```java
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {
}
```

3. 测试

```java
void testService(){
    List<Goods> list = goodsService.list();
    list.forEach(System.out::println);
}
```

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728890695552-00045fcb-ed72-4a5b-af68-aab8debb2e6b.png)

<h3 id="fldVz">多数据源 👁️‍🗨️</h3>
> 官方文档：[https://baomidou.com/guides/dynamic-datasource/](https://baomidou.com/guides/dynamic-datasource/)
>

<font style="color:rgb(53, 56, 65);">随着项目规模的扩大，单一数据源已无法满足复杂业务需求，多数据源（动态数据源）应运而生。两种 MyBatis-Plus 的</font>**<font style="color:rgb(53, 56, 65);">多数据源扩展插件</font>**<font style="color:rgb(53, 56, 65);">：</font>

+ <font style="color:rgb(53, 56, 65);">开源生态的 </font>`<font style="color:#DF2A3F;">dynamic-datasource</font>`<font style="color:rgb(53, 56, 65);"> ；</font>
+ <font style="color:rgb(53, 56, 65);">企业级生态的 </font>`<font style="color:rgb(53, 56, 65);">mybatis-mate</font>`<font style="color:rgb(53, 56, 65);">；</font>

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728893168409-35f6cdef-7db5-4812-8c4e-19339ff76c52.png)

<font style="color:rgb(53, 56, 65);background-color:#FBDE28;">以</font>`<font style="color:#DF2A3F;background-color:#FBDE28;">dynamic-datasource</font>`<font style="color:rgb(53, 56, 65);background-color:#FBDE28;">的使用为例</font>

1. **<font style="color:rgb(53, 56, 65);background-color:#FBDE28;">步骤1</font>**<font style="color:rgb(53, 56, 65);">：pom，引入</font>`<font style="color:#DF2A3F;">dynamic-datasource</font>`插件依赖

```xml
<!--   多数据源插件-->
<dependency>
  <groupId>com.baomidou</groupId>
  <artifactId>dynamic-datasource-spring-boot-starter</artifactId>
  <version>3.5.1</version>
</dependency>
```

2. **<font style="background-color:#FBDE28;">步骤2</font>**：创建多个数据库

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728892960354-bc9d007d-bbb4-4f07-ae50-0f1b48f5b936.png)

3. **<font style="background-color:#FBDE28;">步骤3</font>**：application.yml 配置多数据源

配置格式可以是：

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728892703197-8c7e6722-2b04-4daa-be1b-add544d4779b.png)

```yaml
spring:
  # 配置数据库连接信息
  datasource:
    # 动态数据源配置，多数据源
    dynamic:
      primary: master # 默认数据源 / 数据源组
      strict: false # 严格匹配数据源，默认false；true未匹配到指定数据源时抛异常，false使用默认数据源
      datasource:
        master:
          url: jdbc:mysql://localhost:3306/test?serverTimezone=GMT%2B8
          username: root
          password: root
          driver-class-name: com.mysql.cj.jdbc.Driver
        slave:
          url: jdbc:mysql://localhost:3306/test1?serverTimezone=GMT%2B8
          username: root
          password: root
          driver-class-name: com.mysql.cj.jdbc.Driver
```

4. **<font style="background-color:#FBDE28;">步骤4</font>**：使用 `<font style="color:#DF2A3F;">@DS</font>`注解切换数据源，可以标注在类或者方法上

> `<font style="color:#DF2A3F;">@DS</font>`可以注解在方法上或类上，同时存在**<u>就近原则</u>** （<font style="color:#DF2A3F;background-color:#FBDE28;">方法上注解 优先于 类上注解</font>）
>
> + 没有`<font style="color:#DF2A3F;">@DS</font>`，使用默认数据源；
> + `<font style="color:#DF2A3F;">@DS("ds_name")</font>`，dsName可以为组名也可以为具体某个库的名称
>

```java
@Service
@DS("master")
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {
}
```

```java
@Service
@DS("slave")
public class GoodsServiceImpl2 extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {
}
```

5. **<font style="background-color:#FBDE28;">步骤5</font>**：测试

```java
@Test
void insert() {
    Goods goods = new Goods();
    goods.setStatus(GoodsStatusEnum.IN);
    goods.setName("苹果手机");
    goods.setPrice(9997.89);
    goodsService2.save(goods);
}
@Test
void multiDataSource(){
    goodsService.list().forEach(System.out::println);
    goodsService2.list().forEach(System.out::println);
}
```

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728894575298-96d7cb60-2761-40de-935b-b2b612147654.png)

<h3 id="g9vkS">乐观锁插件 👁️‍🗨️ @Version </h3>
> 官方文档：[https://baomidou.com/plugins/optimistic-locker/](https://baomidou.com/plugins/optimistic-locker/)
>

<font style="color:rgb(53, 56, 65);">乐观锁是一种并发控制机制，用于确保在更新记录时，该记录未被其他事务修改。MyBatis-Plus 提供了 </font>`<font style="color:rgb(53, 56, 65);">OptimisticLockerInnerInterceptor</font>`<font style="color:rgb(53, 56, 65);"> 插件，使得在应用中实现乐观锁变得简单。</font>

<h4 id="AeM8q"><font style="color:rgb(53, 56, 65);">实现原理</font></h4>
<font style="color:rgb(53, 56, 65);">乐观锁的实现通常包括以下步骤：</font>

1. <font style="color:rgb(53, 56, 65);">读取记录时，获取当前的</font>**<font style="color:rgb(53, 56, 65);background-color:#FBDE28;">版本号（version）</font>**<font style="color:rgb(53, 56, 65);">。</font>
2. <font style="color:rgb(53, 56, 65);">在更新记录时，将这个版本号一同传递。</font>
3. <font style="color:rgb(53, 56, 65);">执行更新操作时，设置 </font>`<font style="color:#DF2A3F;">version = newVersion</font>`<font style="color:rgb(53, 56, 65);"> 的条件为 </font>`<font style="color:#DF2A3F;">version = oldVersion</font>`<font style="color:rgb(53, 56, 65);">。</font>
4. <font style="color:rgb(53, 56, 65);">如果版本号不匹配，则更新失败。</font>

<h4 id="GPWhp"><font style="color:rgb(53, 56, 65);">使用插件</font></h4>
1. 使用配置类 MybatisPlusConfig.java 配置乐观锁插件

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728907163611-d51284a3-004f-410d-a61c-317e2b6beae6.png)

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728907186636-fe7beae6-9909-4406-b354-32a11e74cc62.png)

2. 创建带有 `<font style="color:#DF2A3F;">version</font>` 字段的数据库表

```sql
create table if not exists test.user
(
    id      bigint        not null
        primary key,
    name    varchar(255)  null comment '姓名',
    age     int           null comment '年龄',
    version int default 1 not null comment '版本号'
)
    comment '用户表';
```

3. 创建带有 `<font style="color:#DF2A3F;">version</font>` 属性的实体类，在属性上添加`<font style="color:#DF2A3F;">@Version</font>`注解

```java
@Data
@TableName("user")
public class User {
    private Long id;
    private String name;
    private Integer age;
    @Version
    @TableField(value = "version")
    private Integer version;
}
```

4. 测试

> **<font style="background-color:#FBDE28;">注意：更新时版本号自增的前提是，更新参数带上版本号 </font>**`**<font style="color:#DF2A3F;background-color:#FBDE28;">version</font>**`
>
> + 更新前做一次查询获得当前版本号；
> + 更新时带上当前版本号，mybatis-plus 会让版本号加一
>

```java
@Test
void testOpLock(){
    // @Version 版本号自增前提，更新前做一次查询获得当前版本号
    User user = userService.getById(1845755094390317057L);
    // 设置更新数据
    user.setName("张弘毅");
    user.setAge(35);
    // 执行更新操作，user 会带上当前版本号，mybatis-plus 会让版本号加一
    userService.updateById(user);
}
```

<h3 id="CsJ6d">**<font style="color:rgb(53, 56, 65);">ActiveRecord 模式</font>**</h3>
> <font style="color:rgb(53, 56, 65);">官方文档：</font>[https://baomidou.com/guides/data-interface/#activerecord](https://baomidou.com/guides/data-interface/#activerecord)
>
> <font style="color:rgb(53, 56, 65);">Mybatis-plus 支持 ActiveRecord 形式调用，实体类只需继承 Model 类即可进行强大的 CRUD 操作</font>
>

<font style="color:rgb(53, 56, 65);">AR的 Active Record 模式和 MP 的 Mapper 模式的比较：</font>

> 1. <font style="color:rgb(53, 56, 65);">ActiveRecord 模式是一种设计模式，它允许实体类直接与数据库进行交互，实体类既是领域模型又是数据访问对象。在 Mybatis-Plus 中，实体类</font>**<font style="color:#DF2A3F;">只需继承 </font>**`**<font style="color:#DF2A3F;">Model</font>**`**<font style="color:#DF2A3F;"> 类即可获得强大的 CRUD 操作能力</font>**<font style="color:rgb(53, 56, 65);">。</font>
> 2. ActiveRecord 一直广受动态语言(PHP、Ruby等)的喜爱，而 **<font style="color:#DF2A3F;">Java 作为准静态语言</font>**，对于 ActiveRecord 往往只能感叹其优雅，所以 MP 也在 AR 道路上进行了一定的探索；
>

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728907906130-a46cfd61-94f2-445a-85c5-460584dd7ab0.png)

使用：

1. 实体类继承 `<font style="color:#DF2A3F;">Model<Entity></font>`

```java
@Data
@TableName("user")
public class User extends Model<User> {
    private Long id;
    private String name;
    private Integer age;
    @Version
    @TableField(value = "version")
    private Integer version;
}
```

2. Mapper 继承 BaseMapper (<font style="color:#4C16B1;">还是通过 Mapper 实现的</font>)

```java
public interface UserMapper extends BaseMapper<User> {
}
```

3. 测试

```java
@Test
void testAc() {
    User user = new User();
    user.setName("刘大鹅");
    user.setAge(54);
    user.setId(1845803772668907522L);
    //        boolean insert = user.insert();
    User user1 = user.selectById();
    user1.updateById();
}
```

<h3 id="VBB60">代码生成器 ⭐</h3>
> 官方文档：[https://baomidou.com/guides/new-code-generator/](https://baomidou.com/guides/new-code-generator/)，3.5.1 版本及以上，用新版
>

<h4 id="TTOO7">创建 springboot 项目</h4>
1. 使用 IDEA 创建

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728909681578-663b762a-c328-44d5-a962-7de80074ad0c.png)

2. 添加依赖项

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728909881351-5049289a-3af0-4a69-9950-7a66204f7ef0.png)

3. pom 配置依赖：

```xml
<dependencies>
  <!--   模板引擎，mybatis-plus代码生成器依赖包 -->
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-freemarker</artifactId>
  </dependency>
  <!--   整合swagger3 -->
  <dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-boot-starter</artifactId>
    <version>3.0.0</version>
  </dependency>
  <!--   mybatis-plus     -->
  <dependency>
    <groupId>com.baomidou</groupId>
    <artifactId>mybatis-plus-boot-starter</artifactId>
    <version>3.5.1</version>
  </dependency>
  <!--   mybatis-plus-generator 代码生成器   -->
  <dependency>
    <groupId>com.baomidou</groupId>
    <artifactId>mybatis-plus-generator</artifactId>
    <version>3.5.1</version>
  </dependency>
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
  </dependency>

  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-devtools</artifactId>
    <scope></scope>
    <optional>true</optional>
  </dependency>
  <dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
  </dependency>
  <dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <optional>true</optional>
  </dependency>
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-test</artifactId>
    <scope>test</scope>
  </dependency>
</dependencies>
```

**<font style="background-color:#FBDE28;">重要的是</font>**如下两个包的导入：

+ 模板引擎：`spring-boot-starter-freemarker`
+ 代码生成器插件：`mybatis-plus-generator`

```xml
<!--   模板引擎，mybatis-plus代码生成器依赖包 -->
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-freemarker</artifactId>
</dependency>
<!--   mybatis-plus-generator 代码生成器   -->
<dependency>
  <groupId>com.baomidou</groupId>
  <artifactId>mybatis-plus-generator</artifactId>
  <version>3.5.1</version>
</dependency>
```

4. application.yml 配置数据源和 swagger3 兼容的匹配策略

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/test?serverTimezone=GMT%2B8
    username: root
    password: root
    driver-class-name: com.mysql.cj.jdbc.Driver
  mvc:
    pathmatch:
      # 作用：修改匹配策略，swagger 3.0.0 默认使用 PathPatternParser, 修改是因为3.0.0 版本不兼容
      matching-strategy: ant_path_matcher
```

<h4 id="Bggei">生成基本代码</h4>
```java
@SpringBootTest
public class SpringTest {
    @Test
    void testGenerator() {
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/test?serverTimezone=GMT%2B8", "root", "root")
        .globalConfig(builder -> {
            builder.author("slz") // 设置作者
            .enableSwagger() // 开启 swagger 模式
            .outputDir(".\\src\\main\\java"); // 指定输出目录
        })
        .packageConfig(builder ->
                       builder.parent("com.slz") // 设置父包名
                       .moduleName("springboot") // 设置父包模块名
                       //                                .pathInfo(Collections.singletonMap(OutputFile.xml, "D://")) // 设置mapperXml生成路径
                      )
        .strategyConfig(builder ->
                        builder.addInclude("sys_params") // 设置需要生成的表名
                        .addTablePrefix("sys_", "c_") // 设置过滤表前缀
                       )
        .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
        .execute();
    }
}
```

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728968636045-b1d393af-ecf0-4b80-8021-78f5fe6eb6b6.png)

<h4 id="KtAeG">相关配置</h4>
> 官方文档：[https://baomidou.com/reference/new-code-generator-configuration/](https://baomidou.com/reference/new-code-generator-configuration/)
>

尝试：

+ 开启 Swagger
+ 开启 lombok
+ 开启链式编程
+ 开启逻辑删除
+ 开启乐观锁
+ 开启 RESTFul 风格 Controller
+ 开启 @Mapper 注解

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728970259773-c8ed8051-09c3-4110-a848-6b414fc49074.png)

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728970452559-6c1f00dd-3e80-4340-9b03-15008fa61e06.png)

**<font style="background-color:#FBDE28;">手动配置 Swagger3</font>**

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728970673513-35a06aea-5ea0-4164-a084-a2b6d500e667.png)

```java
// @Configuration : 配置类，相当于 applicationContext.xml文件中 <beans> 标签
@Configuration
public class Swagger3Config {
    @Bean // Bean 注解，将返回值放入 Spring 容器，相当于 applicationContext.xml文件中 <bean> 标签
    public Docket apiConfig() { // 方法名可以任意，返回值类型必须是 Docket
        // Swagger3 使用 OAS_30， Swagger2 使用 SWAGGER_2
        return new Docket(DocumentationType.OAS_30)
        .apiInfo(apiInfo())
        .select()
        // 设置通过什么方式定位到需要生成文档的接口
        // 定位了方法上的 @ApiOperation 注解
        .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
        .paths(PathSelectors.any()) // 设置哪些接口暴露给Swagger展示，any() 表示所有, regex() 表示正则匹配
        .build();
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
        .title("swagger3")
        .description("swagger3接口文档")
        .contact(new Contact("sunlinzhao", "https://github.com/sunlinzhao", "2436949535@qq.com"))
        .version("1.0")
        .build();
    }
}
```

<h4 id="cdoNy">Controller 封装结果👁️‍🗨️</h4>
1. 封装返回结果 **<font style="background-color:#FBDE28;">Result</font>**

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728971962703-5efff3b4-bc7b-4b6f-a2ea-6ca0f0bc40ce.png)

```java
public interface ResultCode {
    Integer SUCCESS = 20000;
    Integer ERROR = 20001;
}
```

```java
@Data
@Accessors(chain = true)
public class Result {
    private Boolean success;
    private Integer code;
    private String msg;
    private Map<String, Object> data;

    public static Result success(){
        return new Result().setSuccess(true)
        .setCode(ResultCode.SUCCESS)
        .setMsg("成功")
        .setData(new HashMap<>());
    }
    public static Result error(){
        return new Result().setSuccess(false)
        .setCode(ResultCode.ERROR)
        .setMsg("失败")
        .setData(new HashMap<>());
    }
    public Result setData(Map<String, Object> data){
        this.data = data;
        return this;
    }
    public Result setData(String key, Object value){
        this.data.put(key, value);
        return this;
    }
}
```

```java
@RestController
@RequestMapping("/springboot/params")
public class ParamsController {
    @RequestMapping("/list")
    public Result list() {
        return Result.success();
    }
}
```

2. 编写 Controller

```java
@RestController
@RequestMapping("/springboot/params")
@Api(tags = "参数管理")
public class ParamsController {
    @Resource
    private IParamsService paramsService;

    @GetMapping("/list")
    @ApiOperation("查询参数列表")
    public Result list() {
        List<Params> list = paramsService.list();
        return Result.success().setData("list", list);
    }

    @PostMapping("/add")
    @ApiOperation("添加参数")
    public Result add(@RequestBody Params params) {
        return paramsService.save(params) ? Result.success() : Result.error();
    }
    @PutMapping("/update")
    @ApiOperation("修改参数")
    public Result update(@RequestBody Params params) {
        return paramsService.updateById(params) ? Result.success() : Result.error();
    }
    @DeleteMapping("/delete/{id}")
    @ApiOperation("删除参数")
    public Result delete(@PathVariable Long id) {
        return paramsService.removeById(id) ? Result.success() : Result.error();
    }
    @GetMapping("/get/{id}")
    @ApiOperation("查询参数")
    public Result get(@PathVariable Long id) {
        return Result.success().setData("params", paramsService.getById(id));
    }

    @GetMapping("/{start}/{size}")
    @ApiOperation("分页查询参数")
    public Result selectPage(@PathVariable Integer start, @PathVariable Integer size) {
        Page<Params> page = new Page<>(start, size);
        paramsService.page(page);
        return Result.success().setData("page", page);
    }
}
```

3. MybatisPlusConfig 配置分页

```java

@Configuration
public class MybatisPlusConfig {
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        // 分页插件
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        // 如果有多数据源可以不配具体类型, 否则都建议配上具体的 DbType
        interceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor()); // 添加乐观锁插件
        return interceptor;
    }
}
```

4. 测试运行

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728974629593-b7e94dfc-a10e-4395-98cb-f028f4978d77.png)

<h4 id="do97i">设置 Mapper.xml 位置 ⭐</h4>
1. 默认生成位置 `/src/main/java/**/mapper/xml/`

> 将生成的 Mapper.xml 文件移动到 resources/mapper 目录下
>

配置 application.yml 文件

```yaml
mybatis-plus:
  configuration:
    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl
  mapper-locations: classpath:mapper/*.xml # 扫描 mapper.xml
  type-aliases-package: com.slz.springboot.entity # 扫描 entity, 别名
```

2. 更改默认生成位置

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728975536451-119e8d87-e2c0-4169-a3a3-d7ec277b12d9.png)

<h3 id="KGCjT">MybatisX 插件 ⭐</h3>
> 官方文档：[https://baomidou.com/guides/mybatis-x/](https://baomidou.com/guides/mybatis-x/)
>

<font style="color:rgb(53, 56, 65);">MybatisX 是一款专为 IntelliJ IDEA 设计的快速开发插件，旨在提升 MyBatis 与 MyBatis-Plus 框架的开发效率。</font>IDEA 安装插件 MybatisX。

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728976222510-2c431c36-28b6-460d-8fb0-554ef33f7e40.png)

主要功能：

1. XML 映射跳转

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728976447594-5d8174b3-8de1-4981-8db6-a9579385bf34.png)

2. 代码生成

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728976637806-6eb15480-f40b-437f-b368-e0e49f79113c.png)

3. JPA 风格提示

> JPA（Java Persistence API）是一种为Java开发人员提供的规范，用于管理关系型数据库中的数据。它允许开发人员以面向对象的方式操作数据库，而不需要直接编写SQL语句。
>

<font style="color:#585A5A;">(包括新增、查询、修改和删除操作的自动代码生成，</font>**<font style="color:#DF2A3F;">包括各种逻辑类型的增删改查</font>**<font style="color:#585A5A;">)</font>

<font style="color:#585A5A;">Alt + Enter</font>

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728977376371-b9d119fd-0b33-42c6-8ff5-63be1c7af369.png)

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728977403250-6be4a49b-e0ec-47bf-9077-1e6b923222ad.png)

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728977454529-3ad75541-8768-4734-b6b9-8c23faad481d.png)

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728977824627-8b5bb963-93f2-45d9-8476-cea430b362bc.png)

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728977898698-5c602f1a-4e19-4c0e-bbc7-31ba16cab0ca.png)

<h2 id="fNDQi">Thymeleaf 模板引擎</h2>
Thymeleaf 是一个用于 Web 和独立环境的现代服务器端 Java 模板引擎。它可以用来生成任何类型的文本输出，如 HTML、XML、JavaScript 等。

使用 Thymeleaf 在 Spring Boot 项目中生成动态 HTML 页面，并将数据从前端传递到后端进行展示。Thymeleaf 提供了许多强大的功能，如条件判断、循环、表单处理等，非常适合用于 Web 应用开发。

<h3 id="n2q9n">创建 springboot 项目</h3>
1. idea 引导创建

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728980024911-7388de46-9b0e-412d-9c1d-b7aa247f922f.png)

2. pom 引入依赖

```xml
<dependencies>
  <!--    thymeleaf模板引擎依赖    -->
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-thymeleaf</artifactId>
  </dependency>
  <!--    mybatis-plus    -->
  <dependency>
    <groupId>com.baomidou</groupId>
    <artifactId>mybatis-plus-boot-starter</artifactId>
    <version>3.5.1</version>
  </dependency>
  <dependency>
    <groupId>com.alibaba</groupId>
    <artifactId>druid-spring-boot-starter</artifactId>
    <version>1.2.8</version>
  </dependency>
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
  </dependency>
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-devtools</artifactId>
    <scope>runtime</scope>
    <optional>true</optional>
  </dependency>
  <dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
  </dependency>
  <dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <optional>true</optional>
  </dependency>
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-test</artifactId>
    <scope>test</scope>
  </dependency>
</dependencies>
```

重要的依赖是：

```xml
  <!--    thymeleaf模板引擎依赖    -->
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-thymeleaf</artifactId>
  </dependency>
```

3. 创建 `application.yml`文件到目录 `src/main/resources`
4. `application.yml`配置数据源

```yaml
spring:
  # 数据源配置
  datasource:
    druid:
      url: jdbc:mysql://localhost:3306/test?serverTimezone=GMT%2B8
      username: root
      password: root
```

5. `application.yml`配置mybatis-plus

```yaml
# mybatis-plus 配置
mybatis-plus:
  configuration:
    # 打印sql
    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl
  global-config:
    # 主键策略
    db-config:
      id-type: assign_id
      logic-delete-field: del
      logic-not-delete-value: 0
      logic-delete-value: 1
```

6. 使用 MybatisX 插件生成基本骨架

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728982913052-87819aed-f391-4113-b32c-a547e08d79d2.png)

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728982949826-8697f0b8-6921-4590-9125-2760dc294d92.png)

<h3 id="OxutK">相关配置</h3>
<h4 id="wZZXY">配置 thymeleaf html 文件模板</h4>
![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728981970809-51a7210b-b257-4b0a-96ae-8be9d3b04cca.png)

```html
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
  <head>
    <meta charset="UTF-8">
    <title>Title</title>
  </head>
  <body>

  </body>
</html>
```

<h4 id="Vworq">`application.yml`配置 thymeleaf</h4>
```yaml
spring:
  # 模板配置
  thymeleaf:
    # dev 关闭thymeleaf缓存，prod 开启 thymeleaf 缓存
    cache: false # 关闭thymeleaf缓存
```

<h4 id="jlgXX">bootstrap 下载 css 样式</h4>
> bootstrap 官网：[Getting started · Bootstrap (getbootstrap.com)](https://getbootstrap.com/docs/3.4/getting-started/#download)
>

![](https://cdn.nlark.com/yuque/0/2024/png/42892034/1728984056121-dd6d0b7b-fc9d-46e2-85fd-248c9a2f4e0e.png)

> bootstrap 包含了许多已有样式和前端组件 [https://v3.bootcss.com/css/#overview](https://v3.bootcss.com/css/#overview)
>

application.yml **<font style="background-color:#FBDE28;">配置静态资源路径</font>**：

```yaml
spring:
  # 静态资源配置
  web:
    resources:
      static-locations: classpath:/static/
```

---

（.........前端知识，略）



