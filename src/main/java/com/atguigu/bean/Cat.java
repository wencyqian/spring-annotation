package com.atguigu.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * Description:
 *
 * @Author: qianwenqian
 * @Date: 2021/11/23 16:53
 */
@Component
public class Cat implements InitializingBean, DisposableBean {

    public Cat(){
        System.out.println("cat constructor....");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("cat...destroy...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("cat...afterPropertiesSet...");
    }
}
