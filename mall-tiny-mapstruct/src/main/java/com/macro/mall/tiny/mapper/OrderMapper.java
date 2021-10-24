package com.macro.mall.tiny.mapper;

import com.macro.mall.tiny.dto.OrderDto;
import com.macro.mall.tiny.po.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * 订单对象映射
 * Created by macro on 2021/10/21.
 */
@Mapper(uses = {MemberMapper.class,ProductMapper.class})
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    @Mapping(source = "member",target = "memberDto")
    @Mapping(source = "productList",target = "productDtoList")
    OrderDto toDto(Order order);
}
