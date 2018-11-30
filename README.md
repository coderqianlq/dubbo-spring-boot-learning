<div align="center">
  <img src="https://i.ibb.co/250CB9Y/154358749351878.png" width="60%"/>
	<br/>
	
  [![Build Status](https://travis-ci.org/coderqianlq/spring-boot-dubbo-cli.svg?branch=master)](https://travis-ci.org/coderqianlq/spring-boot-dubbo-cli)
  [![License](https://img.shields.io/badge/license-MIT-blue.svg)](https://github.com/coderqianlq/spring-boot-dubbo-cli/blob/master/LICENSE)
</div>

**快速开始**

通常情况，dubbo应用有两种使用场景，其一为服务提供方，另外一个是服务消费方。

这里选择更优的方式，在dubbo的服务层之上提供一个API网关，由API网关负责对dubbo服务的访问（可以考虑用泛化的方式去调用），这样所有的业务系统只要以Restful的方式调用API网关即可调用dubbo服务。

在dubbo-api中定义服务提供方为服务消费方暴露接口：

```java
public interface TestService {
    String test(String text);
}
```

**服务提供方**

添加依赖：

```xml
<dependencies>
    <dependency>
        <groupId>com.alibaba.boot</groupId>
        <artifactId>dubbo-spring-boot-starter</artifactId>
        <version>0.2.0</version>
    </dependency>
    
    <dependency>
        <groupId>com.coderqian</groupId>
        <artifactId>dubbo-api</artifactId>
        <version>0.0.1-SNAPSHOT</version>
    </dependency>
</dependencies>
```

在application.properties添加dubbo的相关配置信息：

```properties
# 当前dubbo应用id
dubbo.application.id=dubbo-provider
# 当前dubbo应用名称
dubbo.application.name=dubbo-provider
# 注册中心
dubbo.registry.address=zookeeper://127.0.0.1:2181
dubbo.server=true
# 生产者暴露给消费者协议
dubbo.protocol.name=dubbo
# 生产者暴露给消费者端口
dubbo.protocol.port=20880
```

注：这个配置只针对服务提供方，消费方不用指定协议，它自己会根据服务端的地址信息和@Reference注解去解析协议。

在Spring Boot Application的上添加`@EnableDubbo`，表示要开启dubbo功能。(dubbo provider服务可以使用或者不使用web容器)

```java
@EnableDubbo
@SpringBootApplication
public class DubboProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboProviderApplication.class, args);
    }
}
```

实现TestService，对外提供服务。

```java
@Service
public class TestServiceImpl implements TestService {

    @Override
    public String test(String text) {
        return text;
    }
}
```

注：`@Service`是dubbo提供的注解`com.alibaba.dubbo.config.annotation.Service`。

**服务消费方**

添加依赖：

```xml
<dependencies>
    <dependency>
        <groupId>com.alibaba.boot</groupId>
        <artifactId>dubbo-spring-boot-starter</artifactId>
        <version>0.2.0</version>
    </dependency>
    
    <dependency>
        <groupId>com.coderqian</groupId>
        <artifactId>dubbo-api</artifactId>
        <version>0.0.1-SNAPSHOT</version>
    </dependency>
</dependencies>
```

在application.properties添加dubbo的相关配置信息：

```properties
# 当前dubbo应用id
dubbo.application.id=dubbo-customer
# 当前dubbo应用名称
dubbo.application.name=dubbo-customer
# 注册中心
dubbo.registry.address=zookeeper://127.0.0.1:2181

# 生产者提供的协议id
dubbo.protocol.id=dubbo-provider
# 生产者提供的协议名称
dubbo.protocol.name=dubbo
# 生产者提供的协议端口号
dubbo.protocol.port=20880
```

通过`@Reference`注入需要使用的服务。

```java
@RestController
@RequestMapping("/customer")
public class TestController {

    @Reference
    private TestService testService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String test(String text) {
        return testService.test(text);
    }
}
```

**参考文档**

* dubbo: http://dubbo.io
* spring-boot: http://projects.spring.io/spring-boot
* dubbo-spring-boot-starter: https://github.com/alibaba/dubbo-spring-boot-starter
* dubbo-spring-boot-project: https://github.com/dubbo/dubbo-spring-boot-project

