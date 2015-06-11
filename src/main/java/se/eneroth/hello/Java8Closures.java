package se.eneroth.hello;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Rickard on 2015-02-06.
 */
public class Java8Closures {

    public static void main(String[] args) {
        Java8Closures java8Closures = new Java8Closures();
        java8Closures.closureTest1();
        java8Closures.closureTest2();
        java8Closures.closureTest3();
    }

    // Closures
    public void closureTest1() {
        new Thread(
                () -> System.out.println("Hello from thread")
        ).start();
    }

    // Closures
    public void closureTest2() {
        //Old way:
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        for (Integer n : list) {
            System.out.println(n);
        }

        //New way:
        List<Integer> list2 = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        list2.forEach(n -> System.out.println(n));
    }

    public static void printPersonsOlderThan(List<Person> roster, int age) {
        for (Person p : roster) {
            if (p.getAge() >= age) {
                p.printPerson();
            }
        }
    }


    // Closures
    public void closureTest3() {
        Person p1 = new Person();
        p1.setAge(18);
        p1.setName("Kalle");
        Person p2 = new Person();
        p2.setAge(50);
        p2.setName("Arne");

        List<Person> list = new ArrayList<Person>();
        list.add(p1);
        list.add(p2);

        printPersonsOlderThan(list, 30);

        // and as closure
        printPersons(
                list,
                (Person p) -> p.getAge() >= 40
                        && p.getAge() <= 55
        );
    }

    public static void printPersons(List<Person> roster, CheckPerson tester) {
        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }
}
