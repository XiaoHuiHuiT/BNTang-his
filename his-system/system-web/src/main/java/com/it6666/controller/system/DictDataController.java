package com.it6666.controller.system;

import com.it6666.aspectj.annotation.Log;
import com.it6666.aspectj.enums.BusinessType;
import com.it6666.dto.DictDataDto;
import com.it6666.service.DictDataService;
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
 * @date Created in 2020/9/5 15:04
 * @description 数据字典信息
 **/
@RestController
@RequestMapping("system/dict/data")
public class DictDataController {

    @Autowired
    private DictDataService dictDataService;

    /**
     * 分页查询
     */
    @GetMapping("listForPage")
    @Log(title = "分页查询",businessType = BusinessType.OTHER)
    public AjaxResult listForPage(DictDataDto dictDataDto) {
        DataGridView gridView = this.dictDataService.listPage(dictDataDto);
        return AjaxResult.success("查询成功", gridView.getData(), gridView.getTotal());
    }

    /**
     * 添加
     */
    @PostMapping("addDictData")
    @Log(title = "添加数据字典信息",businessType = BusinessType.INSERT)
    public AjaxResult addDictData(@Validated DictDataDto dictDataDto) {
        dictDataDto.setSimpleUser(ShiroSecurityUtils.getCurrentSimpleUser());
        return AjaxResult.toAjax(this.dictDataService.insert(dictDataDto));
    }

    /**
     * 修改
     */
    @PutMapping("updateDictData")
    @Log(title = "修改数据字典信息",businessType = BusinessType.UPDATE)
    public AjaxResult updateDictData(@Validated DictDataDto dictDataDto) {
        dictDataDto.setSimpleUser(ShiroSecurityUtils.getCurrentSimpleUser());
        return AjaxResult.toAjax(this.dictDataService.update(dictDataDto));
    }


    /**
     * 根据ID查询一个字典信息
     */
    @GetMapping("getOne/{dictCode}")
    @Log(title = "根据ID查询一个字典信息",businessType = BusinessType.OTHER)
    public AjaxResult getDictData(@PathVariable @Validated @NotNull(message = "字典ID不能为空") Long dictCode) {
        return AjaxResult.success(this.dictDataService.selectDictDataById(dictCode));
    }

    /**
     * 删除
     */
    @DeleteMapping("deleteDictDataByIds/{dictCodeIds}")
    @Log(title = "删除数据字典信息",businessType = BusinessType.DELETE)
    public AjaxResult updateDictData(@PathVariable @Validated @NotEmpty(message = "要删除的ID不能为空") Long[] dictCodeIds) {
        return AjaxResult.toAjax(this.dictDataService.deleteDictDataByIds(dictCodeIds));
    }

    /**
     * 查询所有可用的字典类型
     */
    @GetMapping("getDataByType/{dictType}")
    @Log(title = "查询所有可用的字典类型",businessType = BusinessType.OTHER)
    public AjaxResult getDataByType(@PathVariable @Validated @NotEmpty(message = "字典类型不能为空") String dictType) {
        return AjaxResult.success(this.dictDataService.selectDictDataByDictType(dictType));
    }

}
