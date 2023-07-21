package pages;

import base.BasePage;
import config.EndPoints;
import utils.ConfigUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewTodoPage extends BasePage {

    public NewTodoPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//input[@data-testid='new-todo']")
    WebElement todoItemInput;

    @FindBy(xpath = "//button[@data-testid='submit-newTask']")
    WebElement submitNewTask;
    @Step
    public TodoPage addNewTodo(String item){
       todoItemInput.sendKeys(item);
       submitNewTask.click();
       return new TodoPage(driver);
    }
    @Step
    public NewTodoPage load(){
       driver.get( ConfigUtils.getInstance().getBaseUrl()+ EndPoints.API_NEW_TASK_ENDPOINT);
       return this;
    }


}
