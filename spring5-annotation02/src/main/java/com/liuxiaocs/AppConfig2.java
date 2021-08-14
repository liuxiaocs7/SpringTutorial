package com.liuxiaocs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Service;

@Configuration
// @ComponentScan(basePackages = "com.liuxiaocs.scan",
//                excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = {Service.class}),
//                                  @ComponentScan.Filter(type = FilterType.ASPECTJ, pattern = {"com.liuxiaocs..*"})})
@ComponentScan(basePackages = "com.liuxiaocs.scan",
               useDefaultFilters = false,
               includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = {Service.class})})
public class AppConfig2 {
}
