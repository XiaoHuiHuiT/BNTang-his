package com.it6666.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author tangyihao
 * @version V1.1.1
 * @program BNTang-his
 * @date Created in 2020/9/1 17:55
 * @description 用户对象传输类
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SimpleUser implements Serializable {

    private Serializable userId;
    private String userName;

}
