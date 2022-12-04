package com.atguigu.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * Description:
 *          自定义逻辑返回需要导入的组件
 * @Author: qianwenqian
 * @Date: 2021/11/16 15:56
 */
public class MyImportSelector implements ImportSelector {

    /**
     *
     * @param importingClassMetadata 标注@Import注解的类的所有注解信息
     * @return 要导入到容器中的组件全类名
     */
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"com.atguigu.bean.Blue","com.atguigu.bean.Yellow"};
    }
}
