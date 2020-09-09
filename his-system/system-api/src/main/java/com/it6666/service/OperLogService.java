package com.it6666.service;

import com.it6666.domain.OperLog;
import com.it6666.dto.OperLogDto;
import com.it6666.vo.DataGridView;

/**
 * @author BNTang
 */
public interface OperLogService {
    /**
     * 插入操作日志
     *
     * @param operLog
     */
    void insertOperLog(OperLog operLog);

    /**
     * 分页查询操作日志
     *
     * @param operLogDto
     * @return
     */
    DataGridView listForPage(OperLogDto operLogDto);

    /**
     * 根据ID删除操作日志
     *
     * @param infoIds
     * @return
     */
    int deleteOperLogByIds(Long[] infoIds);

    /**
     * 清空操作日志
     *
     * @return
     */
    int clearAllOperLog();
}
