package com.it6666.service;

import com.it6666.domain.User;

/**
 * @author BNTang
 */
public interface UserService {

    /**
     * 根据手机号查询用户
     *
     * @param phone 手机号
     * @return      根据手机号查询到的用户对象
     */
    User queryUserByPhone(String phone);

    /**
     * 根据用户ID查询用户
     *
     * @param userId 用户编号
     * @return       根据用户ID查询到的用户对象
     */
    User getOne(Long userId);
}
