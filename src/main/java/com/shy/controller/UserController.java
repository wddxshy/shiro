package com.shy.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: WeiDongDong
 * @Date 2020/4/19 13:52
 * @Description  UserController
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @PostMapping("/login")
    public String login(){
        //获取当前用户的Subject
        Subject subject = SecurityUtils.getSubject();

        //封装登录信息，生成token
        UsernamePasswordToken token = new UsernamePasswordToken();
        try {
            subject.login(token);
            return null;      //登陆成功
        } catch (UnknownAccountException e) {
            e.printStackTrace();
            return null;     //账号异常
        }catch (IncorrectCredentialsException e){
            e.printStackTrace();
            return null;     //密码异常
        }

    }
}
