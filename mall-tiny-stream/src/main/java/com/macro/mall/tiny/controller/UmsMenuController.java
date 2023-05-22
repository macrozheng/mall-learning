package com.macro.mall.tiny.controller;
import com.macro.mall.tiny.common.api.CommonResult;
import com.macro.mall.tiny.dto.UmsMenuNode;
import com.macro.mall.tiny.service.UmsMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @auther macrozheng
 * @description 后台用户权限管理
 * @date 2018/9/29
 * @github https://github.com/macrozheng
 */
@Controller
@Api(tags = "UmsMenuController")
@Tag(name = "UmsMenuController",description = "后台菜单管理")
@RequestMapping("/menu")
public class UmsMenuController {
    @Autowired
    private UmsMenuService menuService;

    @ApiOperation("树形结构返回所有菜单列表")
    @RequestMapping(value = "/treeList", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<UmsMenuNode>> treeList() {
        List<UmsMenuNode> menuNodeList = menuService.treeList();
        return CommonResult.success(menuNodeList);
    }
}
