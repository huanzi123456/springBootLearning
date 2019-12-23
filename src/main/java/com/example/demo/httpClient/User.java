package com.example.demo.httpClient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;


@Data
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
public class User {
    private Long id;
    private String username;
}
