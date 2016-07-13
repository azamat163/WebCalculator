package ru.kaspersky;

import org.junit.*;
import junit.framework.*;
import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.RestAssured.given;

import com.jayway.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.junit.Test;

/**
 * Created by azamat on 13.07.16.
 */
public class WebCalculatorTest {
    @Test
    public void testDiv() throws Throwable{
        given()
                .pathParam("a", "0")
                .pathParam("b", "1")
        .when()
                .get("http://his-pytest.westeurope.cloudapp.azure.com:8080/div/{a}/{b}")
        .then()
                .statusCode(200)
                .log()
                .body();


    }

    @Test
    public void testDivZero() throws Throwable{
        given()
                .pathParam("a", "2")
                .pathParam("b", "0")
        .when()
                .get("http://his-pytest.westeurope.cloudapp.azure.com:8080/div/{a}/{b}")
        .then()
                .statusCode(200)
                .log()
                .body();


    }


}
