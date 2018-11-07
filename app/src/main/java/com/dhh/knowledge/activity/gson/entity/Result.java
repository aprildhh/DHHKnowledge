package com.dhh.knowledge.activity.gson.entity;

import java.util.List;

/**
 * Created by DHH on 2018/11/7.
 * 页面：Result包括一个int类型数据，一个Person类对象的集合
 */
public class Result {
    private int result;
    private List<Person> personData;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public List<Person> getPersonData() {
        return personData;
    }

    public void setPersonData(List<Person> personData) {
        this.personData = personData;
    }
}