package com.example.demo.WebSocket.server;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * @CliassName: Payload
 * @Author: DZ5343
 * @Date: 2019/12/19 16:55
 * @Description:
 */
@Data
@ToString
@RequiredArgsConstructor
public class Payload {
    private String from;
    private String to;
    private String content;
}
