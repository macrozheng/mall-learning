package com.macro.mall.tiny.domain;

import com.macro.mall.tiny.model.UmsResource;
import com.macro.mall.tiny.model.UmsResourceCategory;
import lombok.Data;

/**
 * UmsResource扩展类
 * Created by macro on 2022/10/20.
 */
@Data
public class UmsResourceExt extends UmsResource {

    private UmsResourceCategory category;
}
