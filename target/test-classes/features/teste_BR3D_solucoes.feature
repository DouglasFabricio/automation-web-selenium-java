#language:pt
#encoding:utf-8
@test
Funcionalidade: Efetuar compra no site da BR 3D Soluções
  Permitir que o usuario efetue uma compra

  Cenário: Efetuar compra no boleto
    Dado que acesso o site BR 3D Soluções
    E pesquiso e seleciono o item "miniatura"
    E informo o CEP "71600560" e clico em COMPRAR
    E clico em VER CARRINHO
    E clico em FINALIZAR COMPRA
    E informo os dados de contato e clico em continuar:
      | email     | testers@gmail.com |
      | nome      | Automação         |
      | sobrenome | Testers           |
      | telefone  | 61912345678       |
      | cpfCnpj   | 17584062830       |
    Quando seleciono 'Boleto Bancário' como forma de pagamento e clico em FAZER PEDIDO
    Então o sistema salva o pedido com status 'Aguardando pagamento'
