package com.langlang.test;

import cn.hutool.core.util.ReflectUtil;
import com.langlang.utils.ReflectUtils;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.ReflectionUtils;

import java.util.Arrays;
import java.util.Set;

public class ReflectUtilsTest {

    public static void main(String[] args) {
        Class annotationConfigApplicationContextClass = AnnotationConfigApplicationContext.class;
        Set<Class> superClassGenericType = ReflectUtils.getSuperClassAndInterfaces(annotationConfigApplicationContextClass);

        System.out.println(Arrays.asList(superClassGenericType));
    }


    @Test
    public void test01() {
        Class annotationConfigApplicationContextClass = AnnotationConfigApplicationContext.class;
        Set<Class> allSuperClass = ReflectUtils.getAllSuperClass(annotationConfigApplicationContextClass);

        System.out.println(Arrays.asList(allSuperClass));
    }


    @Test
    public void test02() {
        Class annotationConfigApplicationContextClass = AnnotationConfigApplicationContext.class;
        Set<Class> allSuperClass = ReflectUtils.getAllSuperInterfaces(annotationConfigApplicationContextClass);

        System.out.println(Arrays.asList(allSuperClass));

    }

    @Test
    public void test03() {

        Class annotationConfigApplicationContextClass = AnnotationConfigApplicationContext.class;
        Set<Class> superClassGenericType = ReflectUtils.getSuperClassAndInterfaces(annotationConfigApplicationContextClass);
        Set<Class> allSuperClass = ReflectUtils.getAllSuperInterfaces(annotationConfigApplicationContextClass);

        System.out.println(superClassGenericType.size());
        System.out.println(allSuperClass.size());

        boolean b = superClassGenericType.containsAll(allSuperClass);
        System.out.println(b);


    }

    @Test
    public void test04() {
        Class annotationConfigApplicationContextClass = AnnotationConfigApplicationContext.class;
        boolean ref = ReflectUtils.getRef(annotationConfigApplicationContextClass);

    }
}
