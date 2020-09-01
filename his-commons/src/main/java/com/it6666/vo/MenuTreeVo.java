package com.it6666.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author tangyihao
 * @version V1.1.1
 * @program BNTang-his
 * @date Created in 2020/9/1 18:00
 * @description 构造菜单返回给前台的vo
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuTreeVo {

    private String id;

    private String serPath;

    private boolean show = true;

    public MenuTreeVo(String id, String serPath) {
        this.id = id;
        this.serPath = serPath;
    }

}
