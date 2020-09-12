package com.it6666.controller.system;

import com.it6666.aspectj.annotation.Log;
import com.it6666.aspectj.enums.BusinessType;
import com.it6666.dto.DictTypeDto;
import com.it6666.service.DictTypeService;
import com.it6666.utils.ShiroSecurityUtils;
import com.it6666.vo.AjaxResult;
import com.it6666.vo.DataGridView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author tangyihao
 * @version V1.1.1
 * @program BNTang-his
 * @date Created in 2020/9/5 14:21
 * @description 数据字典信息
 **/
@RestController
@RequestMapping("system/dict/type")
public class DictTypeController {

    @Autowired
    private DictTypeService dictTypeService;

    /**
     * 分页查询
     */
    @GetMapping("listForPage")
    @Log(title = "分页查询",businessType = BusinessType.OTHER)
    public AjaxResult listForPage(DictTypeDto dictTypeDto) {
        DataGridView gridView = this.dictTypeService.listPage(dictTypeDto);
        return AjaxResult.success("查询成功", gridView.getData(), gridView.getTotal());
    }

    /**
     * 添加
     */
    @PostMapping("addDictType")
    @Log(title = "添加数据字典信息",businessType = BusinessType.INSERT)
    public AjaxResult addDictType(@Validated DictTypeDto dictTypeDto) {
        if (dictTypeService.checkDictTypeUnique(dictTypeDto.getDictId(), dictTypeDto.getDictType())) {
            return AjaxResult.fail("新增字典【" + dictTypeDto.getDictName() + "】失败，字典类型已存在");
        }
        dictTypeDto.setSimpleUser(ShiroSecurityUtils.getCurrentSimpleUser());
        return AjaxResult.toAjax(this.dictTypeService.insert(dictTypeDto));
    }

    /**
     * 修改
     */
    @PutMapping("updateDictType")
    @Log(title = "修改数据字典信息",businessType = BusinessType.UPDATE)
    public AjaxResult updateDictType(@Validated DictTypeDto dictTypeDto) {
        if (dictTypeService.checkDictTypeUnique(dictTypeDto.getDictId(), dictTypeDto.getDictType())) {
            return AjaxResult.fail("修改字典【" + dictTypeDto.getDictName() + "】失败，字典类型已存在");
        }
        dictTypeDto.setSimpleUser(ShiroSecurityUtils.getCurrentSimpleUser());
        return AjaxResult.toAjax(this.dictTypeService.update(dictTypeDto));
    }

    /**
     * 根据ID查询一个字典信息
     */
    @GetMapping("getOne/{dictId}")
    @Log(title = "根据ID查询一个字典信息",businessType = BusinessType.OTHER)
    public AjaxResult getDictType(@PathVariable @Validated @NotNull(message = "字典ID不能为空") Long dictId) {
        return AjaxResult.success(this.dictTypeService.selectDictTypeById(dictId));
    }

    /**
     * 删除
     */
    @DeleteMapping("deleteDictTypeByIds/{dictIds}")
    @Log(title = "删除数据字典信息",businessType = BusinessType.DELETE)
    public AjaxResult updateDictType(@PathVariable @Validated @NotEmpty(message = "要删除的ID不能为空") Long[] dictIds) {
        return AjaxResult.toAjax(this.dictTypeService.deleteDictTypeByIds(dictIds));
    }

    /**
     * 查询所有可用的字典类型
     */
    @GetMapping("selectAllDictType")
    @Log(title = "查询所有可用的字典类型",businessType = BusinessType.OTHER)
    public AjaxResult selectAllDictType() {
        return AjaxResult.success(this.dictTypeService.list().getData());
    }

    /**
     * 同步缓存
     */
    @GetMapping("dictCacheAsync")
    @Log(title = "同步缓存",businessType = BusinessType.OTHER)
    public AjaxResult dictCacheAsync() {
        try {
            this.dictTypeService.dictCacheAsync();
            return AjaxResult.success();
        } catch (Exception e) {
            return AjaxResult.error();
        }
    }
}
