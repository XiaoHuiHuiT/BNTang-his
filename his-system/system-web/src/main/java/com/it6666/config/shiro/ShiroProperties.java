package com.it6666.config.shiro;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * description: ShiroProperties
 * date: 2020-09-03 22:19
 * author: 30315
 * version: 1.0
 */
@ConfigurationProperties(prefix = "shiro")
@Data
public class ShiroProperties {
    /**
     * 密码加密方式
     */
    private String hashAlgorithmName = "md5";
    /**
     * 密码散列次数
     */
    private Integer hashIterations = 2;

    /**
     * 不拦击的路径
     */
    private String[] anonUrls;

    /**
     * 拦截的路径
     */
    private String[] authcUrls;
}
