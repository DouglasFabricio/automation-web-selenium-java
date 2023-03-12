package com.company.base.pages;

import com.company.base.util.DateHelper;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.interactions.Actions;

public class BasePage extends PageObject {

    @FindBy(id = "overlay_spin")
    private WebElementFacade overlaySpin;

    @FindBy(xpath = "//*[@id='overlay_bg'][@class='on']")
    private WebElementFacade overlayBg;

    @FindBy(id = "SPAN_AlertOKConfirmacao")
    private WebElementFacade btnOK;

    @FindBy(id = "btn_AlertaConfirmacao")
    WebElementFacade botaoAlertaOK;

    private static long timeMillis = 0;
    /**
     * LOG
     */
    final static Logger logger = Logger.getLogger(BasePage.class);




    public void typeAndVerify(WebElementFacade element, String value) {
        int count = 0;
        element.clear();

        while (!element.getAttribute("value").trim().equals(value) && count < 3) {
            count++;
            element.clear();
            element.click();

            for (char c : value.toCharArray()) {

                DateHelper.waitThread(200);
                element.sendKeys(String.valueOf(c));


            }

        }
    }

    public void sliceAndType(WebElementFacade element, String value){
        element.click();
        for(char c: value.toCharArray()){
            DateHelper.waitThread(100);
            element.sendKeys(String.valueOf(c));
                    }
    }

    public interface ElemAction {
        void performAction(WebElementFacade elem);
    }

    public void waitTableActionAct(WebElementFacade elem, ElemAction action) {
        try {
            action.performAction(elem);
        } catch (WebDriverException e) {
            if (timeMillis == 0) {
                timeMillis = System.currentTimeMillis();
            }

            if (!DateHelper.waitTime(10000, timeMillis)) {
                throw new WebDriverException(e.getMessage());
            }

            waitTableActionAct(elem, action);
        }
    }

    public void waitableAction(WebElementFacade elem, ElemAction action) {
        timeMillis = 0;
        waitTableActionAct(elem, action);
    }

    public void scrollAteElemento(WebElementFacade elemento) {
        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);", elemento);
    }

    public void duploClique(WebElementFacade elemento) {
        Actions action = new Actions(ThucydidesWebDriverSupport.getDriver());
        action.doubleClick(elemento).perform();
    }

}
