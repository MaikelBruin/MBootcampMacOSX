package exercises;

import chapterSix.TestShopScenario;

public class EnumExample extends TestShopScenario {

    public enum BootcampDays {
        DAYONE,
        DAYTWO,
        DAYTHREE,
        DAYFOUR,
        DAYFIVE;
    }

    public static String checkBootcampDays(BootcampDays bootcampDays) {
        switch(bootcampDays) {
            case DAYONE: default:
                return "KERST was erg pittig";
            case DAYTWO:
                return "nog steeds pittig";
        }
    }
}
