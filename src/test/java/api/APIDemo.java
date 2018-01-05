package api;


import io.restassured.response.ResponseBody;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class APIDemo {

    int season = 2017;
    int raceNumber = 2;

    @Test
    public void currentF1Results() {
        given().when().get("http://ergast.com/api/f1/current/last/results.json").then().statusCode(200);
    }

    @Test
    public void verstappenResults() {
        given().when().get("http://ergast.com/api/f1/2016/drivers/verstappen/results.json").then().statusCode(200);
        given().when().get("http://ergast.com/api/f1/2016/drivers/verstappen/results.json").getBody().prettyPrint();


        given().when().get("http://ergast.com/api/f1/2016/drivers/verstappen/results.json").then()
                .body("MRDATA.RaceTable.driverId", equalTo("verstappen"));

    }

    @Test
    public void pathParam() {
        given().pathParam("season", 2017)
                .when().get("http://ergast.com/api/f1/{season}/last/results.json")
                .then().statusCode(200);
    }

    @Test
    public void multiplePathParam() {
        given()
                .pathParam("season", season)
                .pathParam("raceNumber", raceNumber)
                .when().get("http://ergast.com/api/f1/{season}/{raceNumber}/results.json")
                .then().statusCode(200);
    }

}
