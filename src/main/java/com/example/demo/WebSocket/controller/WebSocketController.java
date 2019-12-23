package com.example.demo.WebSocket.controller;

import com.example.demo.WebSocket.server.WebSocketServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @CliassName: WebSocketController
 * @Author: DZ5343
 * @Date: 2019/12/19 16:50
 * @Description:
 */
@Controller
@RequestMapping("/im")
public class WebSocketController {
    @Autowired
    private WebSocketServer webSocketServer;

    @RequestMapping("/users/{from}/{to}")
    public ModelAndView index(@PathVariable("from") String from, @PathVariable("to") String to){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("from", from);
        modelAndView.addObject("to", to);
        return modelAndView;
    }

    /**
     * 模拟服务器端向客户端推送消息
     * @param userId
     * @param message
     */
    @ResponseBody
    @RequestMapping("/push/{userId}")
    public void mockPushMessageToClient(@PathVariable String userId, String message) {
        webSocketServer.sendMessage(userId, message);
    }
}
