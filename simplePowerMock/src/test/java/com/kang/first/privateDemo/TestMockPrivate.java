package com.kang.first.privateDemo;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * Created by Administrator on 2016/6/19.
 */
@RunWith(PowerMockRunner.class)
public class TestMockPrivate {

    public void testCallPrivateMethod() throws Exception {
        PrivateClass privateClass =  PowerMockito.mock(PrivateClass.class);//模拟对象
        PowerMockito.when(privateClass.callPrivateMethod()).thenCallRealMethod();//调用真实方法
        PowerMockito.when(privateClass,"isExist").thenReturn(true);//当调用私有方法isExist()模拟返回true
        Assert.assertTrue(privateClass.callPrivateMethod());//执行模拟
    }
}
