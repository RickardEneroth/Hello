package se.eneroth.hello;


import org.testng.annotations.Test;
import org.testng.Assert;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void testa() {
        System.out.println("Testar...");
        Assert.assertEquals(7,7);

    }
}
