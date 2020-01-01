package com.macro.mall.tiny.dto;

/**
 * 文件上传返回结果
 * Created by macro on 2019/12/25.
 */
public class MinioUploadDto {
    private String url;
    private String name;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
