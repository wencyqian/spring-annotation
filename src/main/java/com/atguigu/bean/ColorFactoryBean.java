package com.atguigu.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * Description:
 *      创建一个Spring定义的FactoryBean
 * @Author: qianwenqian
 * @Date: 2021/11/22 14:45
 */
public class ColorFactoryBean implements FactoryBean<Color> {

    //返回一个Color对象，这个对象会添加到容器中
    @Override
    public Color getObject() throws Exception {
        System.out.println("ColorFactoryBean...getObject()");
        return new Color();
    }

    //返回对象的类型
    @Override
    public Class<?> getObjectType() {
        return Color.class;
    }

    //是否单列？
    // true;这个Bean是单实例，在容器中保存一份
    // false: 多实例，每次获取都会创建一个新的bean
    @Override
    public boolean isSingleton() {
        return true;
    }
}
