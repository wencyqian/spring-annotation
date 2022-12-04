package com.atguigu;

import com.atguigu.bean.Person;
import com.atguigu.config.MainConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Description:
 *
 * @Author: qianwenqian
 * @Date: 2021/8/3 22:19
 */
public class MainTest {
    public static void main(String[] args) {
        // 配置的方式
        //返回IOC容器
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
//        //applicationContext容器中有组件
//        Person bean = (Person) applicationContext.getBean("person");
//        System.out.println(bean);

        //返回一个IOC容器
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        Person bean = applicationContext.getBean(Person.class);//通过类型获取
        System.out.println(bean);

        String[] beanNamesForType = applicationContext.getBeanNamesForType(Person.class);
        for(String name:beanNamesForType){
            System.out.println(name);
        }
    }
}
