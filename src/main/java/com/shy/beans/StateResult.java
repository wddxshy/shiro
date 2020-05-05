package com.shy.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: WeiDongDong
 * @Date 2020/5/1 14:18
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StateResult<T> {
    private Integer code;
    private String message;
    private T data;

    public StateResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
