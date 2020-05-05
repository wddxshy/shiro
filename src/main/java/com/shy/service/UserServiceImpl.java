package com.shy.service;

import com.shy.beans.Account;
import com.shy.mapper.UserMapper;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * @Author: WeiDongDong
 * @Date 2020/5/4 18:22
 * @Description
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int insertAccount(Account account) {
        String simpleHash = new SimpleHash("sha-256",account.getApassword(),account.getAusername(), 10000).toString();
        account.setApassword(simpleHash);
        account.setAlogintime(Timestamp.valueOf(LocalDateTime.now()));
        return userMapper.insertAccount(account);
    }
}
