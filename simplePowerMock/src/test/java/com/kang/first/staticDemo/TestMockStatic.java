package com.kang.first.staticDemo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * Created by Administrator on 2016/6/19.
 */
@RunWith(PowerMockRunner.class)
public class TestMockStatic {

    @Test
    @PrepareForTest(StaticClass.class)
    public void testCallStaticMethod(){
        PowerMockito.mockStatic(StaticClass.class);//模拟类
        PowerMockito.when(StaticClass.isExist()).thenReturn(true);//模拟true
        CallStaticClass callStaticClass  = new CallStaticClass();
        Assert.assertTrue(callStaticClass.clallStaticMethod());
    }
}
