package com.macro.mall.tiny.controller;

import com.macro.mall.tiny.common.api.CommonResult;
import com.macro.mall.tiny.domain.Product;
import com.macro.mall.tiny.repository.ProductRepository;
import com.macro.mall.tiny.util.LocalJsonUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * 使用Redis OM管理商品
 * Created by macro on 2022/3/1.
 */
@RestController
@Api(tags = "ProductController", description = "使用Redis OM管理商品")
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @ApiOperation("导入商品")
    @PostMapping("/import")
    public CommonResult importList() {
        productRepository.deleteAll();
        List<Product> productList = LocalJsonUtil.getListFromJson("json/products.json", Product.class);
        for (Product product : productList) {
            productRepository.save(product);
        }
        return CommonResult.success(null);
    }

    @ApiOperation("创建商品")
    @PostMapping("/create")
    public CommonResult create(@RequestBody Product entity) {
        productRepository.save(entity);
        return CommonResult.success(null);
    }

    @ApiOperation("删除")
    @PostMapping("/delete/{id}")
    public CommonResult delete(@PathVariable Long id) {
        productRepository.deleteById(id);
        return CommonResult.success(null);
    }

    @ApiOperation("查询单个")
    @GetMapping("/detail/{id}")
    public CommonResult<Product> detail(@PathVariable Long id) {
        Optional<Product> result = productRepository.findById(id);
        return CommonResult.success(result.orElse(null));
    }

    @ApiOperation("分页查询")
    @GetMapping("/page")
    public CommonResult<List<Product>> page(@RequestParam(defaultValue = "1") Integer pageNum,
                                            @RequestParam(defaultValue = "5") Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
        Page<Product> pageResult = productRepository.findAll(pageable);
        return CommonResult.success(pageResult.getContent());
    }

    @ApiOperation("根据品牌查询")
    @GetMapping("/getByBrandName")
    public CommonResult<List<Product>> getByBrandName(String brandName) {
        List<Product> resultList = productRepository.findByBrandName(brandName);
        return CommonResult.success(resultList);
    }

    @ApiOperation("根据名称或副标题搜索")
    @GetMapping("/search")
    public CommonResult<List<Product>> search(String keyword) {
        List<Product> resultList = productRepository.findByNameOrSubTitle(keyword, keyword);
        return CommonResult.success(resultList);
    }

}
