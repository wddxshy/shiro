package com.shy.service;

import com.shy.beans.Account;
import com.shy.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

/**
 * @Author: WeiDongDong
 * @Date 2020/5/4 23:33
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

    @Override
    public void updateLoginTime(Timestamp nowTime) {
        accountMapper.updateLoginTime(nowTime);
    }

    @Override
    public Timestamp queryAccountByTimeStamp(String Ausername) {
        return accountMapper.queryAccountByTimeStamp(Ausername);
    }


}
