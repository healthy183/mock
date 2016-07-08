package com.kang.mockito.spring.dao;

import com.kang.mockito.spring.domain.UserDomain;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/6.
 */
@Repository
public class PrivateUserDao {

    public List<UserDomain> selectAll(){
        return null;
    }

    public List<UserDomain> selectTom(){
        List<UserDomain> userDomainList =  new ArrayList<UserDomain>();
        userDomainList.add(new UserDomain());
        return userDomainList;
    }

}
