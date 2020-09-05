package com.it6666.dto;

import com.it6666.domain.SimpleUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author tangyihao
 * @version V1.1.1
 * @program BNTang-his
 * @date Created in 2020/9/1 18:01
 * @description 基础数据传输类
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseDto implements Serializable {

    /**
     * 页码 默认1
     */
    private final Integer pageNum = 1;

    /**
     * 每页显示条数 默认10
     */
    private final Integer pageSize = 10;

    /**
     * 当前操作对象
     */
    private SimpleUser simpleUser;

    /**
     * 开始时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date beginTime;
    /**
     * 结束时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endTime;

}
