package com.brownbag;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * User: Juan
 * Date: 7/19/2014
 */
@Configuration
@ComponentScan
@EnableAutoConfiguration
public class MainApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(MainApplication.class, args);
    }

}
