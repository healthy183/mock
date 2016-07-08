package com.kang.mockSimple;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.Mockito;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 2016/7/5.
 */
public class DemoTest {

    @Test
    public void doubleRuturn(){
        Iterator iterator =  Mockito.mock(Iterator.class);
        //第一次返回tom 以后都返回cat
        Mockito.when(iterator.next()).thenReturn("tom").thenReturn("cat");
        Assert.assertEquals(iterator.next(),"tom");
        Assert.assertEquals(iterator.next(),"cat");
        Assert.assertEquals(iterator.next(),"cat");
    }

    @Test
    public void argComparable(){
        Comparable comparable = Mockito.mock(Comparable.class);
        Mockito.when(comparable.compareTo("tom")).thenReturn(1);
        Mockito.when(comparable.compareTo("cat")).thenReturn(2);
        Assert.assertEquals(1, comparable.compareTo("tom"));
        Assert.assertEquals(2, comparable.compareTo("cat"));
        ///没有模拟就返回默认值
        Assert.assertEquals(0, comparable.compareTo("Not stub"));
    }

    @Test
    public void withValidateArg(){
        List list = Mockito.mock(List.class);
        Mockito.when(list.get(Mockito.anyInt())).thenReturn(1);
        Assert.assertEquals(1, list.get(1));
        Assert.assertEquals(1, list.get(999));

        Mockito.when(list.contains(Mockito.argThat(new IsValid()))).thenReturn(true);
        Assert.assertTrue(list.contains(1));
        Assert.assertTrue(!list.contains(3));
    }

    @Test
    public void testCompare(){
        Comparator comparator = Mockito.mock(Comparator.class);
        int i =  comparator.compare("nihao","hello");
        //如果你使用了参数匹配，那么所有的参数都必须通过matchers来匹配
        Mockito.verify(comparator).compare(Mockito.anyString(),Mockito.eq("hello"));
        //下面的为无效的参数匹配使用
        //Mockito.verify(comparator).compare(Mockito.anyString(),"hello");
    }

}

class IsValid extends ArgumentMatcher<List>{
    @Override
    public boolean matches(Object o) {
        return o == (Object)1 || o == (Object)2;
    }
}

