package com.kang.mockSimple;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/6.
 */
public class RealCallMethod {
    //调用真实方法
    @Test
    public void realCall(){
        List list = Mockito.spy(new ArrayList());
        Assert.assertEquals(0,list.size());

        A a =  Mockito.mock(A.class);
        Mockito.when(a.doSomething(Mockito.anyInt())).thenCallRealMethod();
        Assert.assertEquals(1,a.doSomething(1));
    }
}

class A{
    public int doSomething(int i){
        return i;
    }
}
