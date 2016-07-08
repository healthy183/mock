package com.kang.mockSimple;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/6.
 */
public class SpyTest {

    //使用spy来监控真实的对象，需要注意的是此时我们需要谨慎的使用when-then语句，而改用do-when语句
    @Test
    public void mainTest(){
        List list = new LinkedList();
        List spyList =  Mockito.spy(list);
        //下标越界,因为调用了真实对象
        //Mockito.when(spyList.get(0)).thenReturn(3);
        Mockito.doReturn(999).when(spyList).get(999);
        Assert.assertEquals(spyList.get(999),999);

        // //调用真实对象的api
        spyList.add(1);
        spyList.add(2);
        spyList.add(3);
        Assert.assertEquals(spyList.get(0),1);
        Assert.assertEquals(spyList.get(1),2);
        Assert.assertEquals(spyList.get(2),3);

        Mockito.verify(spyList).add(1);
        Mockito.verify(spyList).add(2);

        Mockito.when(spyList.size()).thenReturn(100);
        Assert.assertEquals(spyList.size(),100);
        //IndexOutOfBoundsException.class
        //spyList.get(3);
    }

    @Test
    public void testAnswer(){
      List mockList =  Mockito.mock(List.class,new Answer(){
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                return 999;
            }
        });
        Mockito.when(mockList.get(2)).thenReturn(2);
        Assert.assertEquals(mockList.size(),999);//没有模拟,默认返回answer
        Assert.assertEquals(mockList.get(0),999);
        Assert.assertEquals(mockList.get(2),2);
    }

}
