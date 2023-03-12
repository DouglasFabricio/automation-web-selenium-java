#language:pt
#encoding:utf-8
@test
Funcionalidade: Abrir o site da Testers
  Permitir que o usuario navegue no site

  Cenário: Acessar o Site Testers
    Dado que acesso o site
    E clico no menu solucoes
    Então verifico dados da pagina

  Cenário: Entre em contato
    Dado que acesso o site
    E clico em vamos conversar
    E preencho os dados para envio
      | nome  | email                | telefone    | mensagem                                              |
      | Maria | testersbra@gmail.com | 11999999999 | Preciso de um orçamento para automatizar meu software |
    Quando envio a mensagem
    Entao o email é enviado