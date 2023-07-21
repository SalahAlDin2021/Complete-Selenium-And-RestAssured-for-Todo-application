package api;

import Objects.User;
import config.EndPoints;
import utils.UserUtils;
import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.given;

public class RegisterApi {

    private List<Cookie> restAssuredCookies;

    private  String accessToken;
    private String userID;
    private String firstName;

    public void register(){

        User user = UserUtils.generateRandomUser();

        /**
        String requestBody = "{\n" +
                "   \"email\":\"rengoali5555@gmail.com\",\n" +
                "   \"firstName\":\"basil\",\n" +
                "   \"lastName\":\"assi\",\n" +
                "   \"password\":\"Abnassi_24245\"";
        */

        String endPoint =  "/api/v1/users/register";

        Response response  =
                given()
                    .baseUri("https://qacart-todo.herokuapp.com")
                    .header("Content-Type","application/json")
                    .body(user).log().all()
                .when()
                    .post(EndPoints.API_REGISTER_ENDPOINT)
                .then().log().all()
                    .extract()
                    .response();

         restAssuredCookies =response.getDetailedCookies().asList();
         accessToken= response.path("access_token");
         userID= response.path("userID");
         firstName= response.path("firstName");

        if(response.getStatusCode() != 201){
            throw new RuntimeException(" Error something wrong ");
        }
    }

    public String getToken(){
        return this.accessToken;
    }
    public List<Cookie> getCookies(){
        return restAssuredCookies;
    }
    public String getuserID(){
        return this.userID;
    }
    public String getFirstName(){
        return this.firstName;
    }

}
