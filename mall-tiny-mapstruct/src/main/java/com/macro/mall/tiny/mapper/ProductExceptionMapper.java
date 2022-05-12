package com.macro.mall.tiny.mapper;

import com.macro.mall.tiny.dto.ProductDto;
import com.macro.mall.tiny.exception.ProductValidatorException;
import com.macro.mall.tiny.po.Product;
import com.macro.mall.tiny.validator.ProductValidator;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.UUID;

/**
 * 商品对象映射（处理映射异常）
 * Created by macro on 2021/10/21.
 */
@Mapper(uses = {ProductValidator.class},imports = {UUID.class})
public interface ProductExceptionMapper {
    ProductExceptionMapper INSTANCE = Mappers.getMapper(ProductExceptionMapper.class);

    @Mapping(target = "id",constant = "-1L")
    @Mapping(source = "count",target = "count",defaultValue = "1")
    @Mapping(target = "productSn",expression = "java(UUID.randomUUID().toString())")
    ProductDto toDto(Product product) throws ProductValidatorException;
}
