package com.macro.mall.tiny.domain;

import com.macro.mall.tiny.model.UmsResource;
import com.macro.mall.tiny.model.UmsResourceCategory;
import lombok.Data;

/**
 * @auther macrozheng
 * @description UmsResource扩展类
 * @date 2022/10/20
 * @github https://github.com/macrozheng
 */
@Data
public class UmsResourceExt extends UmsResource {

    private UmsResourceCategory category;
}
