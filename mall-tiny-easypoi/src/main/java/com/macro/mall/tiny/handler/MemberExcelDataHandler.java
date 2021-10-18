package com.macro.mall.tiny.handler;

import cn.afterturn.easypoi.handler.impl.ExcelDataHandlerDefaultImpl;
import cn.hutool.core.util.StrUtil;
import com.macro.mall.tiny.domain.Member;

/**
 * 自定义字段处理
 * Created by macro on 2021/10/13.
 */
public class MemberExcelDataHandler extends ExcelDataHandlerDefaultImpl<Member> {

    @Override
    public Object exportHandler(Member obj, String name, Object value) {
        if("昵称".equals(name)){
            String emptyValue = "暂未设置";
            if(value==null){
                return super.exportHandler(obj,name,emptyValue);
            }
            if(value instanceof String&&StrUtil.isBlank((String) value)){
              return super.exportHandler(obj,name,emptyValue);
            }
        }
        return super.exportHandler(obj, name, value);
    }

    @Override
    public Object importHandler(Member obj, String name, Object value) {
        return super.importHandler(obj, name, value);
    }
}
