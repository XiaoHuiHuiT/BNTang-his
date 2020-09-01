package com.it6666.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author tangyihao
 * @version V1.1.1
 * @program BNTang-his
 * @date Created in 2020/9/1 18:03
 * @description 登陆的数据输出对象
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginBodyDto {

    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 验证码
     */
    private String code;

}
