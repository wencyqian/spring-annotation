package com.atguigu.config;

import com.atguigu.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

/**
 * Description:
 *
 * @Author: qianwenqian
 * @Date: 2021/8/3 22:29
 */
//配置类==配置文件
@Configuration       //告诉spring这是一个配置类
@ComponentScan(value = "com.atguigu",includeFilters = {
//        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class, Service.class})
        @ComponentScan.Filter(type = FilterType.CUSTOM,classes = {MyTypeFilter.class})
},useDefaultFilters = false)
// @ComponentScan(value="指定要扫描的包")
// excludeFilters = Filter[] ， 指定扫描的时候按照什么规则排除哪些组件
// includeFilters = Filter[]，  指定扫描的时候需要包含哪些组件
public class MainConfig {

    //给容器中注册一个bean;类型为返回值的类型；id默认是方法名作为id
    @Bean(name = "person")
    public Person person01(){
        return new Person("lisi",20);
    }
}
