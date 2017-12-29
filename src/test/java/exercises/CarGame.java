package exercises;

import app.CarAdvanced;
import org.testng.annotations.Test;

public class CarGame {

    @Test
    public void carCheck() {
        Cars carOne = new Cars();

        carOne.printBrand("Volvo");
        carOne.printDoors(4);
        carOne.printMotorType("v90");
        carOne.calculateTorq(500, 200);
    }

    @Test
    public void betterCarCheck() {
        CarAdvanced advCarOne = new CarAdvanced("Volvo", 20, 200);
        advCarOne.printBrand();
    }
}
