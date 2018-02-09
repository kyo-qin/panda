package com.tao.panda.common.disriptor.example;

import com.lmax.disruptor.EventHandler;

/**
 * @Description Consumer
 * @ClassName LongEventHandler
 * @Copyright 炫彩互动
 * @Project panda-common
 * @Author ota
 * @Create Date 2017年12月11日
 */
public class LongEventHandler implements EventHandler<LongEvent> {

    @Override
    public void onEvent(LongEvent event, long sequence, boolean endOfBatch) throws Exception {
        System.out.println("Event: " + event);
    }

}
