package restassured;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Steps {

    private static Response response;
    private String BASE_URL = "http://localhost:8080";

    @Given("^api shipping consumption is available \"([^\"]*)\"$")
    public void nomeTest(String variavel) throws Throwable {

        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();

        response = request.body("{ \"cep\":\"" + variavel + "\"}")
                .post("/consult");


    }
}
