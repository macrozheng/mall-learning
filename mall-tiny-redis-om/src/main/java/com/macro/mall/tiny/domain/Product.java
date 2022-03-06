package com.macro.mall.tiny.domain;

import com.redis.om.spring.annotations.Document;
import com.redis.om.spring.annotations.Indexed;
import com.redis.om.spring.annotations.Searchable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;

/**
 * 商品实体类
 * Created by macro on 2021/10/12.
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Document(language = "chinese")
public class Product {
    @Id
    private Long id;
    @Indexed
    private String productSn;
    @Searchable
    private String name;
    @Searchable
    private String subTitle;
    @Indexed
    private String brandName;
    @Indexed
    private Integer price;
    @Indexed
    private Integer count;
}
