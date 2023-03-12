package com.company.base.pages;

import com.company.base.datamodel.DataContato;
import com.company.base.util.DataHelper;
import com.company.base.util.DateHelper;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

@DefaultUrl("https://loja.br3dsolucoes.com.br/")
public class PageBR3D extends BasePage {

    @FindBy(xpath = "(//input[@type='search'])[1]")
    private WebElementFacade txtPesquisa;

    @FindBy(xpath = "(//strong[contains(.,'Miniatura')])[1]")
    private WebElementFacade primeiroItemResultadoPesquisa;

    @FindBy(xpath = "(//input[@name='zipcode'][@placeholder='Seu CEP'])[2]")
    private WebElementFacade txtCEP;

    @FindBy(xpath = "(//button[contains(.,'Calcular')])[2]")
    private WebElementFacade btnCalcular;

    @FindBy(xpath = "//input[@data-store='product-buy-button']")
    private WebElementFacade btnComprar;

    @FindBy(xpath = "(//a[contains(.,'Ver carrinho')])[1]")
    private WebElementFacade btnVerCarrinho;

    @FindBy(xpath = "//input[@name='go_to_checkout']")
    private WebElementFacade btnFinalizarCompra;

    @FindBy(id = "contact.email")
    private WebElementFacade txtEmail;

    @FindBy(id = "shippingAddress.first_name")
    private WebElementFacade txtNome;

    @FindBy(id = "shippingAddress.last_name")
    private WebElementFacade txtSobrenome;

    @FindBy(id = "shippingAddress.phone")
    private WebElementFacade txtTelefone;

    @FindBy(xpath = "//span[contains(.,'Sem número')]")
    private WebElementFacade checkBoxEnderecoSemNumero;

    @FindBy(id = "billingAddress.id_number")
    private WebElementFacade txtCpfOuCnpj;

    @FindBy(xpath = "//button[@type='submit'][contains(.,'Continuar')]")
    private WebElementFacade btnContinuar;

    @FindBy(id = "radio-option-nuvempago_transparent_boleto")
    private WebElementFacade boletoBancario;

    @FindBy(id = "btnFinishCheckout")
    private WebElementFacade btnFazerPedido;

    @FindBy(xpath = "//h3[contains(.,'Aguardando pagamento')]")
    private WebElementFacade labelAguardandoPagamento;


    public void pesquisoESelecionoItem(String descricaoItem) {
        txtPesquisa.sendKeys(descricaoItem);
        waitFor(primeiroItemResultadoPesquisa);
        primeiroItemResultadoPesquisa.click();
        DateHelper.waitThread(5000);

    }

    public void informoOCEPEClicoEmCOMPRAR(String cep) {
        txtCEP.sendKeys(cep);
        DateHelper.waitThread(500);
        btnCalcular.click();
        DateHelper.waitThread(500);
        btnComprar.click();
    }

    public void clicoEmVERCARRINHO() {
        waitFor(btnVerCarrinho);
        btnVerCarrinho.click();
        DateHelper.waitThread(500);
    }

    public void clicoEmFINALIZARCOMPRA() {
        waitFor(btnFinalizarCompra);
        DateHelper.waitThread(1000);
        btnFinalizarCompra.click();
    }

    public void informoOsDadosDeContatoEEntreg(Map<String, String> data) {
        DateHelper.waitThread(5000);
        txtEmail.sendKeys(data.get("email"));
        DateHelper.waitThread(500);
        txtNome.sendKeys(data.get("nome"));
        DateHelper.waitThread(500);
        txtSobrenome.sendKeys(data.get("sobrenome"));
        DateHelper.waitThread(500);
        txtTelefone.sendKeys(data.get("telefone"));
        DateHelper.waitThread(500);
        scrollAteElemento(checkBoxEnderecoSemNumero);
        checkBoxEnderecoSemNumero.click();
        DateHelper.waitThread(500);
        txtCpfOuCnpj.sendKeys(data.get("cpfCnpj"));
        DateHelper.waitThread(500);
        btnContinuar.click();
        DateHelper.waitThread(500);

    }

    public void selecionoBoletoEClicoEmFAZERPEDIDO() {
        getDriver().switchTo().frame(getDriver().findElement(By.id("iFrameResizer0")));
        waitFor(boletoBancario);
        boletoBancario.click();
        getDriver().switchTo().defaultContent();
        scrollAteElemento(btnFazerPedido);
        btnFazerPedido.click();
    }

    public void oSistemaSalvaOPedidoComStatusAguardandoPagamento() {
        Assert.assertTrue(waitFor(labelAguardandoPagamento).isVisible());
    }
}
