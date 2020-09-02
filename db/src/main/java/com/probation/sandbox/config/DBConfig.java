package com.probation.sandbox.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
public class DBConfig {
    @Configuration
    @Profile("default")
    @PropertySource(value ={
            "classpath:db.properties"})
    static class DefaultProperties {}

    static class NonDefaultProperties {}
}
