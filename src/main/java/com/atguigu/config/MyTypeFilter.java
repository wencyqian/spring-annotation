package com.atguigu.config;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;
import java.util.Set;

/**
 * Description:
 *
 * @Author: qianwenqian
 * @Date: 2021/9/28 10:30
 */
public class MyTypeFilter implements TypeFilter{

    /**
     *
     * @param metadataReader 读取到的当前正在扫描的类信息
     * @param metadataReaderFactory 可以获取到其他任何类信息的
     * @return
     * @throws IOException
     */
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        // 获取当前类注解的信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        Set<String> annotationTypes = annotationMetadata.getAnnotationTypes();
        for (String type : annotationTypes) {
            System.out.println("注解信息:"+type);
        }
        // 获取当前正在扫描的类的类信息
        ClassMetadata classMetadata = metadataReader.getClassMetadata();

        // 获取当前类资源(类路径)
        Resource resource = metadataReader.getResource();

        String className = classMetadata.getClassName();
        System.out.println("--->" +className);
        return false;
    }
}
