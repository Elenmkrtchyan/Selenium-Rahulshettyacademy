package Test;


import Base.SeleniumBase;
import Page.Page1;
import org.testng.annotations.Test;

public class Test1 extends SeleniumBase {
    Page1 page1;

    @Test(priority = 1)
    public void RadioButton() {
        page1 = new Page1(driver) ;
        page1.clickRadioButton();

    }
    @Test(priority = 2)
    public void Type() {
        page1 = new Page1(driver) ;
        page1.typeCountry("Armenia");

    }
    @Test(priority = 3)
    public void DropDown() {
        page1 = new Page1(driver) ;
        page1.checkDropDown();

    }
    @Test(priority = 4)
    public void Checkbox () {
        page1 = new Page1(driver) ;
        page1.isCheckBoxSelected();
        page1.clickCheckBox();

    }

    @Test(priority = 5)
    public void SwitchWindow () {
        page1 = new Page1(driver) ;
        page1.clickOpenWindow();
        page1.handleNewWindowTab("QA Click Academy | Selenium,Jmeter,SoapUI,Appium,Database testing,QA Training Academy");
    }

    @Test(priority = 6)
    public void SwitchTab () {
        page1 = new Page1(driver) ;
        page1.clickOpenTab();
        page1.handleNewWindowTab("Rahul Shetty Academy");

    }
    @Test(priority = 7)
    public void SwitchAlert () {
        page1 = new Page1(driver) ;
        page1.typeName("Elen");
        page1.clickConfirm();
        page1.handleAlert();
    }


    @Test(priority = 8)
    public void WabTable () {
        page1 = new Page1(driver);
        page1.isContain();
    }

    @Test(priority = 9)
    public void ElementDisplayed () {
        page1 = new Page1(driver) ;
        page1.clickHideAndShow();
        page1.checkInputText("Hello");
    }


    @Test(priority = 10)
    public void MouseHover () {
        page1 = new Page1(driver) ;
        page1.mouseHover();
    }
}