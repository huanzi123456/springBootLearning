package com.example.demo.WebSocket.config;

/**
 * @CliassName: WebSocketConfiguration
 * @Author: DZ5343
 * @Date: 2019/12/19 16:53
 * @Description:
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * 开启WebSocket支持
 */
@Configuration
public class WebSocketConfiguration {

    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}
