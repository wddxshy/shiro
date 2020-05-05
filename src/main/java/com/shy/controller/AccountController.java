package com.shy.controller;

import com.shy.beans.Account;
import com.shy.beans.StateResult;
import com.shy.service.LoginService;
import com.shy.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: WeiDongDong
 * @Date 2020/4/19 13:52
 * @Description  UserController
 */
@Controller
@RequestMapping("/account")
@Slf4j
public class AccountController {

    @Autowired
    private UserService userServiceImpl;

    @Autowired
    private LoginService loginServiceImpl;


    @RequestMapping("/login")
    @ResponseBody
    public StateResult login(@RequestBody Account account){
        //获取当前用户的Subject
        Subject subject = SecurityUtils.getSubject();

        //封装登录信息，生成token
        UsernamePasswordToken token = new UsernamePasswordToken(account.getAusername(),account.getApassword());
        try {
            subject.login(token);

            Timestamp lastTime = loginServiceImpl.queryAccountByTimeStamp(account.getAusername());
            String timeStr = lastTime.toLocalDateTime().toString().replace("T"," ");
            log.info(timeStr);
            Timestamp nowTime = Timestamp.valueOf(LocalDateTime.now());
            loginServiceImpl.updateLoginTime(nowTime);
            Map<String,Object> sessionToken = new HashMap<>();
            sessionToken.put("SessionId",subject.getSession().getId());
            return new StateResult(200,"登录成功"+"\t"+"上次登录时间为"+timeStr,sessionToken);      //登陆成功
        } catch (UnknownAccountException e) {
            e.printStackTrace();
            return new StateResult(701,"用户名不存在");     //账号异常
        }catch (IncorrectCredentialsException e){
            e.printStackTrace();
            return new StateResult(702,"密码错误，请检查密码");     //密码异常
        }

    }

    @PostMapping("/register")
    @ResponseBody
    public StateResult accountRegister(@RequestBody Account account){
        int i = userServiceImpl.insertAccount(account);
        log.warn("插入数据，返回结果为："+i);
        return new StateResult(300,"账户创建成功",i);
    }

    @RequestMapping("/logout")
    @ResponseBody
    public StateResult accountLogout(){
        SecurityUtils.getSubject().logout();
        return new StateResult(201,"账号已登出");
    }
}
