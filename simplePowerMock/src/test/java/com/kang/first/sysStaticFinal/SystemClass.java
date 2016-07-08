package com.kang.first.sysStaticFinal;

/**
 * Created by Administrator on 2016/6/19.
 */
public class SystemClass {

    public boolean callSysFinal(String str){
        return str.isEmpty();
    }

    public String callSysStatic(String str){
        return System.getProperty(str);
    }
}
