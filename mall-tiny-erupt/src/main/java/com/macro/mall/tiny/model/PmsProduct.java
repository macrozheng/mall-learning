package com.macro.mall.tiny.model;

import org.springframework.data.mongodb.core.mapping.Document;
import xyz.erupt.annotation.Erupt;
import xyz.erupt.annotation.EruptField;
import xyz.erupt.annotation.sub_field.Edit;
import xyz.erupt.annotation.sub_field.EditType;
import xyz.erupt.annotation.sub_field.View;
import xyz.erupt.annotation.sub_field.sub_edit.AttachmentType;
import xyz.erupt.annotation.sub_field.sub_edit.BoolType;
import xyz.erupt.annotation.sub_field.sub_edit.Search;
import xyz.erupt.core.annotation.EruptDataProcessor;
import xyz.erupt.mongodb.EruptMongodbImpl;

import javax.persistence.Id;
import java.util.Date;

/**
 * Created by macro on 2021/4/13.
 */
@EruptDataProcessor(EruptMongodbImpl.MONGODB_PROCESS)  //此注解表示使用MongoDB来存储数据
@Document(collection = "product")
@Erupt(
        name = "商品管理",
        orderBy = "sort"
)
public class PmsProduct {
    @Id
    @EruptField
    private String id;

    @EruptField(
            views = @View(title = "商品名称", sortable = true),
            edit = @Edit(title = "商品名称", search = @Search(vague = true))
    )
    private String name;

    @EruptField(
            views = @View(title = "副标题", sortable = true),
            edit = @Edit(title = "副标题", search = @Search(vague = true))
    )
    private String subTitle;

    @EruptField(
            views = @View(title = "价格", sortable = true),
            edit = @Edit(title = "价格")
    )
    private Double price;

    @EruptField(
            views = @View(title = "商品图片"),
            edit = @Edit(title = "商品图片", type = EditType.ATTACHMENT,
                    attachmentType = @AttachmentType(type = AttachmentType.Type.IMAGE))
    )
    private String pic;

    @EruptField(
            views = @View(title = "状态", sortable = true),
            edit = @Edit(title = "状态",
                    boolType = @BoolType(trueText = "上架", falseText = "下架"),
                    search = @Search)
    )
    private Boolean publishStatus;

    @EruptField(
            views = @View(title = "创建时间", sortable = true),
            edit = @Edit(title = "创建时间", search = @Search(vague = true))
    )
    private Date createTime;
}
