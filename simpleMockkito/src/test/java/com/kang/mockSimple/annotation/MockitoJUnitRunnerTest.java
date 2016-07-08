package com.kang.mockSimple.annotation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

/**
 * Created by Administrator on 2016/7/6.
 */
@RunWith(MockitoJUnitRunner.class)
public class MockitoJUnitRunnerTest {

    @Mock
    private List mockList;
    @Test
    public void shorthand(){
        mockList.add(1);
        Mockito.verify(mockList).add(1);
    }
}
