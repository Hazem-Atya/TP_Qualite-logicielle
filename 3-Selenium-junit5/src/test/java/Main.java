import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.List;

public class Main {
    static WebDriver driver;
    static JavascriptExecutor js;
    static List<WebElement> technologies;

    @BeforeAll
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void prepareDriver() {
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;

        driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(2));
        driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(1));

        driver.get("https://todomvc.com/");
        if (technologies == null) {
            technologies = driver.findElements(By.cssSelector("ul.js-app-list-inner.applist.js>li>a"));
        }


    }

    @Test
    public void addElements() throws InterruptedException {
        driver.get("https://todomvc.com/examples/backbone/");
        WebElement addTodo = driver.findElement(By.className("new-todo"));
        addTodo.sendKeys("Meet a Friend");
        addTodo.sendKeys(Keys.ENTER);
        Thread.sleep(700);
        addTodo.sendKeys("Buy Meat");
        addTodo.sendKeys(Keys.ENTER);
        Thread.sleep(700);
        addTodo.sendKeys("Clean the car");
        addTodo.sendKeys(Keys.ENTER);
        Thread.sleep(700);

        List<WebElement> toDoElements = driver.findElements(By.className("toggle"));
        js.executeScript("console.log(arguments[0])", toDoElements);
//        toDoElements.get(0).click();
//        toDoElements.get(1).click();
//        Thread.sleep(50000);
        js.executeScript("console.log(arguments[0])", toDoElements);
        for (WebElement el : toDoElements) {
            //js.executeScript("arguments[0].click()", el);
            el.click();
            Thread.sleep(1000);
        }
        List<WebElement> toDoTexts = driver.findElements(By.className("edit"));
        System.out.println(toDoTexts.get(0).getText());
        System.out.println(ExpectedConditions.textToBePresentInElement(toDoTexts.get(0), "Meet a Friend"));
        Thread.sleep(2000);
        driver.get("https://todomvc.com/");
        System.out.println(technologies.get(1).getText());

    }

    @ParameterizedTest()
    @ValueSource(ints = {1, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15})
    void todosMultipleTechnologies(int n) throws InterruptedException {

        List<WebElement> technologies = driver.findElements(By.cssSelector("ul.js-app-list-inner.applist.js>li>a"));

        System.out.println(technologies.size());
        technologies.get(n).click();
        Thread.sleep(2000);
        WebElement addTodo = driver.findElement(By.className("new-todo"));
        addTodo.sendKeys(n+" Meet a Friend");
        addTodo.sendKeys(Keys.ENTER);
        Thread.sleep(700);
        addTodo.sendKeys(n+" Buy Meat");
        addTodo.sendKeys(Keys.ENTER);
        Thread.sleep(700);
        addTodo.sendKeys(n+" Clean the car");
        addTodo.sendKeys(Keys.ENTER);
        Thread.sleep(700);

    }

 /*   @Test
    public void cliquer(JavascriptExecutor js, WebElement w) throws InterruptedException {

    }*/


    @AfterEach
    public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }


}
