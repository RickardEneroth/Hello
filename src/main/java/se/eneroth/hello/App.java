package se.eneroth.hello;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class App {
    private static final Logger logger = LogManager.getLogger(App.class);

    public static void main( String[] args ) throws Exception {
        //logger.debug("Hello this is an debug message");
        //logger.info("Hello this is an info message");
        logger.error("Hello this is an error message");

        System.out.println( "Hello World!" );
        new App().array();
        new App().array2();
        new App().writeFile();
        new App().readFile();
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

    // Write to file
    public void writeFile() throws Exception{
        String content = "This is the content to write into file";

        File file = new File("c:/temp/filename.txt");

        // if file doesnt exists, then create it
        if (!file.exists()) {
            file.createNewFile();
        }

        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(content);
        bw.close();
    }

    // Read from file
    public void readFile() throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("c:/temp/filename.txt"));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            String everything = sb.toString();
            System.out.println(everything);
        } finally {
            br.close();
        }
    }
    
    //TODO
    /*
    eget exception
    mockito
    log4j
    properties
    
    */
    
 }
