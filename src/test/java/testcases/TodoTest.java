package testcases;

import api.RegisterApi;
import api.TasksApi;
import base.BaseTest;
import pages.LoginPage;
import pages.NewTodoPage;
import pages.TodoPage;
import utils.ConfigUtils;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

@Feature("Todo Feature")
public class TodoTest extends BaseTest {

    @Story("Add Todo")
    @Test(description = "Should be able to add a new Todo correctly ")
    public void addNewTodo() {



//  LoginPage loginPage = new LoginPage(driver);
//    String actualResult= loginPage
//                          .loadURL()
//                          .Login("tarifi@gmail.com","abnassi_24245")
//                          .clickOnPlusButton()
//                          .addNewTodo("learn postman")
//                          .getTodoText();

        RegisterApi registerApi = new RegisterApi();
        registerApi.register();

        NewTodoPage newTodoPage = new NewTodoPage(getDriver());
        newTodoPage.load();
        injectCookiesToTheBrowser(registerApi.getCookies());

        String actualResult = newTodoPage
                .load()
                .addNewTodo("learn postman")
                .getTodoText();

        /** Type one **/
    /**    TodoPage todoPage = new TodoPage(driver);
        todoPage.load();

        injectCookiesToTheBrowser(registerApi.getCookies());

        String actualResult = todoPage
                                      .load()
                                      .clickOnPlusButton()
                                      .addNewTodo("learn postman")
                                      .getTodoText(); **/



        /**add the item **/
      //  Type Three
    //   TodoPage todoPage = loginPage.Login("tarifibasel0@gmail.com","abnassi_24245");

        /**
         *
     NewTodoPage newTodoPage =todoPage.clickOnPlusButton();
    newTodoPage.addNewTodo("learn postman");
    check if it is correct
     **/
    Assert.assertEquals(actualResult , "learn postman");

    }

    @Story("Delete Todo")
    @Test(description = "Should be able to delete a Todo correctly ")
    public void deleteTodo(){


        RegisterApi registerApi = new RegisterApi();
        registerApi.register();

        TasksApi tasksApi = new TasksApi();
        tasksApi.addTask(registerApi.getToken());

       TodoPage todoPage = new TodoPage(getDriver());
       todoPage.load();
       injectCookiesToTheBrowser(registerApi.getCookies());

        boolean test = todoPage
                .load()
                .deleteTodo()
                .isNoTodosMessageDisplayed();
//        LoginPage loginPage = new LoginPage(driver);
//
//        String email = ConfigUtils.getInstance().getEmail();
//        String password = ConfigUtils.getInstance().getPassword();
//
//        boolean test = loginPage
//                           .loadURL()
//                           .Login(email,password)
//                           .clickOnPlusButton()
//                           .addNewTodo("Learn selenium")
//                           .deleteTodo()
//                           .isNoTodosMessageDisplayed();

       // TodoPage todoPage =loginPage.Login("tarifibasel0@gmail.com","abnassi_24245");
       // newTodoPage = todoPage.clickOnPlusButton();
      /** new Todo Page  **/
       // newTodoPage.addNewTodo("Learn selenium");
      /** delete **/
       //  todoPage.deleteTodo();

        Assert.assertTrue(test);
    }



}
