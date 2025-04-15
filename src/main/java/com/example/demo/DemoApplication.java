package com.example.demo;

import com.example.demo.components.CreditCard;
import com.example.demo.components.Paypal;
import com.example.demo.interfaces.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication(exclude ={ SecurityAutoConfiguration.class,  ManagementWebSecurityAutoConfiguration.class })
@EnableCaching
public class DemoApplication {

    //@SpringBootApplication(exclude= {SecurityAutoConfiguration.class,DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
    //@SpringBootApplication(exclude ={ SecurityAutoConfiguration.class,  ManagementWebSecurityAutoConfiguration.class })
	public static void main(String[] args) throws ParseException, InterruptedException {
		System.out.println("DEMO APP STARTED");

		MapInterface mapInterface = new MapInterface();

		ListInterface listInterface = new ListInterface();

		SetInterface setInterface = new SetInterface();


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

	    // Stream Demo

		StreamDemo streamDemo = new StreamDemo();
		streamDemo.streamArray();
		streamDemo.StreamFromCollections();

		// Reverse String
		String str = "Reverse the String";

		StringBuilder stringBuilder = new StringBuilder(str);
		System.out.println(stringBuilder.reverse());

		// Using for loop to reverse string
		String reversed="";

		for(int i=str.length()-1;i >=0;i--) {
			reversed+= str.charAt(i);
		}
		System.out.println(reversed);

		// Count the alphabets in string

		int alphacount = 0;

		for(int i =0; i < str.length();i++) {
			char ch = str.charAt(i);


		if(Character.isAlphabetic(ch)) {
			alphacount++;
		   }
		}
        System.out.println(alphacount);

		List<String> arraylist = new ArrayList<>();
		arraylist.add("Test 1");
		arraylist.add("Test 2");

		Stream<String> stream =arraylist.stream();

        List<String> streamlist1 = stream.map(String::toUpperCase).collect(Collectors.toUnmodifiableList());
		System.out.println(streamlist1);



		List<String> streamlist2=arraylist.stream().filter(name->name.contains("Test 1")).collect(Collectors.toUnmodifiableList());
		System.out.println(streamlist2);

		/*Person person = new Person();
		person.setPersonname("PersonName");
		person.setPersonage(40);

		System.out.println("Name: " + person.getPersonname());
		System.out.println("Age: " + person.getPersonage());

		// Trying to set an invalid age
		person.setPersonage(-5);*/

		String dateString = "2025-03-15 17:30:00";
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		Date empDate = dateformat.parse(dateString);
		Employee employee = new Employee("John",45,"ISIT",empDate);
		System.out.println("Employee Details: " + employee);

		empDate.setTime(0);
		System.out.println("Employee Details: " + employee);

        List<Integer> number = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11);
		List<Integer> even = number.stream().filter(n->n%2==0).collect(Collectors.toList());
		System.out.println(even);

		List<String> mapArray = Arrays.asList("Hello World", "How are you", "Java is awesome");
		List<String> mapStream = mapArray.stream().map(String::toUpperCase).toList();
		System.out.println(mapStream);

		List<String> flatArray = new ArrayList<>();
		flatArray.add("Hello World");
		flatArray.add("How are you");
		flatArray.add("Java is awesome");

		List<String> flatStream = flatArray.stream().flatMap(s-> Arrays.stream(s.split(" "))).toList();
		System.out.println(flatStream);

		List<List<Integer>> listofInteger = Arrays.asList(
				Arrays.asList(1,2,3),
				Arrays.asList(4,5,6),
				Arrays.asList(7,8,9)

		);
		List<Integer> flatListofList = listofInteger.stream()
													.flatMap(List::stream)
				.toList();

        System.out.println(flatListofList);

		List<String> streamArray = Arrays.asList("A","B","C","D","E");

		//Consumer
		Consumer<String> consumeStream = arr->System.out.println(arr);
		consumeStream.accept("F");
		streamArray.stream().forEach(consumeStream);

		//Supplier
		Supplier<String> supplerStream = ()->"test";
		System.out.println(supplerStream.get());
		//streamArray.stream().collect(Collectors.toList());

		LocalDate date = LocalDate.now();
		System.out.println(date);

		List<String> stringSearch = Arrays.asList("John", "Jane", "Alex");
		//Optional<String> search = stringSearch.stream().filter(input->input.startsWith("Z")).collect(Collectors.toList());

		//String finalString = search.orElseGet(()->"Default String");

		List<Integer> arrInteger = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		arrInteger.stream().map(n->n*2).forEach(System.out::println);
		arrInteger.parallelStream().map(a->a*2).forEach(System.out::println);

		//Thread

		/*MyThread thread1=new MyThread();
		MyThread thread2=new MyThread();

		//thread1.start();
		//thread2.interrupt();
		//thread2.start();

		//Thread runnable1=new Thread(new MyRunnable());
		//Thread runnable2=new Thread(new MyRunnable());

		//runnable1.start();
		//runnable2.start();

		ExecutorService executorService = Executors.newFixedThreadPool(2);
		var scheduleThreadPool  = Executors.newScheduledThreadPool(5);

        for(int i=0;i<=5;i++) {
			MyRunnable runnable = new MyRunnable();
			String message = "Scheduled task started with " + i + " seconds delay";
			//scheduleThreadPool.schedule(()->System.out.println(message),i, TimeUnit.SECONDS);
			//executorService.execute(runnable);
		}
		executorService.shutdown();
           */

		//Concurrent Hash Map

		ConcurrentHashMap<Integer,String> concurrentMap = new ConcurrentHashMap<Integer,String>();
		concurrentMap.put(1,"one");
		concurrentMap.put(2,"two");

		new Thread(()->  { System.out.println("Thread 2 read"+concurrentMap.get(2));});
		new Thread(()-> { concurrentMap.put(3,"three");System.out.println("Thread 3 write");});


		int dayOfWeek = 2;
		String switchWeek = switch(dayOfWeek) {
		   case 1,2,3,4,5 -> {
			   System.out.println("Working day");
			   yield("Workingday");
		   }
		   case 6,7 -> {
			   System.out.println("Week day");
			   yield("Weekday");
		   }
			default -> throw new IllegalArgumentException("Day of week "+dayOfWeek);
		};


        List<List<String>> flatStreamArr = Arrays.asList(
				Arrays.asList("FLAT ONE"),
				Arrays.asList("FLAT TWO"),
				Arrays.asList("FLAT THREE")
		);


		List<String> flatStreamMap = flatStreamArr.stream().flatMap(List::stream).toList();
        System.out.println(flatStreamMap);

		CreditCard creditCard = new CreditCard();
		creditCard.paymentMethod("Credit Card");

		Paypal paypal = new Paypal();
		paypal.paymentMethod("paypal Card");

		//String Functions
		StringFunctions stringFunctions = new StringFunctions();
		stringFunctions.countString("aaabbbbcccdddeeef");

        stringFunctions.reverseString("String reverse using string builder");
		stringFunctions.reverseStringloop("String reverse using string builder");

		StringInterface.nonRepeatedString("abcdefb");

		StringInterface.repeatedString("abcc");

		Map<String,String> map = Map.of(
				"%USER%","admin",
				"%HOME%","/admin/home");

		String replaceInput = "I am %USER% My home is %HOME%";
		stringFunctions.replaceString(replaceInput,map);

	    StreamFunctions streamFunctions = new StreamFunctions();
		List<String> streamArr = Arrays.asList("apple", "banana", "cherry", "apple", "banana", "date");


		InterfaceDemo interfaceDemo=new InterfaceDemo();
		//Abstract Method
		interfaceDemo.myAbstractA();
		interfaceDemo.myAbstractB();

		interfaceDemo.myAbstractString("Hello Abstact !");
		interfaceDemo.myAbstractParam("Hello Abstract !");
		interfaceDemo.myAbstractParam(12345);

		//Default Method
		interfaceDemo.myDefaultA();
		interfaceDemo.myDefaultB();
		//Default Method - Resolve conflicts Diamond problem when calling same signature from Multiple Interfaces
		interfaceDemo.myDefaultString("Hello Default !");

		// Static method call from interface and no need to override in implementation class
		InterfaceDemoA.myStaticA();
		InterfaceDemoB.myStaticB();
		// Static method -  No conflicts Diamond problem when calling same signature from Multiple Interfaces
		InterfaceDemoA.myStaticString("Hello Static !");
		InterfaceDemoB.myStaticString("Hello Static !");
	}

}
