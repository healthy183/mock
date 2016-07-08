package com.kang.demo.suppress;

/**
 * Created by Administrator on 2016/7/2.
 */
public class BaseEntity {


    static {
        String x = null;
        x.toString();
    }

    public BaseEntity() {
        throw new UnsupportedOperationException();
    }

    protected void performAudit(String auditInformation) {
        throw new UnsupportedOperationException();
    }
}
