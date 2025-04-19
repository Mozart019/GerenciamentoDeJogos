# Gerenciamento de Jogos

## Status do Projeto

Em desenvolvimento

## Tecnologias Aplicadas

- **Java**: Linguagem de programação principal, utilizando Java SE.
- **Swing**: Biblioteca para criação da interface gráfica desktop.
- **MySQL**: Banco de dados relacional para persistência de dados.
- **JDBC**: API para conexão entre o aplicativo Java e o banco MySQL.

## Time de Desenvolvedores

- Mozart (Desenvolvedor principal)

## Objetivo do Software

O software tem como objetivo gerenciar uma coleção de jogos, permitindo o cadastro, edição, exclusão e listagem de jogos, além de registrar e gerenciar empréstimos de jogos para amigos. Ele serve como uma ferramenta para organizar e controlar o uso de jogos físicos ou digitais.

## Funcionalidades do Sistema

- **Cadastro de Jogos**:
  - Registrar novos jogos com título (máx. 100 caracteres), plataforma (máx. 50 caracteres), gênero (máx. 50 caracteres) e data de lançamento (formato AAAA-MM-DD).
  - Validação de campos obrigatórios e formatos.
- **Edição de Jogos**:
  - Alterar informações de jogos existentes.
- **Exclusão de Jogos**:
  - Remover jogos com confirmação.
- **Listagem de Jogos**:
  - Exibir todos os jogos em uma tabela na interface.
- **Registro de Empréstimos**:
  - Registrar empréstimos com seleção de jogo e data de empréstimo.
- **Devolução de Empréstimos**:
  - Marcar a data de devolução de um empréstimo.
- **Listagem de Empréstimos**:
  - Exibir empréstimos com detalhes (jogo, data de empréstimo, data de devolução).
- **Prevenção de Duplicatas**:
  - Evitar cadastro de jogos com mesmo título e plataforma.
