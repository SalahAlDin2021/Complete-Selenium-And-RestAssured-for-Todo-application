package api;

import Objects.Task;
import config.EndPoints;
import utils.ConfigUtils;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class TasksApi {


    public void addTask(String token){

        Task task = new Task(false,"learn Selenium" );
        Response response= given()
                .baseUri(ConfigUtils.getInstance().getBaseUrl())
                .header("Content-Type" ,"application/json")
                .body(task)
                .auth().oauth2(token)
        .when()
                .post(EndPoints.API_TASK_ENDPOINT)
        .then()
                .log().all().extract().response();

        if(response.statusCode() != 201){
            throw new RuntimeException("Something wrong in adding the todo");
        }






    }

}
