package com.kang.mockito.spring.service;

import com.kang.mockito.spring.dao.PrivateUserDao;
import com.kang.mockito.spring.domain.UserDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/7/6.
 */
@Service
public class PrivateUserService {
    @Autowired
    private PrivateUserDao privateUserDao;

    public List<UserDomain> queryAll(){
      return  privateUserDao.selectAll();
    }

    public List<UserDomain> querySpy(){
        List<UserDomain> list =  privateUserDao.selectAll();
        list.addAll(privateUserDao.selectTom());
        return list;
    }
}
