##Spring Boot入门教程(四十六): @Async
**一：简介** 
`ThreadPoolTaskExecutor` 用于定义线程池，是对java.util.concurrent.ThreadPoolExecutor类的包装。可以通过@EnableAsync来开启异步支持，通过@Async来声明一个异步方法

注意：异步方法的调用和异步方法的声明必须不能在同一个类中，如果在同一个类中则变成了同步方法