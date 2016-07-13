package ru.kaspersky;

import com.jayway.restassured.parsing.Parser;
import com.jayway.restassured.RestAssured;
import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Step;



/**
 * Created by azamat on 13.07.16.
 */
public class WebCalculatorTest {
    @Step("Деление. Случай, когда числитель меньше знаменателя")
    @Test
    public void testDiv1() throws Throwable{
        RestAssured.defaultParser = Parser.HTML;
        given()
                .pathParam("a", "3")
                .pathParam("b", "100")
        .when()
                .get("http://his-pytest.westeurope.cloudapp.azure.com:8080/div/{a}/{b}")



        .then()
                .statusCode(200)
                .body("html.head.title",equalTo("Web Calculator"),
                      "html.body", equalTo("0"));

    }

    @Step("Деление. Случай, когда происходит деление на нуль")
    @Test
    public void testDiv2() throws Throwable{
        RestAssured.defaultParser = Parser.HTML;
        given()
                .pathParam("a", "2")
                .pathParam("b", "0")
        .when()
                .get("http://his-pytest.westeurope.cloudapp.azure.com:8080/div/{a}/{b}")
        .then()
                .statusCode(200)
                .body("html.head.title", equalTo("Web Calculator"),
                        "html.body", equalTo("Error division by zero"));


    }

    @Step("Деление. Случай, когда числитель больше знаменателя")
    @Test
    public void testDiv3() throws Throwable{
        RestAssured.defaultParser = Parser.HTML;
        given()
                .pathParam("a", "100")
                .pathParam("b", "3")
        .when()
                .get("http://his-pytest.westeurope.cloudapp.azure.com:8080/div/{a}/{b}")
        .then()
                .statusCode(200)
                .body("html.head.title", equalTo("Web Calculator"),
                        "html.body", equalTo("33"));


    }

    @Step("Деление. Случай, когда деление происходит на -1")
    @Test
    public void testDiv4() throws Throwable{
        RestAssured.defaultParser = Parser.HTML;
        given()
                .pathParam("a", "5")
                .pathParam("b", "-1")
        .when()
                .get("http://his-pytest.westeurope.cloudapp.azure.com:8080/div/{a}/{b}")
        .then()
                .statusCode(200)
                .body("html.head.title", equalTo("Web Calculator"),
                        "html.body", equalTo("-5"));


    }

    @Step("Деление. Случай, когда деление происходит на 1")
    @Test
    public void testDiv5() throws Throwable{
        RestAssured.defaultParser = Parser.HTML;
        given()
                .pathParam("a", "5")
                .pathParam("b", "1")
        .when()
                .get("http://his-pytest.westeurope.cloudapp.azure.com:8080/div/{a}/{b}")
        .then()
                .statusCode(200)
                .body("html.head.title", equalTo("Web Calculator"),
                        "html.body", equalTo("5"));


    }


    @Step("Умножение. Случай, когда умножение происходит на 1")
    @Test
    public void testMult1() throws Throwable{
        RestAssured.defaultParser = Parser.HTML;
        given()
                .pathParam("a", "5")
                .pathParam("b", "1")
        .when()
                .get("http://his-pytest.westeurope.cloudapp.azure.com:8080/mult/{a}/{b}")
        .then()
                .statusCode(200)
                .body("html.head.title", equalTo("Web Calculator"),
                        "html.body", equalTo("5"));


    }


    @Step("Умножение. Случай, когда умножение происходит на 0")
    @Test
    public void testMult2() throws Throwable{
        RestAssured.defaultParser = Parser.HTML;
        given()
                .pathParam("a", "5")
                .pathParam("b", "0")
        .when()
                .get("http://his-pytest.westeurope.cloudapp.azure.com:8080/mult/{a}/{b}")
        .then()
                .statusCode(200)
                .body("html.head.title", equalTo("Web Calculator"),
                        "html.body", equalTo("0"));


    }

    @Step("Умножение. Случай, когда умножение происходит на -1")
    @Test
    public void testMult3() throws Throwable{
        RestAssured.defaultParser = Parser.HTML;
        given()
                .pathParam("a", "5")
                .pathParam("b", "-1")
                .when()
                .get("http://his-pytest.westeurope.cloudapp.azure.com:8080/mult/{a}/{b}")
                .then()
                .statusCode(200)
                .body("html.head.title", equalTo("Web Calculator"),
                        "html.body", equalTo("-5"));


    }


    @Step("Умножение. Случай, когда умножение происходит двух отрицательных чисел")
    @Test
    public void testMult4() throws Throwable{
        RestAssured.defaultParser = Parser.HTML;
        given()
                .pathParam("a", "-5")
                .pathParam("b", "-5")
                .when()
                .get("http://his-pytest.westeurope.cloudapp.azure.com:8080/mult/{a}/{b}")
                .then()
                .statusCode(200)
                .body("html.head.title", equalTo("Web Calculator"),
                        "html.body", equalTo("25"));


    }


    @Step("Умножение. Случай, когда умножение происходит двух различных чисел")
    @Test
    public void testMult5() throws Throwable{
        RestAssured.defaultParser = Parser.HTML;
        given()
                .pathParam("a", "10")
                .pathParam("b", "5")
                .when()
                .get("http://his-pytest.westeurope.cloudapp.azure.com:8080/mult/{a}/{b}")
                .then()
                .statusCode(200)
                .body("html.head.title", equalTo("Web Calculator"),
                        "html.body", equalTo("50"));
    }


    @Step("Сложение. Случай, когда сложение происходит в виде 5+0")
    @Test
    public void testAdd1() throws Throwable{
        RestAssured.defaultParser = Parser.HTML;
        given()
                .pathParam("a", "5")
                .pathParam("b", "0")
                .when()
                .get("http://his-pytest.westeurope.cloudapp.azure.com:8080/add/{a}/{b}")
                .then()
                .statusCode(200)
                .body("html.head.title", equalTo("Web Calculator"),
                        "html.body", equalTo("5"));
    }

    @Step("Сложение. Случай, когда сложение происходит в виде 5 +(-1)")
    @Test
    public void testAdd2() throws Throwable{
        RestAssured.defaultParser = Parser.HTML;
        given()
                .pathParam("a", "5")
                .pathParam("b", "-1")
         .when()
                .get("http://his-pytest.westeurope.cloudapp.azure.com:8080/add/{a}/{b}")
                .then()
                .statusCode(200)
                .body("html.head.title", equalTo("Web Calculator"),
                        "html.body", equalTo("4"));
    }

    @Step("Сложение. Случай, когда сложение происходит в виде 0+0")
    @Test
    public void testAdd3() throws Throwable{
        RestAssured.defaultParser = Parser.HTML;
        given()
                .pathParam("a", "0")
                .pathParam("b", "0")
                .when()
                .get("http://his-pytest.westeurope.cloudapp.azure.com:8080/add/{a}/{b}")
                .then()
                .statusCode(200)
                .body("html.head.title", equalTo("Web Calculator"),
                        "html.body", equalTo("0"));
    }

    @Step("Сложение. Случай, когда сложение происходит в виде 10+5")
    @Test
    public void testAdd4() throws Throwable{
        RestAssured.defaultParser = Parser.HTML;
        given()
                .pathParam("a", "10")
                .pathParam("b", "5")
                .when()
                .get("http://his-pytest.westeurope.cloudapp.azure.com:8080/add/{a}/{b}")
                .then()
                .statusCode(200)
                .body("html.head.title", equalTo("Web Calculator"),
                        "html.body", equalTo("15"));
    }

    @Step("Сложение. Случай, когда сложение происходит в виде 0 + (-0)")
    @Test
    public void testAdd5() throws Throwable{
        RestAssured.defaultParser = Parser.HTML;
        given()
                .pathParam("a", "0")
                .pathParam("b", "-0")
                .when()
                .get("http://his-pytest.westeurope.cloudapp.azure.com:8080/add/{a}/{b}")
                .then()
                .statusCode(200)
                .body("html.head.title", equalTo("Web Calculator"),
                        "html.body", equalTo("0"));
    }

    @Step("Вычитание. Случай, когда вычитание происходит в виде 5 - 0")
    @Test
    public void testSub1() throws Throwable{
        RestAssured.defaultParser = Parser.HTML;
        given()
                .pathParam("a", "5")
                .pathParam("b", "0")
                .when()
                .get("http://his-pytest.westeurope.cloudapp.azure.com:8080/sub/{a}/{b}")
                .then()
                .statusCode(200)
                .body("html.head.title", equalTo("Web Calculator"),
                        "html.body", equalTo("5"));
    }

    @Step("Вычитание. Случай, когда вычитание происходит в виде 5 - (-1)")
    @Test
    public void testSub2() throws Throwable{
        RestAssured.defaultParser = Parser.HTML;
        given()
                .pathParam("a", "5")
                .pathParam("b", "-1")
                .when()
                .get("http://his-pytest.westeurope.cloudapp.azure.com:8080/sub/{a}/{b}")
                .then()
                .statusCode(200)
                .body("html.head.title", equalTo("Web Calculator"),
                        "html.body", equalTo("6"));
    }

    @Step("Вычитание. Случай, когда вычитание происходит в виде -5 - 1")
    @Test
    public void testSub3() throws Throwable{
        RestAssured.defaultParser = Parser.HTML;
        given()
                .pathParam("a", "-5")
                .pathParam("b", "-1")
                .when()
                .get("http://his-pytest.westeurope.cloudapp.azure.com:8080/sub/{a}/{b}")
                .then()
                .statusCode(200)
                .body("html.head.title", equalTo("Web Calculator"),
                        "html.body", equalTo("-4"));
    }

    @Step("Вычитание. Случай, когда вычитание происходит в виде 0 - 5")
    @Test
    public void testSub4() throws Throwable{
        RestAssured.defaultParser = Parser.HTML;
        given()
                .pathParam("a", "0")
                .pathParam("b", "-5")
                .when()
                .get("http://his-pytest.westeurope.cloudapp.azure.com:8080/sub/{a}/{b}")
                .then()
                .statusCode(200)
                .body("html.head.title", equalTo("Web Calculator"),
                        "html.body", equalTo("5"));
    }

    @Step("Вычитание. Случай, когда вычитание происходит в виде 5 - 10")
    @Test
    public void testSub5() throws Throwable{
        RestAssured.defaultParser = Parser.HTML;
        given()
                .pathParam("a", "5")
                .pathParam("b", "-10")
                .when()
                .get("http://his-pytest.westeurope.cloudapp.azure.com:8080/sub/{a}/{b}")
                .then()
                .statusCode(200)
                .body("html.head.title", equalTo("Web Calculator"),
                        "html.body", equalTo("15"));
    }
}
