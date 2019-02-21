package com.itcast.proxy;
// 生产者
public class Producer implements IProducer {

    /**
     * 销售
     * @param money
     */
    public void saleProducer(Double money) {
        System.out.println("销售产品,拿到钱"+money);
    }

    /**
     * 售后
     * @param money
     */
    public void afterProducer(Double money) {
        System.out.println("提供售后服务，并拿到钱"+money);
    }
}
