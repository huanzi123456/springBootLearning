package com.example.demo;

import com.example.demo.Async.config.AsyncTaskService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.Async;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.Future;

/**
 * @CliassName: SpringbootAsyncApplicationTests
 * @Author: DZ5343
 * @Date: 2019/12/23 15:20
 * @Description:
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class SpringbootAsyncApplicationTests {
    @Autowired
    private AsyncTaskService asyncTaskService;

    @Test
    public void testAsync() throws Exception {
        asyncTaskService.executeAsyncTask1();
        asyncTaskService.executeAsyncTask2("AsyncTask2");
        Future<String> future = asyncTaskService.executeAsyncTask3("AsyncTask3");
        String result = future.get();
        System.out.println("result=" + result);

        Thread.sleep(3000);
    }

    @Test
    public void testSync() throws Exception {
        test();
        for (int i = 0; i < 10; i++) {
            System.out.println("testSync = " + Thread.currentThread().getName() + "\t i=" + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) { }
        }
        Thread.sleep(3000);
    }

    /**
     * 注意：@Async要想异步，调用方法的代码和方法的声明必须在不同的类中才能异步，否则是同步
     * test(); 方法的调用在SpringbootAsyncApplicationTests这个类，方法的声明也是在这个类，所以该方法实际是同步方法，并不是异步
     */
    @Async
    public void test() {
        for (int i = 0; i < 10; i++) {
            System.out.println("SpringbootAsyncApplicationTests = " + Thread.currentThread().getName() + "\t i=" + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) { }
        }
    }
}
