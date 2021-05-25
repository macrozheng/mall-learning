package com.macro.mall.tiny.model;

import org.hibernate.annotations.GenericGenerator;
import xyz.erupt.annotation.Erupt;
import xyz.erupt.annotation.EruptField;
import xyz.erupt.annotation.sub_field.Edit;
import xyz.erupt.annotation.sub_field.EditType;
import xyz.erupt.annotation.sub_field.View;
import xyz.erupt.annotation.sub_field.sub_edit.AttachmentType;
import xyz.erupt.annotation.sub_field.sub_edit.Search;

import javax.persistence.*;

@Erupt(name = "商品品牌")
@Table(name = "pms_brand")
@Entity
public class PmsBrand {

    @Id
    @GeneratedValue(generator = "generator")
    @GenericGenerator(name = "generator", strategy = "native")
    @Column(name = "id")
    @EruptField
    private Long id;

    @EruptField(
            views = @View(title = "品牌名称"),
            edit = @Edit(title = "品牌名称",notNull=true,search = @Search(vague = true))
    )
    private String name;

    @EruptField(
            views = @View(title = "品牌首字母"),
            edit = @Edit(title = "品牌首字母",notNull=true)
    )
    private String firstLetter;

    @EruptField(
            views = @View(title = "品牌LOGO"),
            edit = @Edit(title = "品牌LOGO", type = EditType.ATTACHMENT,
                    attachmentType = @AttachmentType(type = AttachmentType.Type.IMAGE))
    )
    private String logo;

    @EruptField(
            views = @View(title = "品牌专区大图"),
            edit = @Edit(title = "品牌专区大图", type = EditType.ATTACHMENT,
                    attachmentType = @AttachmentType(type = AttachmentType.Type.IMAGE))
    )
    private String bigPic;

    @EruptField(
            views = @View(title = "品牌故事"),
            edit = @Edit(title = "品牌故事")
    )
    private String brandStory;

    @EruptField(
            views = @View(title = "排序"),
            edit = @Edit(title = "排序")
    )
    private Integer sort;

    @EruptField(
            views = @View(title = "是否显示"),
            edit = @Edit(title = "是否显示")
    )
    private Boolean showStatus;

    @EruptField(
            views = @View(title = "品牌制造商"),
            edit = @Edit(title = "品牌制造商")
    )
    private Boolean factoryStatus;

    private Integer productCount;

    private Integer productCommentCount;

}