package com.it6666.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.it6666.mapper.UserMapper;
import com.it6666.domain.User;
import com.it6666.service.UserService;

/**
 * @author BNTang
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService{

}
