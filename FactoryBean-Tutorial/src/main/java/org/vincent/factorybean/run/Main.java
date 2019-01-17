package org.vincent.factorybean.run;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Assert;
import org.vincent.factorybean.bean.Car;
import org.vincent.factorybean.bean.Person;

/**
 * Package: org.vincent.factorybean.run
 * Created by PengRong on 2019/1/17.
 * ProjectName: Spring-Tutorial
 * @description : 手动启动 Spring IOC容器 ，并手动获取Bean 实例引用
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("start Spring Container");
        ApplicationContext context = null;
        context = new ClassPathXmlApplicationContext("FactoryBean-Config.xml");
        Assert.notNull(context, "Spring Container context must not null.");

        Car car = (Car) context.getBean("car");
        System.out.println(car.getMake() + "\t" + car.getYear());

        Person person = (Person) context.getBean("person");
        System.out.println(person.toString());

        System.out.println("stop Spring Container");
    }

}
