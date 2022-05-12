package com.macro.mall.tiny.controller;

import com.macro.mall.tiny.common.api.CommonPage;
import com.macro.mall.tiny.common.api.CommonResult;
import com.macro.mall.tiny.domain.AdminRoleDto;
import com.macro.mall.tiny.domain.ResourceWithCateDto;
import com.macro.mall.tiny.domain.RoleStatDto;
import com.macro.mall.tiny.mbg.model.UmsAdmin;
import com.macro.mall.tiny.service.UmsAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 后台用户管理Controller
 * Created by macro on 2020/12/8.
 */
@Api(tags = "UmsAdminController", description = "后台用户管理")
@RestController
@RequestMapping("/admin")
public class UmsAdminController {

    @Autowired
    private UmsAdminService adminService;

    @ApiOperation("创建")
    @PostMapping("/create")
    public CommonResult create(@RequestBody UmsAdmin entity) {
        adminService.create(entity);
        return CommonResult.success(null);
    }

    @ApiOperation("修改")
    @PostMapping("/update/{id}")
    public CommonResult update(@PathVariable Long id, @RequestBody UmsAdmin entity) {
        entity.setId(id);
        adminService.update(entity);
        return CommonResult.success(null);
    }

    @ApiOperation("删除")
    @PostMapping("/delete/{id}")
    public CommonResult delete(@PathVariable Long id) {
        adminService.delete(id);
        return CommonResult.success(null);
    }

    @ApiOperation("根据ID查询")
    @GetMapping("/select/{id}")
    public CommonResult<UmsAdmin> select(@PathVariable Long id) {
        UmsAdmin entity = adminService.select(id);
        return CommonResult.success(entity);
    }

    @ApiOperation("分页查询所有")
    @GetMapping("/listAll")
    public CommonResult<CommonPage<UmsAdmin>> listAll(@RequestParam(value = "pageNum", defaultValue = "1")
                                                      @ApiParam("页码") Integer pageNum,
                                                      @RequestParam(value = "pageSize", defaultValue = "5")
                                                      @ApiParam("每页数量") Integer pageSize) {
        List<UmsAdmin> list = adminService.listAll(pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(list));
    }

    @ApiOperation("分页条件查询")
    @GetMapping("/list")
    public CommonResult<CommonPage<UmsAdmin>> list(@RequestParam(value = "pageNum", defaultValue = "1")
                                                   @ApiParam("页码") Integer pageNum,
                                                   @RequestParam(value = "pageSize", defaultValue = "5")
                                                   @ApiParam("每页数量") Integer pageSize,
                                                   @RequestParam(required = false)
                                                   @ApiParam("用户名") String username,
                                                   @RequestParam
                                                   @ApiParam(value = "状态",required = true) List<Integer> statusList) {
        List<UmsAdmin> list = adminService.list(pageNum, pageSize, username, statusList);
        return CommonResult.success(CommonPage.restPage(list));
    }

    @ApiOperation("使用子查询")
    @GetMapping("/subList")
    public CommonResult<List<UmsAdmin>> subList(@RequestParam Long roleId) {
        List<UmsAdmin> list = adminService.subList(roleId);
        return CommonResult.success(list);
    }

    @ApiOperation("使用Group和Join查询")
    @GetMapping("/groupList")
    public CommonResult<List<RoleStatDto>> groupList() {
        List<RoleStatDto> list = adminService.groupList();
        return CommonResult.success(list);
    }

    @ApiOperation("条件删除")
    @GetMapping("/deleteByUsername")
    public CommonResult deleteByUsername(@RequestParam String username) {
        adminService.deleteByUsername(username);
        return CommonResult.success(null);
    }

    @ApiOperation("条件修改")
    @GetMapping("/updateByIds")
    public CommonResult updateByIds(@RequestParam List<Long> ids,@RequestParam Integer status) {
        adminService.updateByIds(ids, status);
        return CommonResult.success(null);
    }

    @ApiOperation("一对多查询")
    @GetMapping("/selectWithRoleList")
    public CommonResult<AdminRoleDto> selectWithRoleList(@RequestParam Long id) {
        AdminRoleDto adminRoleDto = adminService.selectWithRoleList(id);
        return CommonResult.success(adminRoleDto);
    }

    @ApiOperation("一对一查询")
    @GetMapping("/selectResourceWithCate")
    public CommonResult<ResourceWithCateDto> selectResourceWithCate(@RequestParam Long id) {
        ResourceWithCateDto resourceWithCateDto = adminService.selectResourceWithCate(id);
        return CommonResult.success(resourceWithCateDto);
    }
}
