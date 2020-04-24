package com.shy;

import com.shy.beans.Account;
import com.shy.mapper.AccountMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringbootShiroApplicationTests {

    @Autowired
    AccountMapper account;

    @Test
    void contextLoads() {
        List<Account> accountList = account.queryAccountByLogin(1);
        accountList.forEach(System.out::println);
    }

}
