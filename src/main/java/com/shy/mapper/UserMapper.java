package com.shy.mapper;

import com.shy.beans.Account;
import org.springframework.stereotype.Repository;

/**
 * @Author: WeiDongDong
 * @Date 2020/5/4 18:24
 * @Description
 */
@Repository
public interface UserMapper {
    int insertAccount(Account account);
}
