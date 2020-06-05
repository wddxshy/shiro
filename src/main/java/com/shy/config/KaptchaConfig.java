package com.shy.config;

import com.google.code.kaptcha.Producer;
import com.google.code.kaptcha.util.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * @Author: WeiDongDong
 * @Date 2020/5/5 10:12
 * @Description  验证码配置
 */
@Configuration
public class KaptchaConfig {

    @Bean
    public Producer kaptchaProducer(){
        Properties kaptchaProperties = new Properties();
        kaptchaProperties.put("kaptcha.border", "no");
        kaptchaProperties.put("kaptcha.textproducer.char.length","6");
        kaptchaProperties.put("kaptcha.image.height","50");
        kaptchaProperties.put("kaptcha.image.width","150");
        kaptchaProperties.put("kaptcha.obscurificator.impl","com.google.code.kaptcha.impl.ShadowGimpy");
        kaptchaProperties.put("kaptcha.textproducer.font.color","black");
        kaptchaProperties.put("kaptcha.textproducer.font.size","40");
        kaptchaProperties.put("kaptcha.noise.impl","com.google.code.kaptcha.impl.NoNoise");
        kaptchaProperties.put("kaptcha.textproducer.char.string","acdefhkmnprtwxy2345678");

        Config config = new Config(kaptchaProperties);
        return config.getProducerImpl();
    }

}
