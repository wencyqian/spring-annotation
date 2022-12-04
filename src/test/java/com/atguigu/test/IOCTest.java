package com.atguigu.test;

import com.atguigu.bean.Person;
import com.atguigu.config.MainConfig;
import com.atguigu.config.MainConfig2;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Map;

/**
 * Description:
 *
 * @Author: qianwenqian
 * @Date: 2021/9/28 9:19
 */
public class IOCTest {

    //ioc容器
    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);

    @Test
    public void testImport(){
        printBeans(applicationContext);

        // 工厂bean获取的是调用getObject创建的对象
        Object colorFactoryBean = applicationContext.getBean("colorFactoryBean");
        Object colorFactoryBean2 = applicationContext.getBean("colorFactoryBean");
        System.out.println("bean的类型："+colorFactoryBean.getClass());
        System.out.println(colorFactoryBean == colorFactoryBean2);
        Object bean4 = applicationContext.getBean("&colorFactoryBean");
        System.out.println(bean4.getClass());
    }

    private void printBeans(AnnotationConfigApplicationContext applicationContext){
        String[] definitionNames = applicationContext.getBeanDefinitionNames();
        for (String name : definitionNames) {
            System.out.println(name);
        }
    }

    @Test
    @SuppressWarnings("resource")
    public void test03() {
        String[] namesForType = applicationContext.getBeanNamesForType(Person.class);
        //动态获取环境变量的值：Windows 10
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        String property = environment.getProperty("os.name");
        System.out.println("环境" + property);
        for (String name : namesForType) {
            System.out.println(name);
        }
        Map<String, Person> beansOfType = applicationContext.getBeansOfType(Person.class);
        System.out.println(beansOfType);
    }

    @Test
    @SuppressWarnings("resource")
    public void test02(){
        // IOC容器，根据主配置类的配置
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
        String[] definitionNames = applicationContext.getBeanDefinitionNames();
        for (String name : definitionNames) {
            System.out.println(name);
        }
        Object person1 = applicationContext.getBean("person");
        Object person2 = applicationContext.getBean("person");
        System.out.println(person1 == person2);
    }

    @Test
    @SuppressWarnings("resource")
    public void test01(){
        // IOC容器，根据主配置类的配置
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] definitionNames = applicationContext.getBeanDefinitionNames();
        for (String name : definitionNames) {
            System.out.println(name);
        }
    }
}
