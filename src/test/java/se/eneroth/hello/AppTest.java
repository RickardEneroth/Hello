package se.eneroth.hello;

import org.testng.annotations.Test;
import org.testng.Assert;

public class AppTest {

    @Test
    public void testa() {
        System.out.println("Testar...");
        Assert.assertEquals(7, 7);
    }
}
