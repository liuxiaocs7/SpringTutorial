package com.liuxiaocs;

import com.liuxiaocs.basic.*;
import com.liuxiaocs.constructor.Customer;
import com.liuxiaocs.factorybean.ConnectionFactoryBean;
import com.liuxiaocs.life.Product;
import com.liuxiaocs.scope.Account;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @author liuxiaocs
 * @date 2021/3/16 18:48
 */
public class TestSpring {

    /**
     * 用于测试：工厂类进行解耦合的操作
     */
    @Test
    public void test1() {
        // 1. 硬编码，存在耦合，程序的维护性非常差
        // 将 UserService 接口的实现类 UserServiceImpl 硬编码在程序中
        // 如果想换掉实现类 UserServiceImpl，那么调用者(测试类)的程序也需要改动

        // 使用一个新的实现类 UserServiceImplNew()
        // UserService userService = new UserServiceImplNew()
        // 如果修改成上面的源代码，需要重新编译和部署，不符合开闭原则(打开扩展，关闭修改)
        // UserService userService = new UserServiceImpl();

        // 2.使用工厂类创建对象
        // 这段代码里面没有耦合，因为UserService这个接口的实现类在这段代码中没有任何体现
        // 通过工厂类的工厂方法创建这个对象之后可以彻底解决这里的耦合，但是在BeanFactory中又有耦合了，相当于耦合转移了
        // UserService userService = BeanFactory.getUserService();
        // 2.1 在BeanFactory中直接返回对象  return new UserServiceImpl();
        // 2.2 通过反射的方式返回对象 Class clazz = Class.forName("com.liuxiaocs.basic.UserServiceImpl");

        // 3.使用通用工厂方法获取(强转)
        UserService userService = (UserService) BeanFactory.getBean("userService");

        userService.login("name", "liuxiaocs");

        User user = new User("liuxiaocs", "123456");
        userService.register(user);
    }

    /**
     * 用于测试通用工厂创建对象
     */
    @Test
    public void test2() {
        Person person = (Person) BeanFactory.getBean("person");
        System.out.println("person = " + person);
    }

    /**
     * 用于测试：用于测试Spring的第一个程序
     */
    @Test
    public void test3() {
        // 1. 获得Spring的工厂 (指定配置文件的路径)
        // ApplicationContext是一个接口无法实例化，使用其具体实现类ClassPathXmlApplicationContext来进行实例化
        ApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext.xml");
        // 2. 通过工厂类 获得 对象 person就是在配置文件里面给bean声明的id
        // 可以看出这里和我们写的其实是差不多的，根据id获取对象然后进行强转即可
        Person person = (Person) context.getBean("person");
        System.out.println("Person = " + person);
    }

    /**
     * 用于测试：Spring工厂提供的其他方法
     */
    @Test
    public void test4() {
        // 1. 获得Spring的工厂，指定文件的路径
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        // 使用这种方式[同时指定id和类型]不需要进行强转，省略了强转的过程
        // Person person = ctx.getBean("person", Person.class);
        // System.out.println("Person = " + person);

        // 以下这种方法只能有一个bean标签是Person类型的，如果有多个就会抛出异常，因为不知道具体是哪一个Person
        // org.springframework.beans.factory.NoUniqueBeanDefinitionException: No qualifying bean of type 'com.liuxiaocs.basic.Person' available: expected single matching bean but found 2: person,person1
        // 当前Spring的配置文件中只能有一个bean class是Person类型
        // Person person = ctx.getBean(Person.class);
        // System.out.println("Person = " + person);

        // 配置文件中声明的就是bean
        // 获取的是Spring工厂配置文件中所有bean标签的id值：person、person1
        // 不能判断name值
        // getBeanDefinitionNames() 方法获取bean定义的名字，也就是配置文件中所有bean对应的id
        /*String[] beanDefinitionNames = ctx.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println("beanDefinitionName = " + beanDefinitionName);
        }*/

        // getBeanNamesForType() 是根据类型获取bean的名字
        // 获取工厂中Person类型的所有bean的id值
        // 根据类型获得Spring配置文件中对应的id值
        // 可以判断name值
        String[] beanNamesForType = ctx.getBeanNamesForType(Person.class);
        for (String id : beanNamesForType) {
            System.out.println("id = " + id);
        }

        // containsBeanDefinition()方法判断Spring工厂中有没有这个名字的bean
        // 有没有对应id的bean存在于Spring工厂中
        // 用于判断是否存在指定id值的bean，不能判断name值
        if (ctx.containsBeanDefinition("person2")) {
            System.out.println("true = " + true);
        } else {
            System.out.println("false = " + false);
        }

        // 用于判断是否存在指定id值的bean，也可以判断name值
        if (ctx.containsBean("person")) {
            System.out.println("true = " + true);
        } else {
            System.out.println("false = " + false);
        }
    }

    /**
     * 用于测试：用于测试获取没有id属性的bean
     * Spring配置文件中只声明 <bean class="com.liuxiaocs.basic.Person"/> 是可以完成对象的创建的
     * 这种语法Spring是认可的
     * 这种配置Spring会提供一个默认的id com.liuxiaocs.basic.Person#0
     */
    @Test
    public void test5() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Person bean = ctx.getBean(Person.class);
        System.out.println(bean);
        // 获取bean的名字
        String[] beanDefinitionNames = ctx.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println("beanDefinitionName" + beanDefinitionName);
        }
    }

    /**
     * 用于测试：用于测试name属性
     * id是bean的大名，name是bean的别名
     * 通过大名和别名都可以获得这个对象
     */
    @Test
    public void test6() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Person p = (Person) ctx.getBean("p");
        System.out.println("Person" + p);
    }

    /**
     * 用于测试：用于测试注入
     */
    @Test
    public void test7() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Person person = (Person) ctx.getBean("person");

        // 这种赋值是通过代码来完成的，这不是注入(注入是通过配置文件来赋值)
        // 这种写法可以达到效果，但是存在耦合
        // 如果以后这个person的名字不想叫suns了，要修改的话很麻烦，必须在代码文件中修改，需要重新编译部署
        person.setId(1);
        person.setName("suns");

        System.out.println(person);
    }

    /**
     * 用于测试：通过Spring的配置文件来进行赋值(注入)
     */
    @Test
    public void test8() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Person person = (Person) ctx.getBean("person");
        System.out.println("person = " + person);
    }

    /**
     * 用于测试：JDK类型成员变量的赋值
     */
    @Test
    public void test9() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Person person = (Person) ctx.getBean("person");
        String[] emails = person.getEmails();
        for (String email : emails) {
            System.out.println("email = " + email);
        }

        System.out.println("========================");
        Set<String> tels = person.getTels();
        for (String tel : tels) {
            System.out.println("tel = " + tel);
        }

        System.out.println("========================");
        List<String> addresses = person.getAddresses();
        for (String address : addresses) {
            System.out.println("Address = " + address);
        }

        System.out.println("========================");
        Map<String, String> qqs = person.getQqs();
        Set<String> keys = qqs.keySet();
        for (String key : keys) {
            System.out.println("key = " + key + " value is " + qqs.get(key));
        }

        System.out.println("========================");
        Properties p = person.getP();
        System.out.println("key is key1" + " values is " + p.getProperty("key1"));
        System.out.println("key is key2" + " values is " + p.getProperty("key2"));
    }

    /**
     * 用于测试：用户自定义类型成员变量的赋值
     */
    @Test
    public void test10() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        UserService userService = (UserService) ctx.getBean("userService");
        userService.register(new User("liuxiaocs", "123456"));
        userService.login("xiaohei", "999999");
    }

    /**
     * 用于测试：用于测试构造注入
     */
    @Test
    public void test11() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Customer customer = (Customer) ctx.getBean("customer");
        System.out.println(customer);
    }

    /**
     * 用于测试：用于测试FactoryBean接口
     * 获取多次检测是否是单例的
     */
    @Test
    public void test12() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Connection conn = (Connection) ctx.getBean("conn");
        Connection conn2 = (Connection) ctx.getBean("conn");
        System.out.println("conn = " + conn);
        System.out.println("conn2 = " + conn2);
    }

    /**
     * 用于测试：用于测试FactoryBean接口
     */
    @Test
    public void test13() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        // 不加&获取的是复杂对象
        // 加上&获取的是ConnectionFactoryBean对象
        ConnectionFactoryBean conn = (ConnectionFactoryBean) ctx.getBean("&conn");
        // conn = com.liuxiaocs.factorybean.ConnectionFactoryBean@dd3b207
        System.out.println("conn = " + conn);
    }

    /**
     * 用于测试：用于测试实例工厂
     */
    @Test
    public void test14() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Connection conn = (Connection) ctx.getBean("conn");
        System.out.println("conn = " + conn);
    }

    /**
     * 用于测试：简单对象的创建次数
     */
    @Test
    public void test15() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Account account1 = (Account) ctx.getBean("account");
        Account account2 = (Account) ctx.getBean("account");
        System.out.println("Account1 = " + account1);
        System.out.println("Account2 = " + account2);
    }

    /**
     * 用于测试：演示声明周期
     */
    @Test
    public void test16() {
        // 这行代码执行完，Spring工厂就创建了
        // 如果是singleton单例对象的话，这行执行完对象应该就已经被创建了
        // 在控制台中得到了对应的输出：Product.Product(工厂创建的同时对象也被创建了)
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        // 如果对象是prototype的话工厂创建的时候不会创建对象
        // 快捷键.castvar
        // 获取对象的时候才会被创建
        // 懒加载也是之后获取对象的时候才会被创建
        Product product = (Product) ctx.getBean("product");

        // 显式关闭工厂
        ctx.close();
    }

    /**
     * 用于测试：配置文件参数化
     */
    @Test
    public void test17() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext1.xml");
        Connection conn = (Connection) ctx.getBean("conn");
        System.out.println("conn = " + conn);
    }
}
