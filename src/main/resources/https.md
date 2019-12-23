###Spring Boot入门教程(五十七): HTTPS
    参考文档:https://blog.csdn.net/vbirdbest/article/details/100541052
   ```现在API接口一般要使用https协议，可以通过nginx反向代理实现，也可以让Spring Boot支持https协议。```
##1.证书的获取
    ```
    从第三方可信证书认证商购买
    从云服务器免费申请(免费1年)
    自己生成(仅用于开发测试，浏览器会提示不安全)
    ```
 使用jdk命令行工具生成证书文件(仅限于开发测试):
 
 keytool -genkey -alias tomcathttps -keyalg RSA -keysize 2048 -keystore /Users/mengday/Desktop/certificate.p12 -validity 365

 genkey :generate key 表示要创建一个新的密钥
 keystore :表示生成的密钥存放位置

    

##2..项目配置
1.证书文件certificate.p12放到resources目录下
2.在application.properties配置https

    ```
    server.ssl.key-store=classpath:certificate.p12
    server.ssl.key-alias=tomcathttps
    server.ssl.key-store-password=123456
    ```
key-store表示密钥文件名。
key-alias表示密钥别名。
key-store-password就是在cmd命令执行过程中输入的密码。 
    
##3.测试

    @RestController
    public class TestController {
    
        @RequestMapping(value = "/test", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
        public String test() {
            return "hello https";
        }
    }

```$xslt 
http协议访问
Bad Request
This combination of host and port requires TLS.
https协议访问(证书是自己生成的所以浏览器认为不安全)
```

##4.抓包查看(对比http与https的区别)
```
待以后补充
```

##5.http重定向到https
同时支持HTTP和HTTPS：HTTP重定向到HTTPS
访问http://localhost:8081/test 会直接重定向到https://localhost:8080/test
```$xslt
@Configuration
public class TomcatConfiguration {

    @Bean
    TomcatServletWebServerFactory tomcatServletWebServerFactory() {
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory(){
            @Override
            protected void postProcessContext(Context context) {
                SecurityConstraint constraint = new SecurityConstraint();
                constraint.setUserConstraint("CONFIDENTIAL");
                SecurityCollection collection = new SecurityCollection();
                collection.addPattern("/*");
                constraint.addCollection(collection);
                context.addConstraint(constraint);
            }
        };
        factory.addAdditionalTomcatConnectors(createTomcatConnector());
        return factory;
    }`__`
    private Connector createTomcatConnector() {
        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
        connector.setScheme("http");
        connector.setPort(8081);
        connector.setSecure(false);
        connector.setRedirectPort(8080);
        return connector;
    }
}
————————————————
版权声明：本文为CSDN博主「vbirdbest」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/vbirdbest/article/details/100541052
```
    
