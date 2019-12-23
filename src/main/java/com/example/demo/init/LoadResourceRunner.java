package com.example.demo.init;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @CliassName: LoadResourceRunner
 * @Author: DZ5343
 * @Date: 2019/12/21 16:20
 * @Description:
 */
@Order(2)
@Component
public class LoadResourceRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) {
        System.out.println("create thread loop " + args);
    }
}
