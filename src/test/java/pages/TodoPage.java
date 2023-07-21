package pages;

import base.BasePage;
import config.EndPoints;
import utils.ConfigUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TodoPage extends BasePage {

    public TodoPage(WebDriver driver) {
        super(driver);
    }

    @FindBy( xpath = "//h2[@data-testid='welcome']")
    WebElement welcomeMessage;

    @FindBy( xpath = "//button[@aria-label='delete']")
    WebElement addButton;

    @FindBy(css= "[data-testid=\"todo-item\"]")
    WebElement todoItem;

    @FindBy(css= "[data-testid=\"delete\"]")
    WebElement deleteItem;

    @FindBy(css= "[data-testid=\"no-todos\"]")
    WebElement noTodosMessage;


    @Step
    public TodoPage load(){
    driver.get(ConfigUtils.getInstance().getBaseUrl() + EndPoints.API_TODO_ENDPOINT);
    return this;
    }
    @Step
    public boolean isWelcomeMessageDisplayed(){
        return welcomeMessage.isDisplayed();
    }
    @Step
    public NewTodoPage clickOnPlusButton(){
        addButton.click();
        return new NewTodoPage(driver);
    }
    @Step
    public String getTodoText(){
        return todoItem.getText();
    }
    @Step
    public TodoPage deleteTodo(){
        deleteItem.click();
        return this;
    }

    public boolean isNoTodosMessageDisplayed(){
        return noTodosMessage.isDisplayed();
    }
}
