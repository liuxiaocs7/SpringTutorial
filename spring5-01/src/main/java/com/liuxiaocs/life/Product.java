package com.liuxiaocs.life;


import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Product implements InitializingBean, DisposableBean {

    private String name;

    public void setName(String name) {
        // 快捷键soutm
        System.out.println("Product.setName");
        this.name = name;
    }

    // 创建对象的时候会调用构造方法，默认调用的是无参构造方法
    public Product() {
        // 如果对象被调用了，会调用这个无参，执行这句话
        System.out.println("Product.Product");
    }

    // 这个就是初始化方法：做一些初始化操作
    // Spring会进行调用
    public void afterPropertiesSet() throws Exception {
        // 初始化操作完成了
        System.out.println("Product.afterPropertiesSet");
    }

    public void myInit() {
        System.out.println("Product.myInit");
    }

    // 销毁方法：销毁操作(资源释放的操作)
    public void destroy() throws Exception {
        System.out.println("Product.destroy");
    }

    public void myDestroy() throws Exception {
        System.out.println("Product.myDestroy");
    }
}

// 自定义初始化方法
// public class Product {
//     public Product() {
//     }
//
//     public void myInit() {
//         System.out.println("Product.myInit");
//     }
// }
