package com.atguigu.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * Description:
 *          判断是否是Windows系统
 * @Author: qianwenqian
 * @Date: 2021/11/16 10:11
 */
public class WindowsCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        //  判断是否Windows系统
        // 3、获取当前环境信息
        Environment environment = context.getEnvironment();

        String property = environment.getProperty("os.name");
        if (property.contains("Windows")) {
            return true;
        }
        return false;
    }
}
