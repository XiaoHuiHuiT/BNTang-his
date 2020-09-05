package com.it6666.utils;

import com.it6666.constants.Constants;
import com.it6666.domain.SimpleUser;
import com.it6666.domain.User;
import com.it6666.vo.ActiverUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import java.util.List;

/**
 * @author tangyihao
 * @version V1.1.1
 * @program BNTang-his
 * @date Created in 2020/9/5 14:16
 * @description
 **/
public class ShiroSecurityUtils {
    /***
     * @Description: 得到当前登陆的用户对象的ActiveUser
     */
    public static ActiverUser getCurrentActiveUser() {
        Subject subject = SecurityUtils.getSubject();
        return (ActiverUser) subject.getPrincipal();
    }

    /***
     * @Description: 得到当前登陆的用户对象User
     */
    public static User getCurrentUser() {
        return getCurrentActiveUser().getUser();
    }

    /***
     * @Description: 得到当前登陆的用户对象SimpleUser
     */
    public static SimpleUser getCurrentSimpleUser() {
        User user = getCurrentActiveUser().getUser();
        return new SimpleUser(user.getUserId(), user.getUserName());
    }

    /***
     * @Description: 得到当前登陆的用户名称
     */
    public static String getCurrentUserName() {
        return getCurrentActiveUser().getUser().getUserName();
    }

    /***
     * @Description: 得到当前登陆对象的角色编码
     */
    public static List<String> getCurrentUserRoles() {
        return getCurrentActiveUser().getRoles();
    }


    /***
     * @Description: 得到当前登陆对象的权限编码
     */
    public static List<String> getCurrentUserPermissions() {
        return getCurrentActiveUser().getPermissions();
    }

    /***
     * @Description: 判断当前用户是否是超级管理员
     */
    public static boolean isAdmin() {
        return getCurrentUser().getUserType().equals(Constants.USER_ADMIN);
    }
}
