package Page;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;
import java.util.Set;


public class Page1 {
    WebDriver driver;

    @FindBy (css = "input[value='radio2']")
    WebElement RadioButton2;

    @FindBy (id = "autocomplete")
    WebElement findInput;

    @FindBy (id = "dropdown-class-example")
    WebElement dropDown;

    @FindBy (id = "checkBoxOption2")
    WebElement checkBox;

    @FindBy (id = "openwindow")
    WebElement openWindow;

    @FindBy (id = "opentab")
    WebElement openTab;

    @FindBy (id = "name")
    WebElement findInputForName;

    @FindBy (id = "confirmbtn")
    WebElement findConfirm;

    @FindBy (id = "product")
    WebElement listOfProduct;

    @FindBy (id = "hide-textbox")
    WebElement hideButton;

    @FindBy (id = "show-textbox")
    WebElement showButton;

    @FindBy (id = "displayed-text")
    WebElement inputText;

    @FindBy (id = "mousehover")
    WebElement findMouseHover;

    @FindBy (id = "mousehover")
    WebElement mouseHoverTop;


    public void clickRadioButton() {
        RadioButton2.click();
    }
    public void typeCountry (String value) {
        findInput.sendKeys(value);
    }



    public void checkDropDown() {
        Select select = new Select(dropDown);
        select.selectByIndex(2);
    }



    public boolean isCheckBoxSelected(){
        if(checkBox.isSelected()){
            return true;
        }
        return false;
    }

    public void clickCheckBox() {
        if (!isCheckBoxSelected()) {
            checkBox.click();
        }
        Assert.assertTrue(isCheckBoxSelected());
    }

    public void clickOpenWindow() {
        openWindow.click();
    }

    public void handleNewWindowTab (String title) {
        String curWindow = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();
        for (String it : handles) {
            if (!it.equals(curWindow)) {
                driver.switchTo().window(it);
                String actualTitle =  driver.getTitle();;
                String expectedTitle = title;
                Assert.assertEquals(actualTitle, expectedTitle, "The Title not match!!!!");
                driver.close();
            }
        }
        driver.switchTo().window(curWindow);
    }

    public void clickOpenTab() {
        openTab.click();
    }

    public void typeName (String value) {
        findInputForName.sendKeys(value);
    }
    public void clickConfirm() {
        findConfirm.click();
    }

    public void handleAlert (){
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
    }


    public void isContain () {
        List<WebElement> list = driver.findElements(By.id("product"));
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getText().contains("Advanced Selenium Framework Pageobject, TestNG, Maven, Jenkins,C")) {
                System.out.println("This text is available");
                break;
            }
            else {
                System.out.println("This text isn't available");
            }
        }

    }

    public void clickHideAndShow () {
        hideButton.click();
        showButton.click();
    }

    public void checkInputText (String example) {
        inputText.isDisplayed();
        inputText.sendKeys(example);
    }


    public void mouseHover (){
        Actions actions = new Actions(driver);
        actions.moveToElement(findMouseHover).perform();
        actions.contextClick(mouseHoverTop);
    }


    public Page1 (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
}

