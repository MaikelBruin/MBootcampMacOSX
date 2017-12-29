package exercises;

import org.testng.annotations.Test;

@Test()
public class AboutMethods {

    @Test
    private void printProduct() {
        System.out.println(multiply(2.343, 3.553));
    }

    private double multiply(double a, double b) {
        return a*b;
    }
}
