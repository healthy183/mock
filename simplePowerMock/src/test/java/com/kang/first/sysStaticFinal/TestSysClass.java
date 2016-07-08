package com.kang.first.sysStaticFinal;

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
public class TestSysClass {

    @Test
    @PrepareForTest(SystemClass.class)
    public void testSys() throws Exception {
        SystemClass systemClass = new SystemClass();
        /**/
        PowerMockito.mockStatic(System.class);
        PowerMockito.when(System.getProperty("aaa")).thenReturn("bbb");
        Assert.assertEquals("bbb",systemClass.callSysStatic("aaa"));

        //String str = PowerMockito.mockStatic(String.class);
        //PowerMockito.when(String.).thenReturn("bbb");
        //String str =  PowerMockito.mock(String.class);
        //PowerMockito.whenNew(String.class).withArguments("aa").thenReturn(str);
        //PowerMockito.when(systemClass.callSysFinal("aa")).thenReturn(true);
        //Assert.assertTrue(systemClass.callSysFinal("aa"));
    }

}
