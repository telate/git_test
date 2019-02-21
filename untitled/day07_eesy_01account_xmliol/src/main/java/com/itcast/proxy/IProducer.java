package com.itcast.proxy;



// 对生产厂家要求的接口
public interface IProducer {


    /**
     * 销售
     */
    void saleProducer(Double money);

    /**
     * 售后
     */
    void afterProducer(Double money);

}
