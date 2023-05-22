package com.macro.mall.tiny.domain;

import com.macro.mall.tiny.model.UmsResource;
import com.macro.mall.tiny.model.UmsResourceCategory;
import lombok.Data;

import java.util.List;

/**
 * @auther macrozheng
 * @description UmsResourceCategory扩展类
 * @date 2022/10/20
 * @github https://github.com/macrozheng
 */
@Data
public class UmsResourceCategoryExt extends UmsResourceCategory {

    private List<UmsResource> resourceList;
}
