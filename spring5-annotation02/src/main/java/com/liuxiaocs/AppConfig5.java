package com.liuxiaocs;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * 新增一个新的配置bean
 * 让AppConfig4和AppConfig5同时起作用
 */
@Configuration
@ImportResource("applicationContext.xml")
public class AppConfig5 {
}
