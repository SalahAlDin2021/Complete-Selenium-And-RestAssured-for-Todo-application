package testcases;

import Objects.User;
import api.RegisterApi;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Test {


    public static void main(String[] args) {

        RegisterApi registerApi = new RegisterApi();
        registerApi.register();

        System.out.println(registerApi.getuserID());
        System.out.println(registerApi.getFirstName());
        System.out.println(registerApi.getToken());


//        User user = new User("rengoali5@gmail.com", "Abnassi_24245", "basil" ,"assi");
//
//        String requestBody = "{\n" +
//                "   \"email\":\"rengoali5555@gmail.com\",\n" +
//                "   \"firstName\":\"basil\",\n" +
//                "   \"lastName\":\"assi\",\n" +
//                "   \"password\":\"Abnassi_24245\"";
//        String endPoint =  "/api/v1/users/register";
//
//        Response response  =  given()
//                .baseUri("https://qacart-todo.herokuapp.com")
//                .header("Content-Type","application/json")
//                .body(user)
//                .when()
//                .post(endPoint)
//                .then()
//                .extract().response();
//
//
//         String accessToken= response.path("userID");
//
//          System.out.println(accessToken);
    }

}
