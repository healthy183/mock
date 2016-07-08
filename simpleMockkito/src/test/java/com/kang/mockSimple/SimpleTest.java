package com.kang.mockSimple;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/7/4.
 */
public class SimpleTest {

    @Test
    public void firstTest(){
        List<String> list =  Mockito.mock(List.class);//模拟对象
        Mockito.when(list.get(0)).thenReturn("helloworld");//模拟行为
        //doReturn("secondhello").when(list).get(0);  //另一种写法
        String result = list.get(0);
        Mockito.verify(list).get(0);//验证是否调用list.get(0)
        Assert.assertEquals("helloworld", result);//断言输出
    }

    @Test(expected = RuntimeException.class)
    public void whenThenException(){
        List<String> list =  Mockito.mock(List.class);//模拟对象
        Mockito.when(list.get(1)).thenThrow(new RuntimeException("test excpetion"));
        String result = list.get(1);
    }

    @Test
    public void doubleCall(){
        List<String> list =  Mockito.mock(List.class);//模拟对象
        Mockito.doNothing().doThrow(new RuntimeException("test excpetion")).when(list).clear();;
        list.clear();
        list.clear();
        //Mockito.verify(list,Mockito.times(2)).clear();//验证


    }

    @Test(expected = RuntimeException.class)
    public void doubleCallV2(){
        List<String> list =  Mockito.mock(List.class);//模拟对象
        Mockito.when(list.get(0)).thenReturn(null).thenThrow(new RuntimeException("test excpetion"));
        Assert.assertNull(list.get(0));
        list.get(0);
    }

    @Test
    public void argumentMatcherTest(){
        List<String> list = Mockito.mock(List.class);
        Mockito.when(list.get(Mockito.anyInt())).thenReturn("hello","world");
        String result = list.get(0)+list.get(1);
        String anyStr = Mockito.verify(list,Mockito.times(2)).get( Mockito.anyInt());
        System.out.println("anyStr:"+ anyStr);
        Assert.assertEquals("helloworld", result);
    }

    @Test
    public void argument(){
        Map<Integer,String> map = Mockito.mock(Map.class);
        Mockito.when(map.put(Mockito.anyInt(),Mockito.anyString())).thenReturn("hello");
        String str = map.put(1, "world");
        Assert.assertEquals("hello",str);
        Mockito.verify(map).put(Mockito.eq(1), Mockito.eq("world"));
    }

    @Test
    public void verifyInvocate(){
        List<String> mockedList = Mockito.mock(List.class);
        mockedList.add("once");
        mockedList.add("twice");
        mockedList.add("twice");
        mockedList.add("three times");
        mockedList.add("three times");
        mockedList.add("three times");

        Mockito.verify(mockedList).add("once");//验证是否调用一次
        Mockito.verify(mockedList,Mockito.times(1)).add("once");////默认调用一次,times(1)可以省略

        Mockito.verify(mockedList, Mockito.times(2)).add("twice");
        Mockito.verify(mockedList, Mockito.times(3)).add("three times");

        Mockito.verify(mockedList, Mockito.times(0)).add("never happened");

        Mockito.verify(mockedList, Mockito.atLeastOnce()).add("three times");
        Mockito.verify(mockedList, Mockito.atLeast(2)).add("twice");
        Mockito.verify(mockedList, Mockito.atMost(5)).add("three times");
    }
}
