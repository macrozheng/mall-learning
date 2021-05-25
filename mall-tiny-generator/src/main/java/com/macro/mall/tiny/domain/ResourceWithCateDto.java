package com.macro.mall.tiny.domain;

import com.macro.mall.tiny.mbg.model.UmsResource;
import com.macro.mall.tiny.mbg.model.UmsResourceCategory;

/**
 * Created by macro on 2020/12/9.
 */
public class ResourceWithCateDto extends UmsResource {
    private UmsResourceCategory resourceCategory;

    public UmsResourceCategory getResourceCategory() {
        return resourceCategory;
    }

    public void setResourceCategory(UmsResourceCategory resourceCategory) {
        this.resourceCategory = resourceCategory;
    }
}
