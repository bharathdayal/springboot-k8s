package com.example.demo.interfaces;

import lombok.Getter;

public class DepartmentInterface {

    @Getter
    String departmentName;
    @Getter
    int departmentCode;

    public DepartmentInterface(String departmentName, Integer departmentCode) {
        this.departmentName = departmentName;
        this.departmentCode = departmentCode;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    @Override
    public String toString() {
        return "Department{name='" + departmentName + "', code=" + departmentCode + "}";
    }


}