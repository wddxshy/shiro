package com.shy.controller;

import com.shy.beans.StateResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: WeiDongDong
 * @Date 2020/5/5 13:28
 * @Description
 */
@RestController
@RequestMapping("user")
@Slf4j
public class UserController {

    @GetMapping("query")
    public StateResult query(){
        return new StateResult(200,"测试，个人主页");
    }
}
