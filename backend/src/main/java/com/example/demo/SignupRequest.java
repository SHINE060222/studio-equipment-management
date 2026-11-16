package com.example.demo;

import java.util.List;

public record SignupRequest (
    @NotBlank String name,
    @NotBlank String major,
    @NotBlank String gender,
    List<String> interests
) {
}
// 文件名含义：注册请求DTO，专门接收前端传过来的注册JSON数据（@RequestBody接收的对象）




