package com.tao.panda.common.disriptor.example;

import com.lmax.disruptor.EventFactory;

/**
 * @Description 创建产品实例
 * @ClassName LongEventFactory
 * @Copyright 炫彩互动
 * @Project panda-common
 * @Author ota
 * @Create Date 2017年12月11日
 */
public class LongEventFactory implements EventFactory<LongEvent> {

    @Override
    public LongEvent newInstance() {
        return new LongEvent();
    }

}
