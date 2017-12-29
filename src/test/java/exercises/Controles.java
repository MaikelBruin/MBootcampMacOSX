package exercises;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class Controles {
    @Test
    public void assertBoolean() {
        boolean testBoolean = false;

        Assertions.assertThat(testBoolean).as("Is de test boolean false?").isFalse();
    }

    @Test
    public void assertStringContains() {
        String text = "Ik bezit een hoop dingen.";

        Assertions.assertThat(text).as("Bezit text het volgende?").contains("hoop");
    }

    @Test
    public void assertIntegerIsGreaterThan() {
        int bigNumber = 400;

        Assertions.assertThat(bigNumber).as("Is dit getal groter dan?").isGreaterThan(399);
    }

}
