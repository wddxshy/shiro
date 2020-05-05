package com.shy;

import com.shy.mapper.AccountMapper;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootShiroApplicationTests {

    @Autowired
    AccountMapper account;

    @Test
    void contextLoads() {
//        List<Account> accountList = account.queryAccountByLogin(1);
//        accountList.forEach(System.out::println);
        String username="lisi";
        String password="456789";
        SimpleHash simpleHash = new SimpleHash("sha-256",password , username, 10000);
        System.out.println(simpleHash.toString());
    }

}
