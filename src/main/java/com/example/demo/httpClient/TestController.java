package com.example.demo.httpClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {

    @Autowired
    private HttpClient httpClient;

    @GetMapping("testGet")
    public String testGet() throws Exception {
        return httpClient.doGet("http://www.baidu.com");
    }

    @PostMapping("tesPost")
    public User tesPost() throws Exception {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", "1");
        paramMap.put("username", "mengda");
        HttpClient.HttpResponse httpResponse = httpClient.doPost("http://localhost:8081/doPost", paramMap);
        System.out.println(httpResponse);
        //todo ????? http转https请求! 这个会产生几个报错!
        User user = httpClient.doPost("http://localhost:8081/doPost", paramMap, User.class);
        return user;
    }

    @PostMapping("doPost")
    public User doPost(@RequestBody User user) {
        User newUser = new User(user.getId(), user.getUsername() + "y");
        return newUser;
    }
}
