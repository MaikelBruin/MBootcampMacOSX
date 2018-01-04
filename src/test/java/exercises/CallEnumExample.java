package exercises;

import org.testng.annotations.Test;

public class CallEnumExample {

    @Test
    public void printBootcampDays() {
        System.out.println(EnumExample.checkBootcampDays(EnumExample.BootcampDays.DAYONE));
        System.out.println(EnumExample.checkBootcampDays(EnumExample.BootcampDays.DAYTWO));

    }
}
