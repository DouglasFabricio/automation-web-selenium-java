package com.company.base.steps.serenity;

import com.company.base.datamodel.DataContato;
import com.company.base.pages.PageBR3D;
import com.company.base.pages.PageTesters;
import net.thucydides.core.annotations.Step;

import java.util.List;
import java.util.Map;

public class BR3DSteps {

    PageBR3D pageBR3D;

    @Step
    public void queAcessoOSiteBRDSolucoes() {
        pageBR3D.open();
    }

    @Step
    public void pesquisoESelecionoItem(String descricaoItem) {
        pageBR3D.pesquisoESelecionoItem(descricaoItem);
    }

    @Step
    public void informoOCEPEClicoEmCOMPRAR(String cep) {
        pageBR3D.informoOCEPEClicoEmCOMPRAR(cep);
    }

    @Step
    public void clicoEmVERCARRINHO() {
        pageBR3D.clicoEmVERCARRINHO();
    }

    @Step
    public void clicoEmFINALIZARCOMPRA() {
        pageBR3D.clicoEmFINALIZARCOMPRA();
    }

    @Step
    public void informoOsDadosDeContatoEEntreg(Map<String, String> data) {
        pageBR3D.informoOsDadosDeContatoEEntreg(data);
    }

    @Step
    public void selecionoBoletoEClicoEmFAZERPEDIDO() {
        pageBR3D.selecionoBoletoEClicoEmFAZERPEDIDO();
    }

    @Step
    public void oSistemaSalvaOPedidoComStatusAguardandoPagamento() {
        pageBR3D.oSistemaSalvaOPedidoComStatusAguardandoPagamento();
    }
}
