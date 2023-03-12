package com.company.base.steps.definitionSteps;

import com.company.base.datamodel.DataContato;
import com.company.base.steps.serenity.TesteSteps;
import cucumber.api.java.pt.*;
import net.thucydides.core.annotations.Steps;

import java.util.List;

public class DefinitionStepsTeste {

    @Steps
    TesteSteps testeSteps;

    @Dado("^que acesso o site$")
    public void queAcessoOSite() {
        testeSteps.queAcessoOSite();
    }

    @E("^clico no menu solucoes$")
    public void clicoNoMenuSolucoes() {
        testeSteps.clicoNoMenuSolucoes();
    }

    @Então("^verifico dados da pagina$")
    public void verificoDadosPagina() {
        testeSteps.verificoDadosPagina();
    }

    @E("^clico em vamos conversar$")
    public void clicoEmVamosConversar() {
        testeSteps.clicoEmVamosConversar();
    }

    @E("^preencho os dados para envio$")
    public void preenchoOsDadosParaEnvio(List<DataContato> dataContato) throws Exception {
        testeSteps.preenchoOsDadosParaEnvio(dataContato);
    }

    @Quando("^envio a mensagem$")
    public void envioAMensagem() {
        testeSteps.envioAMensagem();
    }

    @Entao("^o email é enviado$")
    public void oEmailEEnviado() {
        testeSteps.oEmailEEnviado();
    }

}
