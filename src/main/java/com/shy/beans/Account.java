package com.shy.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * @Author: WeiDongDong
 * @Date 2020/4/24 18:19
 * @Description  账户映射
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account{
    private Integer Aid;
    private String Ausername;
    private String Apassword;
    private boolean checked;
    private String kaptcha;
    private Timestamp Alogintime;
}
