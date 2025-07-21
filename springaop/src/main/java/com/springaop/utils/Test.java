package com.springaop.utils;

import com.springaop.utils.impl.CalImpl;

public class Test {
    public static void main(String[] args) {
        Cal cal = new CalImpl();
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler();

        Cal proxyCal = (Cal) myInvocationHandler.bind(cal);

        proxyCal.add(1, 1);
        proxyCal.sub(2, 1);
        proxyCal.mul(3, 2);
        proxyCal.div(4, 2);
    }
}
