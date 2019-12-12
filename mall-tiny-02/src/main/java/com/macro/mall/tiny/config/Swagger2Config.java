package com.macro.mall.tiny.config;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger2API文档的配置
 *
 * 1,@Api：用于修饰Controller类，生成Controller相关文档信息
 * 2,@ApiOperation：用于修饰Controller类中的方法，生成接口方法相关文档信息
 * 3,@ApiParam：用于修饰接口中的参数，生成接口参数相关文档信息
 * 4,@ApiModelProperty：用于修饰实体类的属性，当实体类是请求参数或返回结果时，直接生成相关文档信息
 * 5,@ApiImplicitParam ：用在@ApiImplicitParams注解中，指定一个请求参数的各个方面
 *     paramType：参数放在哪个地方
 *         header-->请求参数的获取：@RequestHeader
 *         query-->请求参数的获取：@RequestParam
 *         path（用于restful接口）-->请求参数的获取：@PathVariable
 *         body（不常用）
 *         form（不常用）
 *     name：参数名
 *     dataType：参数类型
 *     required：参数是否必须传
 *     value：参数的意思
 *     defaultValue：参数的默认值
 * 6,@ApiResponses ：用于表示一组响应
 * 7,@ApiResponse ：用在@ApiResponses中，一般用于表达一个错误的响应信息
 *     code：数字，例如400
 *     message：信息，例如"请求参数没填好"
 *     response：抛出异常的类
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {
    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //为当前包下controller生成API文档
                .apis(RequestHandlerSelectors.basePackage("com.macro.mall.tiny.controller"))
//                为有@Api注解的Controller生成API文档
//                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                //为有@ApiOperation注解的方法生成API文档
//                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("SwaggerUI演示")
                .description("mall-tiny")
                .contact("macro")
                .version("1.0")
                .build();
    }
}
