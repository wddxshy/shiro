package com.shy.service;

import com.shy.beans.Account;
import com.shy.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: WeiDongDong
 * @Date 2020/4/25 20:31
 * @Description
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public Account queryAccountByLogin(String username) {
        return accountMapper.queryAccountByLogin(username);
    }
}
