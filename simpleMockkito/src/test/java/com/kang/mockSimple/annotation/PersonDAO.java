package com.kang.mockSimple.annotation;

/**
 * Created by Administrator on 2016/7/5.
 */
public interface  PersonDAO {

    public Person fetchPerson( Integer personID );
    public void update( Person person );
}
