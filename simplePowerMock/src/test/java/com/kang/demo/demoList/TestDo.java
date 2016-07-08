package com.kang.demo.demoList;

import org.junit.Assert;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;

/**
 * Created by Administrator on 2016/6/22.
 */
public class TestDo {
    /****
     * PowerMockito.doNothing方法告诉PowerMock下一个方法调用时什么也不做。
      PowerMockito.doThrow方法告诉PowerMock下一个方法调用时产生异常。
      PowerMock使用自定义类加载器和字节码操作来模拟静态方法。对于实例中没有mock的方法，也有默认返回值，比如返回int类型的方法，默认返回0。
     * PowerMockito.doNothing和PowerMockito.doThrow的语法可用于实例方法
     * */
    @Test
    public void donothing(){
        Employee employee = PowerMockito.mock(Employee.class);
        PowerMockito.doNothing().when(employee).save();
        try{
            employee.save();
        }catch(UnsupportedOperationException ex){
            Assert.fail("should not throw any exception!");
        }
    }
    @Test(expected = UnsupportedOperationException.class)
    public void doThrow(){
        Employee employee =  PowerMockito.mock(Employee.class);
        PowerMockito.doThrow(new UnsupportedOperationException()).when(employee).save();
        employee.save();
    }

}
