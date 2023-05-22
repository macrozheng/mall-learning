package com.macro.mall.tiny.dto;

import com.macro.mall.tiny.mbg.model.UmsMenu;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;


import java.util.List;

/**
 * @auther macrozheng
 * @description 后台菜单节点封装
 * @date 2020/2/4
 * @github https://github.com/macrozheng
 */
@Getter
@Setter
public class UmsMenuNode extends UmsMenu {
    @ApiModelProperty(value = "子级菜单")
    private List<UmsMenuNode> children;
}
