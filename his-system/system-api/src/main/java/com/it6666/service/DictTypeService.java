package com.it6666.service;

import com.it6666.domain.DictType;
import com.it6666.dto.DictTypeDto;
import com.it6666.vo.DataGridView;

public interface DictTypeService {

    /**
     * 分页查询字典类型
     *
     * @param dictTypeDto
     * @return
     */
    DataGridView listPage(DictTypeDto dictTypeDto);

    /**
     * 查询所有字典类型
     *
     * @return
     */
    DataGridView list();

    /**
     * 检查字典类型是否存在
     *
     * @param dictType
     * @return
     */
    Boolean checkDictTypeUnique(Long dictId, String dictType);

    /**
     * 插入新的字典类型
     *
     * @param dictTypeDto
     * @return
     */
    int insert(DictTypeDto dictTypeDto);

    /**
     * 修改字典类型
     *
     * @param dictTypeDto
     * @return
     */
    int update(DictTypeDto dictTypeDto);

    /**
     * 根据ID删除字典类型
     *
     * @param dictIds
     * @return
     */
    int deleteDictTypeByIds(Long[] dictIds);

    /**
     * 根据ID查询一个字典类型
     *
     * @param dictId
     * @return
     */
    DictType selectDictTypeById(Long dictId);

    /**
     * 同步缓存
     */
    void dictCacheAsync();
}
