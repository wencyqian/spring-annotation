package com.atguigu.test;

import com.atguigu.config.MainConfigOfLifeCycle;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Description:
 *
 * @Author: qianwenqian
 * @Date: 2021/11/23 14:58
 */
public class IOCTest_LifeCycle {

    @Test
    public void test01(){
        // 1、创建ioc容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
        System.out.println("容器创建完成");

//        applicationContext.getBean("car");
        //关闭容器
        applicationContext.close();
    }
}
