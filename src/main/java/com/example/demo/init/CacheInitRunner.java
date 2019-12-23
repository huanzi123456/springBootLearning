package com.example.demo.init;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @CliassName: CommandLineRunner
 * @Author: DZ5343
 * @Date: 2019/12/21 16:19
 * @Description:
 */
@Order(1)
@Component
public class CacheInitRunner  implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("load cache ..." + Arrays.asList(args));
    }
}
