package com.company.util;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Optional;

public class SeleniumWaitHelper {

    private WebDriver driver;
    private Wait<WebDriver> wait;

    /**
     * LOG
     */
    final static Logger logger = Logger.getLogger(SeleniumWaitHelper.class);

    public SeleniumWaitHelper(final WebDriver driver) {
        this.driver = driver;
        this.wait = new FluentWait<WebDriver>(this.driver)
                .withTimeout(Duration.ofSeconds(getTimeOutOfSecondsProp()))
                .pollingEvery(Duration.ofMillis(getPollingEveryOfMillisProp()))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);
    }

    /**
     * Uses a condition in an element to check if it is visible and activated in
     * such a way that you can click on it
     *
     * @param locator xpath locator.
     * @author caio.ribeiro
     * @since 27/08/2018.
     */
    public void clickWhenReady(final By locator) {
        logger.info("clickWhenReady locator: " + locator);

        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    /**
     * Uses a condition in an element to check if it is visible and activated in
     * such a way that you can click on it
     *
     * @param element xpath locator.
     * @author caio.ribeiro
     * @since 27/08/2018.
     */
    public void clickWhenReady(WebElement element) {
        logger.info("clickWhenReady WebElement: " + element.toString());

        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    /**
     * Uses a condition in an element to check if it is visible and activated in
     * such a way that you can click on it
     *
     * @param element xpath locator.
     * @author caio.ribeiro
     * @since 27/08/2018.
     */
    public void whenReady(WebElement element) {
        logger.info("clickWhenReady WebElement: " + element.toString());
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Helper method that explicit wait for an element to be visible or clickable.
     *
     * @param locator
     * @return
     * @author caio.ribeiro
     * @since 30/08/2018
     */
    public WebElement getWhenVisible(final By locator) {
        logger.info("getWhenVisible locator: " + locator);

        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Wait element visibility of.
     *
     * @param element
     * @author caio.ribeiro
     * @since 10/09/2018
     */
    public void waitElementVisibilityOf(final WebElement element) {
        logger.info("waitElementVisibilityOf" + element.toString());
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Wait for element to disappear
     *
     * @param locator
     * @author caio.ribeiro
     * @since 10/09/2018
     */
    public void waitingDisappearElement(By locator) {
        logger.info("waitingDisappearElement: " + locator);

        try {
            WebElement element = driver.findElement(locator);
            wait.until((ExpectedConditions.invisibilityOfElementLocated(locator)));
        } catch (NoSuchElementException e) {
            logger.error("Element is not visible" + locator);
        }
    }

    /**
     * Clicks at the current mouse location.
     *
     * @param element
     * @author caio.ribeiro
     * @since 12/09/2018
     */
    public void clickActions(WebElement element) {
        logger.info("clickActions" + element.toString());

        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
    }

    /**
     * Move at the current mouse location.
     *
     * @param element
     * @author weslley.oliveira
     * @since 12/09/2018
     */
    public void moveActions(WebElement element) {
        logger.info("moveActions" + element.toString());

        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    /**
     * Return property to set timeout.
     *
     * @return
     * @author caio.ribeiro
     */
    private Integer getTimeOutOfSecondsProp() {

        logger.info("getTimeOutProperty");
        String prop = UtilProperties.getProjectProperty("timeoutOfSeconds");
        Integer timeout = 15;

        if (prop != null && !prop.isEmpty()) {
            timeout = Integer.parseInt(prop);
        }

        return timeout;
    }

    /**
     * Return property to set polling every.
     *
     * @return
     * @author caio.ribeiro
     */
    private Integer getPollingEveryOfMillisProp() {

        logger.info("getPollingEveryProp");
        String prop = UtilProperties.getProjectProperty("pollingEveryOfMillis");
        Integer pollingEvery = 500;

        if (prop != null && !prop.isEmpty()) {
            pollingEvery = Integer.parseInt(prop);
        }

        return pollingEvery;
    }

    /**
     * Verifies if element exists on the screen.
     *
     * @return
     * @author weslley.oliveira
     */
    public Boolean existsElement(By locator) {
        logger.info("existsElement");
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            logger.error("NoSuchElementException - existsElement" + e.getMessage());
            return false;
        }
    }

    /**
     * Verifies if element exists on the screen.
     *
     * @return
     * @author weslley.oliveira
     */
    public Boolean existsElement(WebElement element) {
        logger.info("existsElement");
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            return true;
        } catch (NoSuchElementException e) {
            logger.error("NoSuchElementException - existsElement" + e.getMessage());
            return false;
        }
    }

    /**
     * @param checkBox
     * @param value
     * @author weslley.oliveira
     */
    public void setCheck(WebElementFacade checkBox, String value) {
        logger.info("setCheck");

        if (value.equals("selecionado") && !checkBox.isSelected())
            checkBox.click();
        else if (value.equals("naoSelecionado") && checkBox.isSelected())
            checkBox.click();

    }

    /**
     * @param checkBox
     * @param value
     * @author weslley.oliveira
     */
    public void setCheck(WebElement checkBox, String value) {
        logger.info("setCheck");

        if (value.equals("selecionado") && !checkBox.isSelected())
            checkBox.click();
        else if (value.equals("naoSelecionado") && checkBox.isSelected())
            checkBox.click();

    }

    /**
     * Accept alert
     *
     * @author weslley.oliveira
     * @since 31/10/2018
     */
    public void alertOk() {
        logger.info("alertOk");

        try {
            this.wait = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(3));
            wait.until(ExpectedConditions.alertIsPresent()).accept();
        } catch (TimeoutException e) {
            logger.error("TimeoutException - alertOk" + e.getMessage());
        } finally {
            this.wait = new FluentWait<WebDriver>(this.driver)
                    .withTimeout(Duration.ofSeconds(getTimeOutOfSecondsProp()))
                    .pollingEvery(Duration.ofMillis(getPollingEveryOfMillisProp()))
                    .ignoring(NoSuchElementException.class)
                    .ignoring(StaleElementReferenceException.class);
        }
    }

    /**
     * Wait Accept alert
     *
     * @author weslley.oliveira
     * @since 31/10/2018
     */
    public void waitAlertOk() {
        logger.info("waitAlertOk");

        try {
            wait.until(ExpectedConditions.alertIsPresent()).accept();
        } catch (NoAlertPresentException e) {
            logger.error("NoAlertPresentException - waitAlertOk" + e.getMessage());
        }
    }

    /**
     * Cancel alert
     *
     * @author weslley.oliveira
     * @since 31/10/2018
     */
    public void alertCancel() {
        logger.info("alertCancel");

        try {
            this.wait = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(3));
            driver.switchTo().alert().dismiss();
        } catch (TimeoutException e) {
            logger.error("TimeoutException - alertCancel" + e.getMessage());
        } finally {
            this.wait = new FluentWait<WebDriver>(this.driver)
                    .withTimeout(Duration.ofSeconds(getTimeOutOfSecondsProp()))
                    .pollingEvery(Duration.ofMillis(getPollingEveryOfMillisProp()))
                    .ignoring(NoSuchElementException.class)
                    .ignoring(StaleElementReferenceException.class);
        }

    }

    /**
     * Type in alert
     *
     * @param text
     * @author weslley.oliveira
     * @since 31/10/2018
     */
    public void alertType(String text) {
        logger.info("alertType");

        try {
            this.wait = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(3));
            driver.switchTo().alert().sendKeys(text);
        } catch (TimeoutException e) {
            logger.error("TimeoutException - alertType" + e.getMessage());
        } finally {
            this.wait = new FluentWait<WebDriver>(this.driver)
                    .withTimeout(Duration.ofSeconds(getTimeOutOfSecondsProp()))
                    .pollingEvery(Duration.ofMillis(getPollingEveryOfMillisProp()))
                    .ignoring(NoSuchElementException.class)
                    .ignoring(StaleElementReferenceException.class);
        }
    }

    /**
     * Return text alert
     *
     * @return
     * @author weslley.oliveira
     * @since 31/10/2018
     */
    public String alertGetText() {
        logger.info("alertGetText");

        try {
            this.wait = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(3));
            return driver.switchTo().alert().getText();
        } catch (TimeoutException e) {
            logger.error("TimeoutException - alertGetText" + e.getMessage());
            throw new TimeoutException("TimeoutException - alertGetText" + e.getMessage());
        } finally {
            this.wait = new FluentWait<WebDriver>(this.driver)
                    .withTimeout(Duration.ofSeconds(getTimeOutOfSecondsProp()))
                    .pollingEvery(Duration.ofMillis(getPollingEveryOfMillisProp()))
                    .ignoring(NoSuchElementException.class)
                    .ignoring(StaleElementReferenceException.class);
        }
    }

    /**
     * Wait getText alert
     *
     * @author weslley.oliveira
     * @since 31/10/2018
     */
    public String waitAlertGetText() {
        logger.info("waitAlertGetText");

        try {
            return wait.until(ExpectedConditions.alertIsPresent()).getText();
        } catch (NoAlertPresentException e) {
            logger.error("NoAlertPresentException - waitAlertGetText" + e.getMessage());
            throw new TimeoutException("NoAlertPresentException - waitAlertGetText" + e.getMessage());
        }
    }

    /**
     * Imput de variável para ser utilizada em outros cenários
     *
     * @param key
     * @param value
     * @author weslley.oliveira
     * @since 13/11/2018
     */
    public void setString(String key, String value) {
        logger.info("setString");
        Serenity.setSessionVariable(key).to(value);
    }

    /**
     * Recupera variável inserida através do "setSting"
     *
     * @param key
     * @return
     * @author weslley.oliveira
     * @since 13/11/2018
     */
    public String getString(String key) {
        logger.info("getString");

        Optional op = Optional.ofNullable(Serenity.sessionVariableCalled(key));
        return op.map(o -> o.toString()).get().toString();
    }

    /**
     * @author caio ribeiro
     * @since 24/04/2019
     */
    public static void switchTab() {
        logger.info("switchTab");
        ArrayList<String> tabs = new ArrayList<String>(ThucydidesWebDriverSupport.getDriver().getWindowHandles());
        for (String win : tabs) {
            ThucydidesWebDriverSupport.getDriver().switchTo().window(win);
        }

    }

}
