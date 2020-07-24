# language:pt

Funcionalidade: Busca de Passagens
  Para selecionar uma passagem aérea
  Sendo um usuário
  Quero fazer busca de passagens aéreas
  
Contexto: Busca

Dado que esteja na tela inicial do site

Esquema do Cenário: Busca Sucesso

Quando informar uma <origem> válida
E inserir um <destino> válido
E uma data de ida válida
E uma data de volta válida
E o número de passageiros válido
E clicar em Procure seu voo
Então a tela com as opções de passagens será exibida

Exemplos:

|origem     |destino   |
|"São Paulo"|"Montreal"|