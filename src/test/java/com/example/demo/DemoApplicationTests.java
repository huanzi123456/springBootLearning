package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
		Person person = new Person();
		Date a = person.getA();
		System.out.println(a);
	}

}
