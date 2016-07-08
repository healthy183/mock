package com.kang.first.simple;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.File;

/**
 * Created by Administrator on 2016/6/19.
 */
@RunWith(PowerMockRunner.class)
public class TestMockFile {

    @Test
    @PrepareForTest(MockFile.class)
    public void testCallInternalInstance() throws Exception {
        File file = PowerMockito.mock(File.class);//模拟File对象
        PowerMockito.whenNew(File.class).withArguments("bbb").thenReturn(file);//当构造bbb的File对象则返回file
        PowerMockito.when(file.exists()).thenReturn(true);//当调用file.exists()时模拟true
        MockFile mockFile  = new MockFile();
        Assert.assertTrue(mockFile.callInternalInstance("bbb"));//执行模拟
    }
}
