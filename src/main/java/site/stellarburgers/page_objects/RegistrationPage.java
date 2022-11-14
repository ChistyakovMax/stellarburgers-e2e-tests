package site.stellarburgers.page_objects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class RegistrationPage extends Page{

    public RegistrationPage(WebDriver driver) {
        super(driver);
        currentUrl = pageUrl + REGISTER;
    }

    //инпут Имя
    @FindBy(xpath = ".//fieldset[1]//input")
    private WebElement nameInput;

    //инпут Email
    @FindBy(xpath = ".//fieldset[2]//input")
    private WebElement emailInput;

    //инпут Пароль
    @FindBy(xpath = ".//fieldset[1]//input")
    private WebElement passwordInput;

    //кнопка Зарегистрироваться
    @FindBy(xpath = ".//button[text()='Зарегистрироваться']")
    private WebElement signUpButton;

    //ошибка Некорректный пароль
    @FindBy(xpath = ".//p[text()='Некорректный пароль']")
    private WebElement incorrectPasswordError;




    //шаги
    @Step("Ввести имя")
    public void fillNameInput(String name) {
        //nameInput.sendKeys(name);
        driver.findElement(By.xpath(".//fieldset[1]//input")).sendKeys(name);
    }

    @Step("Ввести Email")
    public void fillEmailInput(String email){
        emailInput.sendKeys(email);
    }

    @Step("Ввести пароль")
    public void fillPasswordInput(String password){
        passwordInput.sendKeys(password);
    }

    @Step("клик на кнопку Зарегистрироваться")
    public void clickSignUpButton(){
        signUpButton.click();
    }

    @Step("Получить текст ошибки Некорректный пароль")
    public String getIncorrectPasswordErrorText(){
        return incorrectPasswordError.getText();
    }



    //вспомогательные методы
    public void waitForSignUpButton() throws InterruptedException {
        Thread.sleep(10000);
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(signUpButton));
                //.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//button[text()='Зарегистрироваться']")));
    }

    public void waitForIncorrectPasswordError() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(incorrectPasswordError));
    }
}
