package exercises;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class HelloWorldTest {
    @Test
    public void printText () {
        System.out.println("Hello world!");
        Reporter.log("Hello world, I am a reporter!");
    }
}
