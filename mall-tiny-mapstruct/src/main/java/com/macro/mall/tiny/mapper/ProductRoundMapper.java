package com.macro.mall.tiny.mapper;

import com.macro.mall.tiny.dto.ProductDto;
import com.macro.mall.tiny.po.Product;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

/**
 * 商品对象映射（自定义处理）
 * Created by macro on 2021/10/21.
 */
@Mapper(imports = {UUID.class})
public abstract class ProductRoundMapper {
    public static ProductRoundMapper INSTANCE = Mappers.getMapper(ProductRoundMapper.class);

    @Mapping(target = "id",constant = "-1L")
    @Mapping(source = "count",target = "count",defaultValue = "1")
    @Mapping(target = "productSn",expression = "java(UUID.randomUUID().toString())")
    public abstract ProductDto toDto(Product product);

    @BeforeMapping
    public void beforeMapping(Product product){
        //映射前当price<0时设置为0
        if(product.getPrice().compareTo(BigDecimal.ZERO)<0){
            product.setPrice(BigDecimal.ZERO);
        }
    }

    @AfterMapping
    public void afterMapping(@MappingTarget ProductDto productDto){
        //映射后设置当前时间为createTime
        productDto.setCreateTime(new Date());
    }
}
