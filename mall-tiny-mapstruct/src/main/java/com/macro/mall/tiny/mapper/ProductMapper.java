package com.macro.mall.tiny.mapper;

import com.macro.mall.tiny.dto.ProductDto;
import com.macro.mall.tiny.po.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.UUID;

/**
 * 商品对象映射
 * Created by macro on 2021/10/21.
 */
@Mapper(imports = {UUID.class})
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(target = "id",constant = "-1L")
    @Mapping(source = "count",target = "count",defaultValue = "1")
    @Mapping(target = "productSn",expression = "java(UUID.randomUUID().toString())")
    ProductDto toDto(Product product);
}
