package com.manash.cfgs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages= {"com.manash.target","com.manash.aspects"})
@EnableAspectJAutoProxy
public class AppConfig {

}
