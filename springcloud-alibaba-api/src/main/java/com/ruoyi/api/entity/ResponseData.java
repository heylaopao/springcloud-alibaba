package com.ruoyi.api.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseData<T> {
    private Integer code;

    private String message;

    private T data;

    public ResponseData(int code, String message) {
        this(code, message, null);
    }

    public static ResponseData success(Object data, String... message) {
        return ResponseData
                .builder()
                .code(200)
                .message(message == null || message.length == 0 ? "success" : message[0])
                .data(data)
                .build();
    }

    public static ResponseData failure(Object data, String... message) {
        return ResponseData
                .builder()
                .code(400)
                .message(message == null || message.length == 0 ? "failed" : message[0])
                .data(data)
                .build();
    }
}
