package com.kang.mockito.spring.mainTest;

import com.kang.mockito.spring.dao.PrivateUserDao;
import com.kang.mockito.spring.domain.UserDomain;
import com.kang.mockito.spring.service.PrivateUserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/6.
 */

public class TestMock  extends  BaseTest{

    //@InjectMocks的问题是：如果被测试类是代理类，那么注入会失效。
    //比如下面的UserService如果是事务或者其他AOP代理类，
    //那么进入@Test方法时UserService中的DAO属性不会被Mock类替换。
    @InjectMocks
    @Autowired
    private PrivateUserService privateUserService;
    @Mock
    private PrivateUserDao privateUserDao;
    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testQueryAll(){
        List<UserDomain> userDomainList =  new ArrayList<UserDomain>();
        userDomainList.add(new UserDomain());
        Mockito.when(privateUserDao.selectAll()).thenReturn(userDomainList);


        List<UserDomain> dtoList = privateUserService.queryAll();
        Assert.assertTrue(dtoList.size() == 1);
    }
}
