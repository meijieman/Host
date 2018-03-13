package com.hongfans.host;

import com.litesuits.orm.db.annotation.PrimaryKey;
import com.litesuits.orm.db.annotation.Table;
import com.litesuits.orm.db.enums.AssignType;

/**
 * TODO
 * Created by MEI on 2018/3/12.
 */

@Table("person")
public class Person {

    @PrimaryKey(AssignType.AUTO_INCREMENT)
    private Long _id;

    private String name;

    private int age;

    private boolean isMale;

    public Long get_id() {
        return _id;
    }

    public void set_id(Long _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }

    @Override
    public String toString() {
        return "Person{" +
                "_id=" + _id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", isMale=" + isMale +
                '}';
    }
}
