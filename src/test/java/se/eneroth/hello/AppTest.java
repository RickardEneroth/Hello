package se.eneroth.hello;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class AppTest {

    App app;

    @BeforeTest
    public void setup() {
        app = new App();
    }

    @Test
    public void testa() {
        System.out.println("Testar...");
        assertEquals(7, 7);
    }

    @Test
    public void test_add() {
        int result = app.add(7, 8);
        assertEquals(result, 15);
    }

    @Test
    public void test_up() {
        String str = "UPPER";
        assertEquals(app.up("upper"), str);
    }

    @Test
    public void test_exception() {
        try {
            app.addWithException(1, -6);
        } catch (NegativeException e) {
            assertEquals(e.getMessage(), "Minst ett av talen verkar vara negativt!");
        }
    }

    @Test
    public void test_exception_ok() {
        try {
            int result = app.addWithException(1, 6);
            assertEquals(7, result);
        } catch (NegativeException e) {
            assertEquals(e.getMessage(), "Minst ett av talen verkar vara negativt!");
        }
    }
}
