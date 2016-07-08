package com.kang.first.privateDemo;

/**
 * Created by Administrator on 2016/6/19.
 */
public class PrivateClass {

    public boolean callPrivateMethod(){
        return isExist();
    }

    private boolean isExist(){
        return false;
    }
}
