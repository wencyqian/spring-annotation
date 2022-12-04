package com.atguigu.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * Description:
 *      后置处理器：初始化前后进行工作
 *          将后置处理器加入到容器中
 *          主要负责数据库的设计
 * 后端接口开发、与前端联调
 * 测试、部署系统
 * @Author: qianwenqian
 * @Date: 2021/11/24 15:38
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitialization..."+beanName+"=>"+bean);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization..."+beanName+"=>"+bean);
        return bean;
    }
}
