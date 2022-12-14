package com.atguigu.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * Description:
 *          判断是否是Linux系统
 * @Author: qianwenqian
 * @Date: 2021/11/16 10:11
 */
public class LinuxCondition implements Condition {

    /**
     *
     * @param context 判断条件能使用的上下文（环境）
     * @param metadata 注释信息
     * @return
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        //  判断是否Linux系统
        // 1、能获取到ioc使用的beanfactory(创建对象、装配工厂)
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        // 2、获取类加载器
        ClassLoader classLoader = context.getClassLoader();
        // 3、获取当前环境信息
        Environment environment = context.getEnvironment();
        // 4、获取到bean定义的注册类
        BeanDefinitionRegistry registry = context.getRegistry();

        String property = environment.getProperty("os.name");
        // 可以判断容器中的bean注册情况，也可以给容器中注册bean
        boolean person = registry.containsBeanDefinition("person");
        if (property.contains("Linux")) {
            return true;
        }
        return false;
    }
}
