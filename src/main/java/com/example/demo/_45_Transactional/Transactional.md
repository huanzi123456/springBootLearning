##Spring Boot入门教程(四十五): 事务@Transactional

###1.介绍
在Spring中事务可以通过两种方式来管理，一种是编程式事务另一种是声明式事务

声明式事务：@Transactional 在方法的开头开始事务，在方法的结束提交事务

编程式事务：TransactionTemplate或者PlatformTransactionManager

声明式事务和编程式事务的区别：声明式事务开始事务和提交事务都是固定的，不够灵活，而编程式事务通过代码在想要的地方开始事务，在想要的地方提交事务，更加灵活。

###2.声明式事务
声明式事务：通过AOP对目标方法进行拦截，在方法的开始出开始事务(或者加入事务)，在方法结束时提交事务，当发生异常时回滚事务， 可以通过@Transactional来实现

@Transactional注解在Service类上表示所有public方法都使用了事务

@Transactional注解在方法上表示该方法使用注解，方法级别的注解会覆盖类级别的注解

###3.事务传播行为
所谓事务的传播行为是指，如果在开始当前事务之前，一个事务上下文已经存在，此时有若干选项可以指定一个事务性方法的执行行为。事务的传播行为，默认值为 Propagation.REQUIRED。
Propagation.REQUIRED： 如果当前存在事务，则加入该事务，如果当前不存在事务，则创建一个新的事务。

Propagation.SUPPORTS： 如果当前存在事务，则加入该事务；如果当前不存在事务，则以非事务的方式继续运行。

Propagation.MANDATORY 如果当前存在事务，则加入该事务；如果当前不存在事务，则抛出异常。

Propagation.REQUIRES_NEW 重新创建一个新的事务，如果当前存在事务，暂停当前的事务。

Propagation.NOT_SUPPORTED 以非事务的方式运行，如果当前存在事务，暂停当前的事务。

Propagation.NEVER 以非事务的方式运行，如果当前存在事务，则抛出异常。

Propagation.NESTED 和 Propagation.REQUIRED 效果一样。
###4.事务超时
事务超时就是指一个事务所允许执行的最长时间，如果超过该时间限制但事务还没有完成，则自动回滚事务。在 TransactionDefinition 中以 int 的值来表示超时时间，其单位是秒。 
默认设置为底层事务系统的超时值，如果底层数据库事务系统没有设置超时值，那么就是none，没有超时限制。
###5.事务隔离级别
隔离级别是指若干个并发的事务之间的隔离程度。TransactionDefinition 接口中定义了五个表示隔离级别的常量：
Isolation.DEFAULT 使用底层数据库默认的隔离级别。
Isolation.READ_UNCOMMITTED
Isolation.READ_COMMITTED
Isolation.REPEATABLE_READ
Isolation.SERIALIZABLE

###注意 
@Transactional用来类上，不要用来接口上，声明在接口上可能注解会无效
@Transactional一般用在方法上，对于查询方法不需要使用事务，如果用在类上，对查询方法的性能有影响
@Transactional 注解只能应用到 public 可见度的方法上。 如果你在 protected、private 或者 package-visible 的方法上使用 @Transactional 注解，它也不会报错， 但是这个被注解的方法将不会展示已配置的事务设置

https://blog.csdn.net/vbirdbest/article/details/82313903



