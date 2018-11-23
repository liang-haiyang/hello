package com.liang.guava;

import com.google.common.eventbus.Subscribe;

import javax.swing.event.ChangeEvent;

/**
 * @author lianghaiyang
 * @date 2018/09/05
 */
public class EventBusSusbcriber {
    @Subscribe
    public void subcriber(ChangeEvent event){
        System.out.println("订阅成功!!!");
    }
}
