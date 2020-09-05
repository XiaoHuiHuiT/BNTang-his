package com.it6666.vo;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author tangyihao
 * @version V1.1.1
 * @program BNTang-his
 * @date Created in 2020/9/5 13:43
 * @description 表格数据传输对象
 **/
@ApiModel(value = "com-it6666-vo-DataGridView")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataGridView implements Serializable {
    private Long total;
    private List<?> data;
}
