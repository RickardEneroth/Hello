package se.eneroth.hello;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class AppTest {

    @Test
    public void testa() {
        System.out.println("Testar...");
        assertEquals(7, 7);
    }

    @Test
    public void test_add() {
        App app = new App();
        int result = app.add(7, 8);
        assertEquals(result, 15);
    }
}
