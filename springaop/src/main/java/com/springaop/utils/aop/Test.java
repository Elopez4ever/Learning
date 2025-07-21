package com.springaop.utils.aop;

import com.springaop.utils.Cal;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring-aop.xml");
        Cal callImpl = (Cal) classPathXmlApplicationContext.getBean("calImpl");
        callImpl.add(1, 1);
        callImpl.sub(1, 1);
        callImpl.mul(1, 1);
        callImpl.div(1, 0);
    }
}
