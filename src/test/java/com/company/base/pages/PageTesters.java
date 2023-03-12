package com.company.base.pages;

import com.company.base.datamodel.DataContato;
import com.company.base.util.DataHelper;
import com.company.base.util.DateHelper;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import java.util.List;
import static junit.framework.TestCase.assertEquals;

public class PageTesters extends BasePage {

    @FindBy(xpath = "//button[contains(.,'Soluções')]")
    private WebElementFacade btnSolucoes;

    @FindBy(xpath = "//button[contains(.,'Vamos conversar?')]")
    private WebElementFacade btnConversar;

    @FindBy(xpath = "//input[@placeholder='Digite seu nome']")
    private WebElementFacade txtNome;

    @FindBy(xpath = "//input[contains(@placeholder,'Digite seu email')]")
    private WebElementFacade txtEmail;

    @FindBy(xpath = "//input[@placeholder='Digite seu telefone']")
    private WebElementFacade txtTelefone;

    @FindBy(xpath = "//input[@placeholder='Deixe a sua mensagem']")
    private WebElementFacade txtMensagem;

    @FindBy(xpath = "//button[contains(.,'Enviar mensagem')]")
    private WebElementFacade btnEnviar;

    @FindBy(xpath = "(//div[contains(.,'Fechar')])[4]")
    private WebElementFacade btnFechar;


    public void queAcessoOSite() {
        getDriver().get("https://testersbr.bubbleapps.io/version-test");
        DateHelper.waitThread(5000);
    }

    public void clicoNoMenuSolucoes() {
        btnSolucoes.click();
        DateHelper.waitThread(5000);
    }

    public void verificoDadosPagina() {
        String Invistaemqualidadeegarantaosucessodoseuprodutodigital = getDriver().findElement(By.xpath("//h1[contains(.,'Invista em qualidade e garanta o sucesso do seu produto digital')]")).getText();
        assertEquals("Invista em qualidade e garanta o sucesso do seu produto digital", Invistaemqualidadeegarantaosucessodoseuprodutodigital);
    }

    public void clicoEmVamosConversar() {
        btnConversar.click();
        DateHelper.waitThread(1000);
    }

    public void preenchoOsDadosParaEnvio(List<DataContato> dataContato) {
        DateHelper.waitThread(500);
        txtNome.click();
        txtNome.sendKeys(DataHelper.getData(dataContato).getNome());
        DateHelper.waitThread(500);

        DateHelper.waitThread(500);
        txtEmail.click();
        txtEmail.sendKeys(DataHelper.getData(dataContato).getEmail());
        DateHelper.waitThread(500);

        DateHelper.waitThread(500);
        txtTelefone.click();
        txtTelefone.sendKeys(DataHelper.getData(dataContato).getTelefone());
        DateHelper.waitThread(500);

        DateHelper.waitThread(500);
        txtMensagem.click();
        txtMensagem.sendKeys(DataHelper.getData(dataContato).getMensagem());
        DateHelper.waitThread(500);
    }

    public void envioAMensagem() {
        btnEnviar.click();
        DateHelper.waitThread(5000);

    }

    public void oEmailEEnviado() {
        String MensagemEnviada = getDriver().findElement(By.xpath("//div[@class='bubble-element Text baTaHaEaQ'][contains(.,'Mensagem Enviada')]")).getText();
        assertEquals("Mensagem Enviada", MensagemEnviada);
        btnFechar.click();

    }


}
