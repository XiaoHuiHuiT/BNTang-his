package com.it6666.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.it6666.mapper.UserMapper;
import com.it6666.domain.User;
import com.it6666.service.UserService;

/**
 * @author BNTang
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User queryUserByPhone(String phone) {
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.eq(User.COL_PHONE, phone);
        return this.userMapper.selectOne(qw);
    }

    @Override
    public User getOne(Long userId) {
        return this.userMapper.selectById(userId);
    }
}