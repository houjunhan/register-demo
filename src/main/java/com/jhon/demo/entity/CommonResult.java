package com.jhon.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    //默认200成功.
    private Integer code = 200;
    private String message = "操作成功";
    private T data;

    /**
     * @param code
     * @param message
     */
    public CommonResult(Integer code, String message) {
        this(code, message, null);
    }

}
