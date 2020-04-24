package com.shy.mapper;

import com.shy.beans.Account;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: WeiDongDong
 * @Date 2020/4/24 18:22
 * @Description  账户DAO
 */
//@Mapper
@Repository
public interface AccountMapper {

    //用户登录查询
    List<Account> queryAccountByLogin(@Param("Aid") int aid);
}
