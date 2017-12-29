package exercises;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ConditionExercises {

    @Test
    public void bootcampAgeChecker() {

        //Maak deelnemerslijst
        Integer[] deelnemersArr = new Integer[6];

        //Vul deelnemerslijst met de leeftijden van de deelnemers
        deelnemersArr[0] = 12;
        deelnemersArr[1] = 19;
        deelnemersArr[2] = 21;
        deelnemersArr[3] = 24;
        deelnemersArr[4] = 64;
        deelnemersArr[5] = 65;


        //Itereer over de gehele lijst en geef output op basis van leeftijd
        for (int i = 0; i < deelnemersArr.length; i++) {
            if (deelnemersArr[i] < 21) {
                System.out.println("Deelnemer "+ (i+1) +" is " + deelnemersArr[i] + ", dus te jong.");
            } else if (deelnemersArr[i] < 65) {
                System.out.println("Deelnemer "+ (i+1) +" is " + deelnemersArr[i] + ", dus toegelaten.");
            } else System.out.println("Deelnemer "+ (i+1) +" is " + deelnemersArr[i] + ", dus *ahum* te oud.");

        }

    }
}