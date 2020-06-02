# HotelApplication

Um projeto criado para um trabalho de Faculdade, da disciplina de Estrutura de Dados. A aplicação tem como objetivo simular um sistema de informação de um Hotel fictício, utilizando de estrutura de dados (i.e. lista e fila). Integrado ao banco de dados MySQL.

Para rodar a aplicação é necessário rodar o script DDL (script_hotel) no seu MySQL. Entretanto, a versão utilizada do MySQL foi a 6.3, logo, possivelmente, você terá problemas caso tente rodar em uma versão superior ou inferior. Devido ao driver do projeto estar destinado apenas a essa versão do SGBD.

Pacotes e classes   
- app: JFrameAplicacao (main)
- conexaoBD: ConexaoBD (abstract), HospedeDAO (extends), QuartoDAO (extends), ReservaDAO (extends), ServicoDAO (extends).
- pessoa: Hospede, Endereco.
- quarto: Quarto, ReservaQuarto, Servico.
- tad: Conta, GerenciarContas, ListHospede, ListReservaQuarto, No.
