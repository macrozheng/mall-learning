package com.macro.mall.tiny.easyes.document;

import cn.easyes.annotation.IndexField;
import cn.easyes.common.enums.FieldType;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 搜索商品的属性信息
 * Created by macro on 2018/6/27.
 */
@Data
@EqualsAndHashCode
public class EsProductAttributeValue implements Serializable {
    private static final long serialVersionUID = 1L;
    @IndexField(fieldType = FieldType.LONG)
    private Long id;
    @IndexField(fieldType = FieldType.KEYWORD)
    private Long productAttributeId;
    //属性值
    @IndexField(fieldType = FieldType.KEYWORD)
    private String value;
    //属性参数：0->规格；1->参数
    @IndexField(fieldType = FieldType.INTEGER)
    private Integer type;
    //属性名称
    @IndexField(fieldType=FieldType.KEYWORD)
    private String name;
}
