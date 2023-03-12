package com.company.base.steps.definitionSteps;

import com.company.base.datamodel.DataContato;
import com.company.base.steps.serenity.BR3DSteps;
import com.company.base.steps.serenity.TesteSteps;
import cucumber.api.PendingException;
import cucumber.api.java.pt.*;
import net.thucydides.core.annotations.Steps;

import java.util.List;
import java.util.Map;

public class DefinitionStepsBR3D {

    @Steps
    BR3DSteps br3DSteps;

    @Dado("^que acesso o site BR 3D Soluções$")
    public void queAcessoOSiteBRDSolucoes() {
        br3DSteps.queAcessoOSiteBRDSolucoes();
    }

    @E("^pesquiso e seleciono o item \"([^\"]*)\"$")
    public void pesquisoPeloItemESelecionoOItemPesquisado(String descricaoItem) {
        br3DSteps.pesquisoESelecionoItem(descricaoItem);
    }

    @E("^informo o CEP \"([^\"]*)\" e clico em COMPRAR$")
    public void informoOCEPEClicoEmCOMPRAR(String cep) {
        br3DSteps.informoOCEPEClicoEmCOMPRAR(cep);
    }

    @E("^clico em VER CARRINHO$")
    public void clicoEmVERCARRINHO() {
        br3DSteps.clicoEmVERCARRINHO();
    }

    @E("^clico em FINALIZAR COMPRA$")
    public void clicoEmFINALIZARCOMPRA() {
        br3DSteps.clicoEmFINALIZARCOMPRA();
    }

    @E("^informo os dados de contato e clico em continuar:$")
    public void informoOsDadosDeContatoEEntrega(Map<String, String> data) {
        br3DSteps.informoOsDadosDeContatoEEntreg(data);
    }

    @Quando("^seleciono 'Boleto Bancário' como forma de pagamento e clico em FAZER PEDIDO$")
    public void selecionoBoletoEClicoEmFAZERPEDIDO() {
        br3DSteps.selecionoBoletoEClicoEmFAZERPEDIDO();
    }

    @Então("^o sistema salva o pedido com status 'Aguardando pagamento'$")
    public void oSistemaSalvaOPedidoComStatusAguardandoPagamento() {
        br3DSteps.oSistemaSalvaOPedidoComStatusAguardandoPagamento();
    }
}
