package com.liuxiaocs.life;


public class Product {

    // 创建对象的时候会调用构造方法，默认调用的是无参构造方法
    public Product() {
        // 如果对象被调用了，会调用这个无参，执行这句话
        System.out.println("Product.Product");
    }
}
