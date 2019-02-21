package com.itcast.cglib;

import com.itcast.proxy.IProducer;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// 模拟一个消费者
public class Client {
    public static void main(String[] args) {

      final Producer producer=new Producer();

      // 子类的动态代理

     /*   Producer  cgilbProducer=(Producer) Enhancer.create(producer.getClass(), new MethodInterceptor() {
            *//**
             *
             * @param proxy
             * @param method
             * @param args
             * @param methodProxy
             * @return
             * @throws Throwable
             *//*
                    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {

                        // 获取方法执行的参数
                        Double money = (Double) args[0];
                        // 2 判断当前方法是不是销售
                        if ("saleProducer".equals(method.getName())) {


                        }


                    }
                });

        cgilbProducer.saleProducer(12000.0);*/

    }
}

























