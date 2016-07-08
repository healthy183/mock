package com.kang.mockSimple.annotation;

import lombok.Data;
import lombok.ToString;

/**
 * Created by Administrator on 2016/7/5.
 */
@Data
@ToString
public class Person {
    private final Integer personID;
    private final String personName;
    public Person( Integer personID, String personName ) {
        this.personID = personID;
        this.personName = personName;
    }
}
