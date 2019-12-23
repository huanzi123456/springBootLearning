package com.example.demo;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableDubbo
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		System.out.println("Application starting...");
		SpringApplication.run(DemoApplication.class, args);
		System.out.println("Application finish...");
	}




	/**************************************************https************************************************************/
	//todo https测试接口
	@RestController
	public class TestController {
		@RequestMapping(value = "/test", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		public String test() {
			return "hello https";
		}
	}
	//todo http重定向https
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
		}
		private Connector createTomcatConnector() {
			Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
			connector.setScheme("http");
			connector.setPort(8081);
			connector.setSecure(false);
			connector.setRedirectPort(8080);
			return connector;
		}
	}
	/**************************************************https************************************************************/
}
