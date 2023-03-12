package com.company.base.steps.serenity;

import com.company.base.datamodel.DataContato;
import com.company.base.pages.PageTesters;
import net.thucydides.core.annotations.Step;

import java.util.List;

public class TesteSteps {

    PageTesters pageGoogle;

    @Step
    public void queAcessoOSite() {
        pageGoogle.queAcessoOSite();
    }

    @Step
    public void clicoNoMenuSolucoes() {
        pageGoogle.clicoNoMenuSolucoes();
    }

    @Step
    public void verificoDadosPagina() {
        pageGoogle.verificoDadosPagina();
    }

    @Step
    public void clicoEmVamosConversar() {
        pageGoogle.clicoEmVamosConversar();
    }

    @Step
    public void preenchoOsDadosParaEnvio(List<DataContato> dataContato) {
        pageGoogle.preenchoOsDadosParaEnvio(dataContato);
    }

    @Step
    public void envioAMensagem() {
        pageGoogle.envioAMensagem();
    }

    @Step
    public void oEmailEEnviado() {
        pageGoogle.oEmailEEnviado();
    }

}
