package com.it6666.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.it6666.constants.Constants;
import com.it6666.dto.DictDataDto;
import com.it6666.vo.DataGridView;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

import com.it6666.mapper.DictDataMapper;
import com.it6666.domain.DictData;
import com.it6666.service.DictDataService;

@Service
public class DictDataServiceImpl implements DictDataService {

    @Autowired
    private DictDataMapper dictDataMapper;

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 之前是从数据库里面查询, 因为我们做到了redis中，所以现在要去redis里面去查询
     *
     * @param dictType
     * @return
     */
    @Override
    public List<DictData> selectDictDataByDictType(String dictType) {
        String key = Constants.DICT_REDIS_PROFIX + dictType;
        ValueOperations<String, String> opsForValue = redisTemplate.opsForValue();
        String json = opsForValue.get(key);
        List<DictData> dictDatas = JSON.parseArray(json, DictData.class);
        return dictDatas;
    }

    @Override
    public DataGridView listPage(DictDataDto dictDataDto) {
        QueryWrapper<DictData> qw = new QueryWrapper<>();
        Page<DictData> page = new Page<>(dictDataDto.getPageNum(), dictDataDto.getPageSize());
        qw.eq(StringUtils.isNotBlank(dictDataDto.getDictType()), DictData.COL_DICT_TYPE, dictDataDto.getDictType());
        qw.like(StringUtils.isNotBlank(dictDataDto.getDictLabel()), DictData.COL_DICT_LABEL, dictDataDto.getDictLabel());
        qw.eq(StringUtils.isNotBlank(dictDataDto.getStatus()), DictData.COL_STATUS, dictDataDto.getStatus());
        this.dictDataMapper.selectPage(page, qw);
        return new DataGridView(page.getTotal(), page.getRecords());
    }

    @Override
    public int insert(DictDataDto dictDataDto) {
        DictData dictData = new DictData();
        BeanUtil.copyProperties(dictDataDto, dictData);
        // 设置创建者，创建时间
        dictData.setCreateBy(dictDataDto.getSimpleUser().getUserName());
        dictData.setCreateTime(DateUtil.date());
        return this.dictDataMapper.insert(dictData);
    }

    @Override
    public int update(DictDataDto dictDataDto) {
        DictData dictData = new DictData();
        BeanUtil.copyProperties(dictDataDto, dictData);
        // 设置修改人
        dictData.setUpdateBy(dictDataDto.getSimpleUser().getUserName());
        return this.dictDataMapper.updateById(dictData);
    }

    @Override
    public int deleteDictDataByIds(Long[] dictCodeIds) {
        List<Long> ids = Arrays.asList(dictCodeIds);
        if (null != ids && ids.size() > 0) {
            return this.dictDataMapper.deleteBatchIds(ids);
        } else {
            return -1;
        }
    }

    @Override
    public DictData selectDictDataById(Long dictCode) {
        return this.dictDataMapper.selectById(dictCode);
    }
}
