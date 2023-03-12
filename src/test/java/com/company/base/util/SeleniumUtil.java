package com.company.base.util;

import com.company.util.SeleniumWaitHelper;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class SeleniumUtil {
    /**
     * LOG
     */
    final static Logger logger = Logger.getLogger(SeleniumUtil.class);

    private static SeleniumWaitHelper waitHelper = new SeleniumWaitHelper(
            ThucydidesWebDriverSupport.getDriver());


    /**
     * Select item in div (Grid).
     *
     * @param elements
     * @param valueGrid
     * @author nameAutor
     * @since 03/02/2023
     */
    public static void selectItemDiv(List<WebElement> elements,
                                     String valueGrid) {

        // TODO verificar possibilidade de tratamento caso não encontre o
        // registro na lista.

        for (WebElement element : elements) {

            if (element.getText().equals(valueGrid)) {
                waitHelper.clickWhenReady(element);
            }

        }

    }

    /**
     * Select item in div (Grid) with.
     * @param elements
     * @param valueGrid
     * @author nameAutor
     * @since 03/02/2023
     */
    public static void selectItemDivDoubleClick(List<WebElement> elements,
                                                String valueGrid) {
        for (WebElement element : elements) {
            try {

                if (element.getText().equals(valueGrid)) {
                    Actions action = new Actions(
                            ThucydidesWebDriverSupport.getDriver());
                    action.doubleClick(element).perform();
                    break;
                }

            } catch (StaleElementReferenceException ex) {
            }
        }
    }

    /**
     * Drag and drop item
     *
     * @param elementMove
     * @param elementTo
     * @author nameAutor
     * @since 03/02/2023
     */
    public static void dragAndDropItem(WebElement elementMove, WebElement elementTo) {
        Actions action = new Actions(
                ThucydidesWebDriverSupport.getDriver());
        action.dragAndDrop(elementMove, elementTo).perform();

    }

    /**
     * Select item in div (Grid) with.
     *
     * @param elements
     * @param valueGrid
     * @author nameAutor
     * @since 03/02/2023
     */
    public static Boolean existsItemDiv(List<WebElement> elements,
                                        String valueGrid) {
        for (WebElement element : elements) {
            if (element.getText().trim().equals(valueGrid)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Select contains item in div (Grid) with.
     *
     * @param elements
     * @param valueGrid
     * @author nameAutor
     * @since 03/02/2023
     */
    public static Boolean containsItemDiv(List<WebElement> elements,
                                          String valueGrid) {
        for (WebElement element : elements) {
            if (element.getText().contains(valueGrid)) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param checkBox
     * @param value
     * @author nameAutor
     * @since 03/02/2023
     */
    public static void setCheckBox(WebElementFacade checkBox, String value) {
        waitHelper.setCheck(checkBox, value);
    }

    /**
     * Imput de variável para ser utilizada em outros cenários
     *
     * @param key
     * @param value
     * @author nameAutor
     * @since 03/02/2023
     */
    public static void setString(String key, String value) {
        waitHelper.setString(key, value);
    }

    /**
     * Recupera variável inserida através do "setSting"
     *
     * @param key
     * @return
     * @author nameAutor
     * @since 03/02/2023
     */
    public static String getString(String key) {
        return waitHelper.getString(key);
    }

    /**
     * @author nameAutor
     * @since 03/02/2023
     */
    public static void switchTab() {
        ArrayList<String> tabs = new ArrayList<String>(ThucydidesWebDriverSupport.getDriver().getWindowHandles());
        for (String win : tabs) {
            ThucydidesWebDriverSupport.getDriver().switchTo().window(win);
        }

    }

    //Cria uma nova aba com uma url
    public static void novaAba(String url) {
        ((JavascriptExecutor) ThucydidesWebDriverSupport.getDriver()).executeScript("window.open()");
        trocaParaAbaDireita();
        ThucydidesWebDriverSupport.getDriver().navigate().to(url);
    }

    //A partir de uma aba qualquer, troca para a próxima aba adjacente na DIREITA
    public static void trocaParaAbaDireita() {
        ArrayList<String> abas = new ArrayList<String>(ThucydidesWebDriverSupport.getDriver().getWindowHandles());

        String janelaAtual = ThucydidesWebDriverSupport.getDriver().getWindowHandle();
        int indiceAtual = abas.indexOf(janelaAtual);

        /**
         * Se o próximo indice for >= ao tamanho, a aba será trocada para a primeira, imitando a lógica
         de uma lista ligada circular
         */
        if (indiceAtual + 1 >= abas.size())
            ThucydidesWebDriverSupport.getDriver().switchTo().window((abas.get(0)));
        else
            ThucydidesWebDriverSupport.getDriver().switchTo().window((abas.get(indiceAtual + 1)));
    }


}
