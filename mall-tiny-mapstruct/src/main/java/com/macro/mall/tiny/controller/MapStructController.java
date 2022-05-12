package com.macro.mall.tiny.controller;

import com.macro.mall.tiny.common.api.CommonResult;
import com.macro.mall.tiny.dto.MemberDto;
import com.macro.mall.tiny.dto.MemberOrderDto;
import com.macro.mall.tiny.dto.OrderDto;
import com.macro.mall.tiny.dto.ProductDto;
import com.macro.mall.tiny.exception.ProductValidatorException;
import com.macro.mall.tiny.mapper.*;
import com.macro.mall.tiny.po.Member;
import com.macro.mall.tiny.po.Order;
import com.macro.mall.tiny.po.Product;
import com.macro.mall.tiny.util.LocalJsonUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

/**
 * MapStruct对象转换测试Controller
 * Created by macro on 2021/10/21.
 */
@RestController
@Api(tags = "MapStructController", description = "MapStruct对象转换测试")
@RequestMapping("/mapStruct")
public class MapStructController {

    @Autowired
    private MemberSpringMapper memberSpringMapper;

    @ApiOperation(value = "基本映射")
    @GetMapping("/baseMapping")
    public CommonResult baseTest() {
        List<Member> memberList = LocalJsonUtil.getListFromJson("json/members.json", Member.class);
        MemberDto memberDto = MemberMapper.INSTANCE.toDto(memberList.get(0));
        return CommonResult.success(memberDto);
    }

    @ApiOperation(value = "集合映射")
    @GetMapping("/collectionMapping")
    public CommonResult collectionMapping() {
        List<Member> memberList = LocalJsonUtil.getListFromJson("json/members.json", Member.class);
        List<MemberDto> memberDtoList = MemberMapper.INSTANCE.toDtoList(memberList);
        return CommonResult.success(memberDtoList);
    }

    @ApiOperation(value = "子对象映射")
    @GetMapping("/subMapping")
    public CommonResult subMapping() {
        List<Order> orderList = getOrderList();
        OrderDto orderDto = OrderMapper.INSTANCE.toDto(orderList.get(0));
        return CommonResult.success(orderDto);
    }

    @ApiOperation(value = "组合映射")
    @GetMapping("/compositeMapping")
    public CommonResult compositeMapping() {
        List<Order> orderList = LocalJsonUtil.getListFromJson("json/orders.json", Order.class);
        List<Member> memberList = LocalJsonUtil.getListFromJson("json/members.json", Member.class);
        Member member = memberList.get(0);
        Order order = orderList.get(0);
        MemberOrderDto memberOrderDto = MemberMapper.INSTANCE.toMemberOrderDto(member,order);
        return CommonResult.success(memberOrderDto);
    }

    @ApiOperation(value = "使用依赖注入")
    @GetMapping("/springMapping")
    public CommonResult springMapping() {
        List<Member> memberList = LocalJsonUtil.getListFromJson("json/members.json", Member.class);
        MemberDto memberDto = memberSpringMapper.toDto(memberList.get(0));
        return CommonResult.success(memberDto);
    }

    @ApiOperation(value = "使用常量、默认值和表达式")
    @GetMapping("/defaultMapping")
    public CommonResult defaultMapping() {
        List<Product> productList = LocalJsonUtil.getListFromJson("json/products.json", Product.class);
        Product product = productList.get(0);
        product.setId(100L);
        product.setCount(null);
        ProductDto productDto = ProductMapper.INSTANCE.toDto(product);
        return CommonResult.success(productDto);
    }

    @ApiOperation(value = "在映射前后进行自定义处理")
    @GetMapping("/customRoundMapping")
    public CommonResult customRoundMapping() {
        List<Product> productList = LocalJsonUtil.getListFromJson("json/products.json", Product.class);
        Product product = productList.get(0);
        product.setPrice(new BigDecimal(-1));
        ProductDto productDto = ProductRoundMapper.INSTANCE.toDto(product);
        return CommonResult.success(productDto);
    }

    @ApiOperation(value = "处理映射异常")
    @GetMapping("/exceptionMapping")
    public CommonResult exceptionMapping() {
        List<Product> productList = LocalJsonUtil.getListFromJson("json/products.json", Product.class);
        Product product = productList.get(0);
        product.setPrice(new BigDecimal(-1));
        ProductDto productDto = null;
        try {
            productDto = ProductExceptionMapper.INSTANCE.toDto(product);
        } catch (ProductValidatorException e) {
            e.printStackTrace();
        }
        return CommonResult.success(productDto);
    }

    private List<Order> getOrderList() {
        List<Order> orderList = LocalJsonUtil.getListFromJson("json/orders.json", Order.class);
        List<Product> productList = LocalJsonUtil.getListFromJson("json/products.json", Product.class);
        List<Member> memberList = LocalJsonUtil.getListFromJson("json/members.json", Member.class);
        for (int i = 0; i < orderList.size(); i++) {
            Order order = orderList.get(i);
            order.setMember(memberList.get(i));
            order.setProductList(productList);
        }
        return orderList;
    }
}
