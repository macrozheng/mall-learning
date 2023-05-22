package com.macro.mall.tiny.modules.pms.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 品牌表
 * </p>
 *
 * @author macro
 * @since 2023-02-07
 */
@Getter
@Setter
@TableName("pms_brand")
@ApiModel(value = "PmsBrand对象", description = "品牌表")
public class PmsBrand implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String name;

    @ApiModelProperty("首字母")
    private String firstLetter;

    private Integer sort;

    @ApiModelProperty("是否为品牌制造商：0->不是；1->是")
    private Integer factoryStatus;

    private Integer showStatus;

    @ApiModelProperty("产品数量")
    private Integer productCount;

    @ApiModelProperty("产品评论数量")
    private Integer productCommentCount;

    @ApiModelProperty("品牌logo")
    private String logo;

    @ApiModelProperty("专区大图")
    private String bigPic;

    @ApiModelProperty("品牌故事")
    private String brandStory;
}
