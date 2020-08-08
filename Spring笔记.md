# Spring 笔记

## AOP 动态代理

> https://docs.spring.io/spring/docs/current/spring-framework-reference/core.html#aop

两种代理方式:

* JDK的动态代理，通过实现InvocationHandler来实现

* CGLib动态代理，使用字节码技术，比Java反射效率高

  实现MethodInterceptor接口。

### 概念

* 切面（Aspect）

  一个模块化的对象，可以把类分割成很多个部分。在 Spring AOP 中，切面是一个 Bean，可以用 `@Aspect` 注解声明。

* 连接点（Join point）

  连接点是在应用执行过程中能够插入切面的一个点。切面代码可以利用这些点插入到应用的正常流程之中，并添加新的行为。在 Spring AOP 中，一个连接点代表一个执行的方法。

* 通知（Advice）

* 切点（Poincut）

* 引入（Introduction）

* 目标对象（Target object）

* AOP 代理（AOP proxy）

* 织入（Weaving）

### 通知声明

> https://docs.spring.io/spring/docs/current/spring-framework-reference/core.html#aop-advice

| 通知注解        | 说明                                                      |
| --------------- | --------------------------------------------------------- |
| @Before         |                                                           |
| @AfterReturning |                                                           |
| @AfterThrowing  |                                                           |
| @After          |                                                           |
| @Around         | `public Object doBasicProfiling(ProceedingJoinPoint pjp)` |

**注意：**@Around 通知在方法调用之前切入，在切面中需要手动执行方法（`proceed()`），并且将得到的返回值返回，被切的方法才能正常运行。

```java
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.ProceedingJoinPoint;

@Aspect
public class AroundExample {
    
    @Around("com.xyz.myapp.SystemArchitecture.businessService()")
    public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
        // start stopwatch
        Object retVal = pjp.proceed();
        // stop stopwatch
        return retVal;
    }
    
}
```

## IoC 控制反转

```java
ApplicationContext context = new ClassPathXmlApplicationiContext("applicationContext.xml");
context.getBean("beanid");
context.getBean(Bean.class);
```

常用两种控制反转容器：

* BeanFactory

  简单容器，延迟加载（过时）

* ApplicationContext

  企业级？立即加载（在容器加载的时候就实例化了）

区别：ApplicationContext 是 BeanFactory 的子接口，也被称为 Spring 上下文，AC 包含了 BF 的所有功能。

常用 ApplicationContext：

* FileSystemXmlApplicationContext

  文件路径

* ClassPathXmlApplicationContext

  类所在路径

* AnnotatiionConfigApplicationContext

  使用注解配置

* WebApplicationContext

  SpringMVC里面

### Spring 创建 bean 的方式

* 普通构造方法

* 简单工厂方法

* 工厂静态方法

### bean 的生命周期

init-method，destroy-method，初始化和销毁时执行的方法。

### bean的作用域（scope）：

* singleton
* prototype（多例，每次新实例）
* request
* session
* global-session（多用于集群环境）

## 依赖注入

注入方式：

1. 构造函数

   通过构造方法的方式。

   ```xml
   <bean id="userService" class="xxx.UserService" scope="singleton">
       <constructor-arg ref="userDao"></constructor-arg>
   </bean>
   <bean id="userDao" class="xxx.UserDao"></bean>
   ```

2. 设值函数

   用 setter 来注入。

   ```xml
   <bean id="userService" class="xxx.UserService" scope="singleton">
       <property name="userDao" ref="userDao"><poroperty>
   </bean>
   <bean id="userDao" class="xxx.UserDao"></bean>
   ```
   
   简单静态直接注入值：
   
   ```java
   public class Student {
       private String name;
       private int age;
       private String[] address;
   }
   ```
   
   ```xml
   <bean id="student" class="xxx.Student">
   	<property name="name" value="张三"></property>
       <property name="age" value="10"></property>
       <property name="address" value="10">
       	<list>
           	<value>福州</value>
               <value>厦门</value>
           </list>
       </property>
   </bean>
   ```
   
3. 注解

注入类型：

1. 普通类型数据
2. 容器中的bean
3. 集合数据

## AOP 的应用

当Bean实现了代理接口时，Spring就会使用JDK的动态代理

没有实现接口时，Spring会使用CGLib实现。

也可以强制使用CGLib。

术语：

* Aspect
* Join point
* Advice
* Pointcut（多个连接点，比如所有的set方法）
* Introduction（动态添加新方法或属性）
* Weaving（？）

通知类型注解。

## Spring Cache

> https://docs.spring.io/spring/docs/current/spring-framework-reference/integration.html#cache

缓存（Caching）可以存储经常会用到的信息，这样每次需要的时候，这些信息都是立即可用的。

启用缓存：

```
@Configuration
@ComponentScan
@EnableCaching  // 启用缓存
public class SpringConfig {
    // 声明缓存管理器
    @Bean
    public CacheManager cacheManager(){
        return new ConcurrentMapCacheManager();
    }
}
```

Spring 内置的缓存管理器：

* SimpleCacheManager
* NoOpCacheManager
* ConcurrentMapCacheManager
* CompositeCacheManager
* EhCacheCacheManager

Spring Data 提供的：

* RedisCacheManager
* GemfireCacheManager

### 缓存规则

| 注解        | 描述                                                         |
| ----------- | ------------------------------------------------------------ |
| @Cacheable  | 表明Spring在调用方法之前，首先应该在缓存中查找方法的返回值。如果这个值能够找到，就会返回缓存的值。否则的话，这个方法就会被调用，返回值会放到缓存之中 |
| @CachePut   | 表明Spring应该将方法的返回值放到缓存中。在方法的调用前并不会检查缓存，方法始终都会被调用 |
| @CacheEvict | 表明Spring应该在缓存中清除一个或多个条目                     |
| @Caching    | 这是一个分组的注解，能够同时应用多个其他的缓存注解           |

