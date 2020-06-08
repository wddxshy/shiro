package com.shy.service;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.shy.beans.Account;
import com.shy.beans.StateResult;
import com.shy.config.Kaptcha;
import com.shy.mapper.AccountMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.UUID;

/**
 * @Author: WeiDongDong
 * @Date 2020/5/4 23:33
 * @Description
 */
@Service
@Slf4j
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private Kaptcha kaptcha;

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

    @Override
    public String getImag() {
        DefaultKaptcha dkaptcha = kaptcha.getDefaultKaptcha();

        // 生成文字验证码
        String text = dkaptcha.createText();
        log.info("验证码为： "+text);

        //存入redis
        String uid = UUID.randomUUID().toString().replace("-", "");


        // 生成图片验证码
        ByteArrayOutputStream outputStream = null;
        BufferedImage image = dkaptcha.createImage(text);

        outputStream = new ByteArrayOutputStream();
        try {
            ImageIO.write(image, "jpg", outputStream);
        } catch (IOException e) {
            e.printStackTrace();
            log.warn("验证码图片生成失败");
        }

        // 对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();
        String encode = encoder.encode(outputStream.toByteArray());

        return "data:image/jpeg;base64,"+encode;
    }

}
