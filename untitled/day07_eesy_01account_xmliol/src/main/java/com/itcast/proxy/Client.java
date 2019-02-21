package com.itcast.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// 模拟一个消费者
public class Client {
    public static void main(String[] args) {

        final   Producer producer=new Producer();

        // 创建代理对象
         IProducer proxyProducer =(IProducer)Proxy.newProxyInstance(producer.getClass().getClassLoader(),
                producer.getClass().getInterfaces(),
                new InvocationHandler() {
                    /**
                     * @param proxy
                     * @param method
                     * @param args
                     * @return
                     * @throws Throwable
                     */
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //提供增强的代码
                        Object returnValue = null;

                        // 1 获取方法执行的参数
                        Double money = (Double) args[0];
                        // 判断当前方法是不是销售
                        if ("saleProducer".equals(method.getName())) {
                            returnValue = method.invoke(producer, money*0.8);
                        }
                        return returnValue;
                    }

                });
        proxyProducer.saleProducer(10000.0);

    }
}
