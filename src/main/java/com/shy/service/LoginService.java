package com.shy.service;

import com.shy.beans.Account;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;

/**
 * @Author: WeiDongDong
 * @Date 2020/4/25 20:28
 * @Description
 */
public interface LoginService {

    Account queryAccountByLogin(String username);
    void updateLoginTime(Timestamp nowTime);
    Timestamp queryAccountByTimeStamp(@Param("Ausername") String username);
}
