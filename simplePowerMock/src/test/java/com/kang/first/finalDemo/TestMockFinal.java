package com.kang.first.finalDemo;

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
public class TestMockFinal {

    @Test
    @PrepareForTest(FinalClass.class)
    public void testCallFinal(){
        FinalClass  finalClass = PowerMockito.mock(FinalClass.class);//模拟对象
        PowerMockito.when(finalClass.isAlive()).thenReturn(true);//模拟对象行为
        CallFinalClass  callFinalClass = new CallFinalClass();
        Assert.assertTrue(callFinalClass.callFinalMethod(finalClass));//执行模拟
    }
}
