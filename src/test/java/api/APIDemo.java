package api;


import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class APIDemo {

    @Test
    public void currentF1Results() {
        given().when().get("http://ergast.com/api/f1/current/last/results.json").then().statusCode(200);
    }

    @Test
    public void verstappenResults() {
        given().when().get("http://ergast.com/api/f1/2016/drivers/verstappen/results.json").then().statusCode(200);
    }

    @Test
    public void andereResults() {
//        given().when().
    }

}
