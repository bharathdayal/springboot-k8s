package com.example.demo;

import com.example.demo.interfaces.DepartmentInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Contract;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Department {


    @Autowired
    public  DepartmentInterface departmentInterface;





    public List<DepartmentInterface> departmentFilter() {
            List<DepartmentInterface> departmentMap = Arrays.asList(
                    new DepartmentInterface("Software development",1),
                    new DepartmentInterface("Business Development",2),
                    new DepartmentInterface("IT Security",3),
                    new DepartmentInterface("IT Director",4),
                    new DepartmentInterface("Business intelligence",5),
                    new DepartmentInterface("Mobile App development",1));


        //department.forEach(System.out::println);

        return departmentMap.stream()
                .filter(name->name.getDepartmentName().contains("IT")).collect(Collectors.toList());
    }
}
