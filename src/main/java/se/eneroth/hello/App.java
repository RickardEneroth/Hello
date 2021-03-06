package se.eneroth.hello;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import se.eneroth.hello.exception.NegativeException;
import se.eneroth.hello.model.Flower;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.io.*;
import java.util.*;

public class App {
    private static final Logger logger = LogManager.getLogger(App.class);

    public static void main( String[] args ) throws Exception {
        logger.debug("Hello world - debug log");
        logger.info("Hello world - info log");
        logger.warn("Hello world - warn log");
        logger.error("Hello world - error log");

        System.out.println( "Hello World!" );
        App app = new App();
        app.array();
        app.array2();
        app.writeFile();
        app.readFile();
        app.readProperties();
        System.out.println(app.addWithException(1, 6));
        //app.readFromDB();
        app.closureTest1();
        app.closureTest2();
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

    // Properties
    public void readProperties() throws IOException {
        Properties prop = new Properties();
        prop.load(new FileInputStream("app.properties"));
        System.out.println("datornamn=" + prop.getProperty("datornamn"));
    }

    // Add with exception
    public int addWithException(int tal1, int tal2) throws NegativeException {
        if (tal1 < 0 || tal2 <0) {
            throw new NegativeException("Minst ett av talen verkar vara negativt!");
        }
        return tal1 + tal2;
    }

    // Hibernate
    public void readFromDB() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<Flower> result = entityManager.createQuery( "from Flower").getResultList();
        for ( Flower flower : result ) {
            System.out.println( "Flower: " + flower.getId() + " " + flower.getName() + " " + flower.getLatinName() );
        }
        entityManager.getTransaction().commit();
        entityManager.close();
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
}
