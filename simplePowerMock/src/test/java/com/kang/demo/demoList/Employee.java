package com.kang.demo.demoList;

/**
 * Created by Administrator on 2016/6/20.
 */
public class Employee {

    private long salary;
    public long getSalary() {
        return salary;
    }

    public void setSalary(int i) {
        salary = i;
    }
    public void save(){
        throw new UnsupportedOperationException();
    }

    public static int count() {
        throw new UnsupportedOperationException();
    }

    public static void giveIncrementOf(int percentage) {
        throw new UnsupportedOperationException();
    }

    public boolean isNew() {
        throw new UnsupportedOperationException();
    }

    public void update() {
        throw new UnsupportedOperationException();
    }

    public void create() {
        throw new UnsupportedOperationException();
    }

    public void setEmployeeId(int nextId) {
        throw new UnsupportedOperationException();
    }
}
