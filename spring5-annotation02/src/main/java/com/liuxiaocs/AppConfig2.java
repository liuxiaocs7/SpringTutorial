package com.liuxiaocs;

import com.liuxiaocs.bean.User;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
// @ComponentScan(basePackages = "com.liuxiaocs.scan",
//                excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = {Service.class}),
//                                  @ComponentScan.Filter(type = FilterType.ASPECTJ, pattern = {"com.liuxiaocs..*"})})
// @ComponentScan(basePackages = "com.liuxiaocs.scan",
//                useDefaultFilters = false,
//                includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = {Service.class})})
@ComponentScan(basePackages = "com.liuxiaocs.scan")
@Import({User.class})
public class AppConfig2 {
}
