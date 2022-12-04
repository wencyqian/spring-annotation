package com.atguigu.condition;

import com.atguigu.bean.RainBow;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * Description:
 *
 * @Author: qianwenqian
 * @Date: 2021/11/22 14:04
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    /**
     *
     * @param importingClassMetadata 当前类的注解信息
     * @param registry BeanDefinition注册类；
     *                 把所有需要添加到容器中的bean：调用
     *                 BeanDefinitionRegistry.registerBeanDefinition手工注册进来
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        boolean definition = registry.containsBeanDefinition("com.atguigu.bean.Red");
        boolean definition2 = registry.containsBeanDefinition("com.atguigu.bean.Blue");
        if (definition && definition2){
            //
            RootBeanDefinition beanDefinition = new RootBeanDefinition(RainBow.class);
            // 注册一个Bean，指定bean名
            registry.registerBeanDefinition("rainBow",beanDefinition);
        }
    }
}
