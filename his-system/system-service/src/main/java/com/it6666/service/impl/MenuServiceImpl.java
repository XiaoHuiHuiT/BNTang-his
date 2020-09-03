package com.it6666.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.it6666.constants.Constants;
import com.it6666.domain.SimpleUser;
import org.springframework.stereotype.Service;

import java.util.List;

import com.it6666.domain.Menu;
import com.it6666.mapper.MenuMapper;
import com.it6666.service.MenuService;

/**
 * description: MenuServiceImpl
 * date: 2020-09-03 21:39
 * author: 30315
 * version: 1.0
 */
@Service
public class MenuServiceImpl implements MenuService {

    private final MenuMapper menuMapper;

    public MenuServiceImpl(MenuMapper menuMapper) {
        this.menuMapper = menuMapper;
    }

    @Override
    public List<Menu> selectMenuTree(boolean isAdmin, SimpleUser simpleUser) {
        QueryWrapper<Menu> qw = new QueryWrapper<>();
        qw.eq(Menu.COL_STATUS, Constants.STATUS_TRUE);
        qw.in(Menu.COL_MENU_TYPE, Constants.MENU_TYPE_M, Constants.MENU_TYPE_C);
        qw.orderByAsc(Menu.COL_PARENT_ID);
        if (isAdmin) {
            return menuMapper.selectList(qw);
        } else {
            // 根据用户id查询用户拥有的菜单信息
            return menuMapper.selectList(qw);
        }
    }
}