package se.eneroth.hello;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class App {
    public static void main( String[] args ) {
        System.out.println( "Hello World!" );
        new App().array();
        new App().array2();
    }

    public int add(int tal1, int tal2) {
        return tal1 + tal2;
    }

    // To upper case
    public String up(String str) {
        return str.toUpperCase();
    }

    /* Array */
    public void array() {
        List<String> list = new ArrayList<String>();
        list.add("apa");
        list.add("fisk");
        list.add("get");

        Iterator i = list.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }
    }

    /* Array2 */
    public void array2() {
        List<String> list = new ArrayList<String>();
        list.add("apa");
        list.add("fisk");
        list.add("get");

        for (Object aList : list) {
            System.out.println(aList);
        }
    }
 }
