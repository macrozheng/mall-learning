package com.macro.mall.tiny.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @auther macrozheng
 * @description 文件上传返回结果
 * @date 2019/12/25
 * @github https://github.com/macrozheng
 */
@Data
@EqualsAndHashCode
public class MinioUploadDto {
    @ApiModelProperty("文件访问URL")
    private String url;
    @ApiModelProperty("文件名称")
    private String name;
}
