package exercises;

public class Cars {

    public void printBrand(String brand) {
        System.out.println("Brand of car is " + brand);
    }

    public void printDoors(int doors) {
        System.out.println("Number of doors of car is " + doors);
    }

    public void printMotorType(String MotorType) {
        System.out.println("MotorType of car is " + MotorType);
    }

    public void calculateTorq(int force, int RPMs) {
        int factor = 5252;
        int torq = (force * factor)/RPMs;
        System.out.println("Torq of car is " + torq);
    }
}
