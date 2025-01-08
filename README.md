# TesteRpeTech - Projeto de Automação de Testes

## 📜 Descrição

TesteRpeTech é um projeto de automação de testes criado para validar funcionalidades de um sistema web. Este projeto combina **Selenium**, **Cucumber**, e **Java** para implementar testes automatizados que verificam cenários críticos, como a inclusão de clientes, validação de vendas e comportamentos esperados do sistema.

O projeto inclui:
- Captura de screenshots em caso de falhas.
- Geração de relatórios detalhados com **ExtentReports**.
- Utilização do padrão BDD para alinhar os testes com os critérios de aceitação.

---

## 🛠️ Tecnologias Utilizadas

- **Linguagem**: Java
- **Framework de Automação**: Selenium WebDriver
- **Framework de BDD**: Cucumber
- **Relatórios**: ExtentReports
- **Gerenciamento de Dependências**: Maven
- **Gerenciador de Drivers**: WebDriverManager
- **Navegadores Suportados**: Chrome, Edge, Firefox
- **Captura de Evidências**: `TakesScreenshot` (Selenium)

---

## 📂 Estrutura do Projeto

### Diretórios Principais

- **`src/test/java`**: Contém as classes de testes, steps do Cucumber e configurações do projeto.
  - **`steps`**: Implementação dos passos definidos nos cenários do Cucumber.
  - **`utils`**: Métodos utilitários como gerenciamento do WebDriver e configuração de relatórios.
  - **`config`**: Classes responsáveis por gerenciar as configurações do projeto.

- **`src/test/resources`**: Contém arquivos de suporte, como:
  - **`features`**: Arquivos `.feature` escritos em Gherkin.
  - **`config.properties`**: Arquivo de configuração contendo propriedades do projeto (e.g., URLs, tempo de espera).

- **`screenshots`**: Diretório criado dinamicamente para armazenar screenshots de cenários falhos.

---

## 🧑‍💻 Configuração do Ambiente

### Pré-requisitos

1. **Java JDK**: Certifique-se de ter o JDK 8 ou superior instalado.
2. **Maven**: Instale o Apache Maven para gerenciamento de dependências.
3. **IDE**: Utilize uma IDE como IntelliJ IDEA ou Eclipse.
4. **Navegadores**: Instale Chrome e/ou Edge.
5. **Drivers**: Não é necessário baixar manualmente os drivers (WebDriverManager gerencia isso automaticamente).

### Configurando o Projeto

1. **Clone o repositório**:
   ```bash
   git clone <URL_DO_REPOSITORIO>
   cd TesteRpeTech
   ```

2. **Configure o arquivo `config.properties`**:
   Edite o arquivo localizado em `src/test/resources/config.properties` e configure as propriedades do projeto:
   ```properties
   base.url=http://seu-endereco-base
   browser=chrome
   explicit.timeout=15
   username=Seu-Usuario
   password=Sua-Senha
   headless=True ou False
   environment=Seu-Ambiente
   author=Quem esta executando os testes
   ```

3. **Atualize as dependências do Maven**:
   ```bash
   mvn clean install
   ```

---

## 🚀 Executando os Testes

### Via IDE

1. Abra o projeto na sua IDE preferida.
2. Execute as classes de teste ou cenários do Cucumber utilizando as opções `Run`.

### Via Terminal

1. Execute todos os testes:
   ```bash
   mvn test
   ```

2. Execute testes específicos utilizando tags:
   ```bash
   mvn test -Dcucumber.filter.tags="@Regressivo"
   ```

---

## 📝 Estrutura dos Cenários (BDD)

Os cenários são escritos no formato Gherkin, que facilita a leitura por equipes técnicas e de negócio. Exemplo:

```gherkin
Esquema do Cenário: Inclusão de cliente com sucesso preenchendo todos os campos obrigatórios
  Dado que o sistema está disponível
  E o usuário acessa a funcionalidade de Incluir Cliente
  Quando o usuário preenche os campos
    | Nome             | <Nome>       |
    | CPF              | <CPF>        |
    | Status           | <Status>     |
    | Saldo Disponivel | <Saldo>      |
  E confirma o cadastro
  Então o sistema deve exibir a mensagem "Cliente salvo com sucesso"

  Exemplos:
    | Nome           | CPF            | Status | Saldo  |
    | Marcos Silva   | 123.456.789-00 | Ativo  | 150.00 |
    | Maria Silva    | 123.456.789-01 | Inativo| 100.00 |
```

---

## 🖼️ Captura de Screenshots

Em caso de falhas, as screenshots são salvas automaticamente na pasta `screenshots` e anexadas ao relatório **ExtentReports**.

### Exemplo de Caminho de Screenshot
```
screenshots/NOME_DO_TESTE_TIMESTAMP.png
```

---

## 📊 Relatórios

Os relatórios gerados incluem:
- **Status de Testes**: Sucesso ou falha.
- **Captura de Evidências**: Imagens de cenários falhos.
- **Detalhes**: Passos executados, tempo de execução e mensagens.

Os relatórios podem ser acessados em:
```
reports
```

---

## 🛠️ Problemas Comuns

### 1. Testes falham ao capturar screenshots
- Certifique-se de que a pasta `screenshots` possui permissões de escrita.

### 2. Relatórios não são gerados
- Verifique se o método `ConfigExtentReport.flushReport()` está sendo chamado no `@AfterAll`.

---

## 🌟 Contribuindo

1. **Faça um fork**:
   ```bash
   git fork <URL_DO_REPOSITORIO>
   ```

2. **Crie uma branch**:
   ```bash
   git checkout -b feature/nova-funcionalidade
   ```

3. **Faça as alterações e envie um PR**.

---

## 📞 Contato

Caso tenha dúvidas ou sugestões, entre em contato comigo +5511983845608.

---

