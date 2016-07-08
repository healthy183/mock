package com.kang.first.simple;

import java.io.File;

/**
 * Created by Administrator on 2016/6/19.
 */
public class MockFile {

    public boolean callInternalInstance(String path){
        File file = new File(path);
        return file.exists();
    }
}
