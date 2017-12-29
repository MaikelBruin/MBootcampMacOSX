package app;

public class CarAdvanced {

    private String brand;
    private int force;
    private int RPMs;

    public CarAdvanced(String brand, int force, int RPMs) {
        this.brand = brand;
        this.force = force;
        this.RPMs = RPMs;

        if (RPMs == 0) {
            System.err.println("RPMs can't be zero!");
        } else {
            calculateTorque();
        }

    }

    public void printBrand() {
        System.out.println("Advanced car brand: " + brand);
    }

    public void calculateTorque() {
        int factor = 5252;
        int torque = (force * factor)/RPMs;
        System.out.println("Torque of advanced car is " + torque);
    }
}
