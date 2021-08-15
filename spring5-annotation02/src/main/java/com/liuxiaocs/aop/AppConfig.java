package com.liuxiaocs.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "com.liuxiaocs.aop")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AppConfig {


}
