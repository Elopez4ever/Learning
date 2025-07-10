package com.springioc.ioc;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ClassPathXmlContextApplication implements ApplicationContext{

    private Map<String, Object> ioc = new HashMap<>();

    public ClassPathXmlContextApplication(String path) {
        try {
            SAXReader reader = new SAXReader();
            Document document = reader.read(path);
            Element rootElement = document.getRootElement();
            Iterator<Element> elementIterator = rootElement.elementIterator();
            System.out.println(elementIterator);
            while (elementIterator.hasNext()) {
                // 获取每一个 Bean
                Element next = elementIterator.next();
                String id = next.attributeValue("id");
                String s = next.attributeValue("class");
                Class<?> aClass = Class.forName(s);
                Constructor<?> constructor = aClass.getConstructor();
                Object o = constructor.newInstance();
                Iterator<Element> elementIterator1 = next.elementIterator();
                // 获取每一个 Bean 的属性
                while (elementIterator1.hasNext()) {
                    Element next1 = elementIterator1.next();
                    String propertyName = next1.attributeValue("name");
                    String propertyValue = next1.attributeValue("value");
                    String refName = next1.attributeValue("ref");
                    if (refName == null) {  // 说明该属性为 String 类型或者基本数据类型
                        // 获取方法名
                        String methodName = "set" + propertyName.substring(0, 1).toUpperCase() + propertyName.substring(1).toLowerCase();
                        Field field = aClass.getDeclaredField(propertyName);
                        Method declaredMethod = aClass.getDeclaredMethod(methodName, field.getType());
                        declaredMethod.invoke(o, convertType(propertyValue, field.getType()));
                    } else {

                    }
                }
                ioc.put(id, o);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Object getBean(String id) {
        return ioc.get(id);
    }

    private Object convertType(String value, Class<?> type) {
        if (type == int.class || type == Integer.class) return Integer.valueOf(value);
        if (type == long.class || type == Long.class) return Long.valueOf(value);
        if (type == double.class || type == Double.class) return Double.valueOf(value);
        if (type == boolean.class || type == Boolean.class) return Boolean.valueOf(value);
        // 你还可以按需加更多类型
        return value; // 默认就是String
    }

}
