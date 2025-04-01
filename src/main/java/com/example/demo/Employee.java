package com.example.demo;

import lombok.Getter;

import java.util.Date;

final class Employee {

    @Getter
    private final String empname;
    @Getter
    private final Integer empage;
    @Getter
    private final String empdept;
    private final Date empdate;

    public Employee(String empname,Integer empage,String empdept,Date empdate) {
        this.empname=empname;
        this.empage=empage;
        this.empdept=empdept;
        this.empdate = new Date(empdate.getTime());
    }

    public Date getEmpdate() {
        return new Date(empdate.getTime());
    }


    @Override
    public String toString() {
        return "Employee[name-"+empname+",age-"+empage+",department-"+empdept+",employeeDate-"+empdate+"]";

    }



}