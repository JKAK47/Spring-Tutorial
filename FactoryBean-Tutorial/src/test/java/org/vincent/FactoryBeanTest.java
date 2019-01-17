package org.vincent;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;
import org.vincent.factorybean.bean.Car;
import org.vincent.factorybean.bean.Person;

/**
 * Unit test for simple App.
 * Spring-test 基于配置文件自动启动 Spring java 程序，自动启动 ApplicationContext
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:FactoryBean-Config.xml"})
public class FactoryBeanTest {


    @Autowired
    private Person person;

    @Test
    public void testFactoryBean() {
        Car car = person.getCar();
        Assert.notNull(car,"car must not null");
    }

}
