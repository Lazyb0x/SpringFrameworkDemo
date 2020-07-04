# Spring 笔记

## AOP 动态代理

两种代理方式:

* JDK的动态代理，通过实现InvocationHandler来实现

* CGLib动态代理，使用字节码技术，比Java反射效率高

  实现MethodInterceptor接口。

## IoC 控制反转

```
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