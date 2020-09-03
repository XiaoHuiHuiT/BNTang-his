package com.it6666.vo;

import com.it6666.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * description: ActiverUser
 * date: 2020-09-03 22:11
 * author: 30315
 * version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActiverUser implements Serializable {
    private User user;
    // 角色
    private List<String> roles = Collections.EMPTY_LIST;
    // 权限
    private List<String> permissions = Collections.EMPTY_LIST;
}
