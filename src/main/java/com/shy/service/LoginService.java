package com.shy.service;

import com.shy.beans.Account;

/**
 * @Author: WeiDongDong
 * @Date 2020/4/25 20:28
 * @Description
 */
public interface LoginService {

    Account queryAccountByLogin(String username);
}
