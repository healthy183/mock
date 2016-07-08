package com.kang.mockito.spring.mainTest;

import com.kang.mockito.spring.dao.PrivateUserDao;
import com.kang.mockito.spring.domain.UserDomain;
import com.kang.mockito.spring.service.PrivateUserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/8.
 */
public class TestSpy  extends  BaseTest {
    @Spy
    @Autowired
    public PrivateUserDao privateUserDao;

    @InjectMocks
    @Autowired
    private PrivateUserService privateUserService;


    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void mainTest(){
        List<UserDomain> userDomainList =  new ArrayList<UserDomain>();
        userDomainList.add(new UserDomain());
        //PrivateUserDao  spyUserDao = Mockito.spy(privateUserDao);
        Mockito.doReturn(userDomainList).when(privateUserDao).selectAll();
        //Mockito.when(privateUserDao.selectAll()).thenReturn(userDomainList);
        List<UserDomain>  spyList =  privateUserService.querySpy();
        Assert.assertTrue(spyList.size() == 2);
    }

    @Test
    public void testAll(){
        List<String> strList = new ArrayList<String>();
        strList.addAll(null);
    }




}
