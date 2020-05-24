package com.jhon.demo.proxy;

import lombok.Data;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@Data
public class DynamicPoxy implements InvocationHandler {

    private Object target;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //在代理真实对象前增强操作
        System.out.println("before rent house");
        System.out.println("Method:\t" + method);
        //当代理对象调用真实对象方法时，
        // 其会自动跳转到代理对象关联的handler对象的invoke方法来进行调用
        Object object = method.invoke(this.target, args);
        //代理后增强操作
        System.out.println("after rent house");
        return object;
    }

    public Object getProxyInstance() {
        Object obj =
                Proxy.newProxyInstance(
                        target.getClass().getClassLoader(),
                        target.getClass().getInterfaces(),
                        this::invoke
                );
        return obj;
    }
}
