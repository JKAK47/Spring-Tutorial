# Spring-Tutorial 系列
#  FactoryBean Demo
**FactoryBean 是具有特定功能的一个Bean，用于在IOC容器中用于创建其他Bean， FactoryBean类似于工厂方法， 是Spring家族中一个用于创建其他Bean 的的接口。**

- FactoryBean ：是一个Java Bean 创建模式工厂接口类，它是一个能生产对象的工厂Bean，就是一个创建Java类的工厂接口。它的实现和工厂模式及修饰器模式很像。
    比如下：我们把bean比作是人，那么FactoryBean可以算是一个女人，首先它本身也是一个人，但它能够生产人。
- BeanFactory ：这就是一个Factory，是获取Bean的入口。
    是一个IOC容器或者叫对象工厂，它里面存着很多的bean。还用上面那个比如：如果bean是人，那么它可以理解成学校，学校里面很多人，学校管理这么多的人。

**BeanFactory就是Spring 里面的 IOC容器组件，实现了 依赖注入功能，对于一些 Java  类实例创建方式 是通过 FactoryBean.getObject()方法去创建对象。** 
    
## 获取bean 的流程：


AbstractBeanFactory.getBean (接口方法) -> org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean (无论是直接取单例的bean，还是创建单例、多例、自定义生命周期的bean 都会调用 getObjectForBeanInstance) -> 
org.springframework.beans.factory.support.AbstractBeanFactory.getObjectForBeanInstance (这里判定需要去的Bean 是否是FactoryBean类型，如果不是直接把beanInstance 返回) -> 
如果是 FactoryBean： 调用 org.springframework.beans.factory.support.FactoryBeanRegistrySupport.getObjectFromFactoryBean方法 去创建Bean或者从缓存获取Bean 
    - FactoryBean 工厂是单例模式，那么通过检查缓存是否保存有 FactoryBean 创建处理Java Bean 对象引用。 通过beanName从缓存中获取指定名称的Bean实例对象，如果缓存中没有，
        则需要  通过 FactoryBean，beanName 两个参数调用 doGetObjectFromFactoryBean 方法去真正创建Java Bean，创建(factory.getObject()创建)完了返回后，将对象引用放到缓存Map里面，等待下次再次请求时候直接从缓存里面返回。
    - FactoryBean 工厂类实现不是单例模式的话，就直接调用 doGetObjectFromFactoryBean 方法去创建Bean，并不会将创建后的Java Bean 放到缓存Map里面
如果不是 FactoryBean，则直接返回   
 
-> org.springframework.beans.factory.support.FactoryBeanRegistrySupport.doGetObjectFromFactoryBean    该方法很简单就是调用用 FactoryBean.getObject() 工厂的接口方法: getObject 方法生产指定Bean的实例对象 返回。 


[FactoryBean的实现原理与作用](https://blog.csdn.net/u013185616/article/details/52335864)

[Spring FactoryBean Example](https://howtodoinjava.com/spring-core/how-to-create-beans-using-spring-factorybean/)

[What's a FactoryBean?](https://spring.io/blog/2011/08/09/what-s-a-factorybean)
