package com.kang.demo.suppress;

import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.core.classloader.annotations.SuppressStaticInitializationFor;
import org.powermock.modules.junit4.PowerMockRunner;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import static org.junit.Assert.*;

/*
*
PowerMockito.suppress(PowerMockito.constructor(BaseEntity.class));表示禁用BaseEntity的构造函数。PowerMockito.suppress(PowerMockito.constructor(BaseEntity.class, String.class, Integer.class))后面表示带字符串和整数参数。

PowerMockito.suppress(PowerMockito.method(BaseEntity.class, "performAudit", String.class))表示禁用BaseEntity的performAudit方法。

@SuppressStaticInitializationFor("BaseEntity")表示禁用BaseEntity的静态初始化。注意引号部分通常需要全名，比如"com.gitshah.powermock.BaseEntity"。

PowerMockito.suppress(PowerMockito.field(BaseEntity.class,"identifier"))：禁用域。
* */
/**
 * Created by Administrator on 2016/7/2.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(Department.class)
@SuppressStaticInitializationFor("BaseEntity")
public class DepartmentTest {

    @Test
    public void shouldSuppressTheBaseConstructorOfDepartment() {
        PowerMockito.suppress(PowerMockito.constructor(BaseEntity.class));
        assertEquals(10, new Department(10).getDepartmentId());
    }

    @Test
    public void shouldSuppressThePerformAuditMethodOfBaseEntity() {
        PowerMockito.suppress(PowerMockito.constructor(BaseEntity.class));
        PowerMockito.suppress(PowerMockito.method(BaseEntity.class, "performAudit", String.class));
        final Department department = new Department(18);
        department.setName("Mocking with PowerMock");
        assertEquals("Mocking with PowerMock", department.getName());
    }

    @Test
    public void shouldSuppressTheInitializerForBaseEntity() {

        PowerMockito.suppress(PowerMockito.constructor(BaseEntity.class));
        assertNotNull(new Department(18));
    }
}
