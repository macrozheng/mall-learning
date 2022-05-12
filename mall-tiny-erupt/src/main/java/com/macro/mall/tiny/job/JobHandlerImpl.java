package com.macro.mall.tiny.job;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import xyz.erupt.job.handler.EruptJobHandler;

/**
 * Created by macro on 2021/4/13.
 */
@Service
@Slf4j
public class JobHandlerImpl implements EruptJobHandler {
    @Override
    public String exec(String code, String param) throws Exception {
        log.info("定时任务已经执行，code:{},param:{}",code,param);
        return "success";
    }
}
