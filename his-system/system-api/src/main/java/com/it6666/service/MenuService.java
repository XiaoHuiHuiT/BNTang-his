package com.it6666.service;

import com.it6666.domain.Menu;
import com.it6666.domain.SimpleUser;

import java.util.List;

/**
 * description: MenuService
 * date: 2020-09-03 21:39
 * author: 30315
 * version: 1.0
 */
public interface MenuService {

    /**
     * 查询菜单信息
     * 如查用户是超级管理员，那么查询所以菜单和权限
     * 如果用户是普通用户，那么根据用户ID关联角色和权限
     *
     * @param isAdmin    是否是超级管理员
     * @param simpleUser 如果isAdmin=true  simpleUser可以为空
     */
    public List<Menu> selectMenuTree(boolean isAdmin, SimpleUser simpleUser);
}
