package com.macro.mall.tiny.remote;

import com.github.lianjiatech.retrofit.spring.boot.annotation.Intercept;
import com.github.lianjiatech.retrofit.spring.boot.annotation.RetrofitClient;
import com.macro.mall.tiny.common.api.CommonPage;
import com.macro.mall.tiny.common.api.CommonResult;
import com.macro.mall.tiny.component.TokenInterceptor;
import com.macro.mall.tiny.domain.PmsBrand;
import retrofit2.http.*;

/**
 * 定义Http接口，用于调用远程的PmsBrand服务
 * Created by macro on 2022/1/19.
 */
@RetrofitClient(baseUrl = "${remote.baseUrl}")
@Intercept(handler = TokenInterceptor.class, include = "/brand/**")
public interface PmsBrandApi {
    @GET("brand/list")
    CommonResult<CommonPage<PmsBrand>> list(@Query("pageNum") Integer pageNum, @Query("pageSize") Integer pageSize);

    @GET("brand/{id}")
    CommonResult<PmsBrand> detail(@Path("id") Long id);

    @POST("brand/create")
    CommonResult create(@Body PmsBrand pmsBrand);

    @POST("brand/update/{id}")
    CommonResult update(@Path("id") Long id, @Body PmsBrand pmsBrand);

    @GET("brand/delete/{id}")
    CommonResult delete(@Path("id") Long id);
}
