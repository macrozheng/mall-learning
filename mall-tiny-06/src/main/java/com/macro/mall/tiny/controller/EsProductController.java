package com.macro.mall.tiny.controller;

import com.macro.mall.tiny.common.api.CommonPage;
import com.macro.mall.tiny.common.api.CommonResult;
import com.macro.mall.tiny.nosql.elasticsearch.document.EsProduct;
import com.macro.mall.tiny.service.EsProductService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 搜索商品管理Controller
 * Created by macro on 2018/6/19.
 */
@Controller
@Api(tags = "EsProductController", description = "搜索商品管理")
@RequestMapping("/esProduct")
public class EsProductController {
    @Autowired
    private EsProductService esProductService;

    @ApiOperation(value = "导入所有数据库中商品到ES")
    @RequestMapping(value = "/importAll", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<Integer> importAllList() {
        int count = esProductService.importAll();
        return CommonResult.success(count);
    }

    @ApiOperation(value = "根据id删除商品")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<Object> delete(@PathVariable Long id) {
        esProductService.delete(id);
        return CommonResult.success(null);
    }

    @ApiOperation(value = "根据id批量删除商品")
    @RequestMapping(value = "/delete/batch", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<Object> delete(@RequestParam("ids") List<Long> ids) {
        esProductService.delete(ids);
        return CommonResult.success(null);
    }

    @ApiOperation(value = "根据id创建商品")
    @RequestMapping(value = "/create/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<EsProduct> create(@PathVariable Long id) {
        EsProduct esProduct = esProductService.create(id);
        if (esProduct != null) {
            return CommonResult.success(esProduct);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation(value = "简单搜索")
    @RequestMapping(value = "/search/simple", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<EsProduct>> search(@RequestParam(required = false) String keyword,
                                                      @RequestParam(required = false, defaultValue = "0") Integer pageNum,
                                                      @RequestParam(required = false, defaultValue = "5") Integer pageSize) {
        Page<EsProduct> esProductPage = esProductService.search(keyword, pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(esProductPage));
    }

    @ApiOperation(value = "查询所有记录结果")
    @RequestMapping(value = "/search/all", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<EsProduct>> findAll() {
        List<EsProduct> esProducts = esProductService.findAll();
        return CommonResult.success(esProducts);
    }

    @ApiOperation(value = "模板方式进行的简单搜索")
    @RequestMapping(value = "/search/simple2", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<EsProduct>> search2(@ApiParam("查询参数") @RequestParam(required = false) String keyword) {
        List<EsProduct> esProductPage = esProductService.search2(keyword, keyword);
        return CommonResult.success(esProductPage);
    }

    @ApiOperation(value = "Query注解方式的简单搜索")
    @RequestMapping(value = "/search/simple3", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<EsProduct>> search3(@ApiParam("查询参数") @RequestParam(required = false) String keyword, @ApiParam("默认页码") @PageableDefault(size = 1,page = 0) Pageable pageable) {
        List<EsProduct> esProductPage = esProductService.queryName(keyword, keyword,pageable);
        return CommonResult.success(esProductPage);
    }

    @ApiOperation(value = "标准ElasticsearchRepository")
    @RequestMapping(value = "/search/simple4", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<EsProduct>> findByName(@ApiParam("查询参数") @RequestParam(required = false) String keyword, @ApiParam("默认页码") @PageableDefault(size = 1,page = 0) Pageable pageable) {
        List<EsProduct> esProductPage = esProductService.findByName(keyword,pageable);
        return CommonResult.success(esProductPage);
    }



}
