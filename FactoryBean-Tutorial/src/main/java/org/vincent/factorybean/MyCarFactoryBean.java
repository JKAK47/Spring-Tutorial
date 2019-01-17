package org.vincent.factorybean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.util.StringUtils;
import org.vincent.factorybean.bean.Car;

/**
 * Package: org.vincent.factorybean
 * Created by PengRong on 2019/1/17.
 * ProjectName: Spring-Tutorial
 * @description : 实现 FactoryBean 接口，返现参数就是 通过 FactoryBean 工厂接口返回的类型实例类型
 * 创建实例通过 FactoryBean.getObject接口方法发创建类，接口参数通过 属性注入
 */
public class MyCarFactoryBean implements FactoryBean<Car> {
    private String make;
    private int year;

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public Car getObject() throws Exception {
        Car car = new Car();
        if (year != 0)
            car.setYear(this.year);
        if (StringUtils.hasText(this.make))
            car.setMake(this.make);
        return car;
    }

    /**
     * 创建类型对象类型
     * @return
     */
    @Override
    public Class<?> getObjectType() {
        return Car.class;
    }

    /**
     * 是否是单例模式，true : 单例模式，false: 非单例模式
     * 单例模式Spring 会将创建的对象引用缓存到Map中，下次使用再次取出，
     * 非单例模式每次都是新建对象
     * @return
     */
    @Override
    public boolean isSingleton() {
        return false;
    }
}
