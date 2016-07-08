package com.kang.mockSimple;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

/**
 * Created by Administrator on 2016/7/6.
 */
public class Reset {

    @Test
    public void mainTest(){
        List list = Mockito.mock(List.class);
        Mockito.when(list.size()).thenReturn(10);
        list.add(1);
        Assert.assertEquals(10,list.size());
        //重置mock，清除所有的互动和预设
        Mockito.reset(list);
        Assert.assertEquals(0,list.size());
    }
}
