package com.atguigu.bean;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Description:
 *
 * @Author: qianwenqian
 * @Date: 2021/11/24 15:28
 */
@Component
public class Dog {

    public Dog(){
        System.out.println("dog constructor...");
    }

    //对象创建并赋值之后调用
    @PostConstruct
    public void init(){
        System.out.println("dog...@PostConstruct...");
    }

    //容器移除对象之前调用
    @PreDestroy
    public void destory(){
        System.out.println("dog...@PreDestroy...");
    }
}
