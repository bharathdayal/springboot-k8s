package com.example.demo;

import com.example.demo.interfaces.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@EnableCaching
public class DemoApplication {

    //@SpringBootApplication(exclude= {SecurityAutoConfiguration.class,DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})

	public static void main(String[] args) {
		System.out.println("DEMO APP STARTED");

		MapInterface mapInterface = new MapInterface();

		ListInterface listInterface = new ListInterface();

		SetInterface setInterface = new SetInterface();

		Department department = new Department();

		SpringApplication.run(DemoApplication.class, args);

		System.out.println("HashMap Insert===>" +mapInterface.insertHashMap());
		System.out.println("HashMap Remove===>" +mapInterface.removeHashMap());
		System.out.println("LinkedHashMap Insert===>" +mapInterface.insertLinkedHashMap());
		System.out.println("TreeMap Insert===>" +mapInterface.insertTreeMap());

		System.out.println("Array List===>" +listInterface.insertArrayList());
		System.out.println("Linked List===>" +listInterface.insertLinkedList());

		System.out.println("HashSet Insert===>" +setInterface.insertHashSet());
		System.out.println("LinkedHashSet Insert===>" +setInterface.insertLinkedHashSet());
		System.out.println("TreeSet Insert===>" +setInterface.insertTreeSet());

		//System.out.println("Lambda===>" +listInterface.lambda());
		//System.out.println("Stream Filter===>" +listInterface.lambda());

		System.out.println("Dept Filter===>" +department.departmentFilter());

		StringFunctionalInterface stringUpper = input -> {
			if (input == null || input.isEmpty()) {
				return "EMPTY";

			}
			return input.toUpperCase();

		};

		System.out.println("Functional Interface Lambda String UpperCase===>" +stringUpper.upperCase("java lambda"));

		System.out.println("Functional Interface Lambda String LowerCase===>" + StringFunctionalInterface.lowerCase("JAVA LAMBDA"));

		ArithmeticFunctionalInterface arithmeticFunctionalInterface =(n1,n2)-> n1+n2;
		System.out.println("Functional Interface Lambda Addition===>" + arithmeticFunctionalInterface.addition(100,200));

		Function<String,String> stringFuncUpper= input-> input.toUpperCase();

		System.out.println("Functional Interface Function===>" + stringFuncUpper.apply("Functional Interface"));

		Consumer<String> stringConsumer = input-> System.out.println("Functional Interface Consumer===>" +input);
		stringConsumer.accept("only consume");

		Supplier<String> stringSupplier=()-> "supplier no args and returns value";
		System.out.println("Functional Interface Supplier===>" +stringSupplier.get());

		Predicate<String> stringPredicate =input->input.contains("Predicate");
		System.out.println("Functional Interface Predicate===>" +stringPredicate.test("Functional Interface Predicate"));

	}

}
