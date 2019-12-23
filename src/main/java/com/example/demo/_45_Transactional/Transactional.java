package com.example.demo._45_Transactional;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Transactional {
    // 当配置了多个事务管理器时，可以使用该属性指定使用哪个事务管理器
    @AliasFor("transactionManager")
    String value() default "";

    // 事务传播级别
//    Propagation propagation() default Propagation.REQUIRED;

    // 设置是否只读事务，true表示只读事务(一般查询设置为true)，false表示读写事务
    boolean readOnly() default false;

    // 指定哪些异常类型需要回滚事务，例如@Transactional(rollbackFor={RuntimeException.class, Exception.class})
    Class<? extends Throwable>[] rollbackFor() default {};
    // 例如@Transactional(rollbackForClassName={“RuntimeException”,”Exception”})
    String[] rollbackForClassName() default {};

    // 指定当抛出哪些异常时不需要回滚事务
    Class<? extends Throwable>[] noRollbackFor() default {};
    String[] noRollbackForClassName() default {};

    // 该属性用于设置底层数据库的事务隔离级别，事务隔离级别用于处理多事务并发的情况，通常使用数据库的默认隔离级别即可，基本不需要进行设置
//    Isolation isolation() default Isolation.DEFAULT;

    // 设置事务的超时秒数，默认值为-1表示永不超时
//    int timeout() default TransactionDefinition.TIMEOUT_DEFAULT;
}
