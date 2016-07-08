package com.kang.demo.suppress;

/**
 * Created by Administrator on 2016/7/2.
 */
public class Department  extends BaseEntity {

    private int departmentId;
    private String name;

    public Department(int departmentId) {
        super();
        this.departmentId = departmentId;
    }

    public void setName(String name) {
        this.name = name;
        super.performAudit(this.name);
    }

    protected void performAudit(String auditInformation) {
        throw new UnsupportedOperationException();
    }

    public Object getDepartmentId() {
        return departmentId;
    }

    public Object getName() {
        return name;
    }
}
