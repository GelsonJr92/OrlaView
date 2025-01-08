# TesteRpeTech - Projeto de Automação de Testes

## 📜 Descrição

TesteRpeTech é um projeto de automação de testes desenvolvido para validar funcionalidades críticas de um sistema web. O projeto combina **Selenium**, **Cucumber**, e **Java**, oferecendo uma solução robusta para testes automatizados. 

Este projeto foi estruturado para:
- Validar a inclusão de clientes.
- Verificar o fluxo de autenticação de usuários.
- Garantir que os comportamentos esperados do sistema sejam atendidos.

**Destaques do projeto:**
- Captura de screenshots em caso de falhas.
- Geração de relatórios detalhados com **ExtentReports**.
- Utilização do padrão BDD, promovendo alinhamento com critérios de aceitação.
- Configurações dinâmicas via arquivo `config.properties`.

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

- **`src/test/java`**: Contém as classes de testes, steps do Cucumber e configurações gerais.
  - **`steps`**: Implementação dos passos dos cenários em BDD.
    - `LoginSteps.java`: Validações relacionadas ao login.
    - `ClienteSteps.java`: Passos para inclusão e validação de clientes.
    - `Hooks.java`: Configurações executadas antes e depois de cada cenário.
  - **`utils`**: Módulos auxiliares.
    - `DriverManager.java`: Gerenciamento dos drivers dos navegadores.
    - `WaitUtils.java`: Métodos para aplicação de esperas dinâmicas.
    - `ConfigExtentReport.java`: Configuração do relatório ExtentReports.
  - **`config`**: Classes para gerenciamento de configurações.
    - `ConfigReader.java`: Leitura de parâmetros dinâmicos do arquivo `config.properties`.

- **`src/test/resources`**: Contém arquivos de suporte.
  - **`features`**: Arquivos `.feature` escritos em Gherkin.
    - `Login.feature`: Cenários de autenticação de usuários.
    - `Cliente.feature`: Cenários de inclusão de clientes.
  - **`config.properties`**: Propriedades configuráveis, como URLs e opções de navegador.

- **`screenshots`**: Diretório gerado dinamicamente para armazenar imagens de falhas.
- **`reports`**: Local onde os relatórios de execução são armazenados.

---

## 🧑‍💻 Configuração do Ambiente

### Pré-requisitos

1. **Java JDK**: Certifique-se de ter o JDK 8 ou superior instalado.
2. **Maven**: Instale o Apache Maven.
3. **IDE**: Recomenda-se IntelliJ IDEA ou Eclipse.
4. **Navegadores**: Chrome, Edge ou Firefox.
5. **Drivers**: Gerenciados automaticamente pelo WebDriverManager.

### Configurando o Projeto

1. **Clone o repositório**:
   ```bash
   git clone <URL_DO_REPOSITORIO>
   cd TesteRpeTech
   ```

2. **Configure o arquivo `config.properties`**:
   Edite o arquivo localizado em `src/test/resources/config.properties` e defina os valores adequados:
   ```properties
   base.url=http://seu-endereco-base
   browser=chrome
   explicit.timeout=15
   username=Seu-Usuario
   password=Sua-Senha
   headless=true
   environment=dev
   author=Seu-Nome
   ```

3. **Atualize as dependências do Maven**:
   ```bash
   mvn clean install
   ```

---

## 🚀 Executando os Testes

### Via IDE

1. Abra o projeto em sua IDE.
2. Execute os testes diretamente pela classe `TestRunner.java`.

### Via Terminal

1. Execute todos os testes:
   ```bash
   mvn test
   ```

2. Execute testes específicos com tags:
   ```bash
   mvn test -Dcucumber.filter.tags="@Regressivo"
   ```

---

## 📊 Relatórios

Os relatórios são gerados com o **ExtentReports**, oferecendo:
- Status dos testes (sucesso, falha, ignorado).
- Evidências visuais com screenshots de erros.
- Detalhes dos passos executados e tempo de duração.

### Localização

Os relatórios podem ser encontrados na pasta:
```
reports/Relatorio-de-testes.html
```

---

## 📝 Estrutura dos Cenários (BDD)

Os cenários são descritos em Gherkin para facilitar o entendimento por todas as partes envolvidas. Exemplo:

```gherkin
Cenário: Inclusão de cliente com sucesso
  Dado que o usuário acessa a tela de inclusão de clientes
  Quando ele preenche os campos obrigatórios corretamente
  E confirma o cadastro
  Então o sistema exibe a mensagem "Cliente salvo com sucesso"
```

---

## 🌐 Contato

Para dúvidas ou sugestões, entre em contato:
- **Nome**: Gelson Santana de Oliveira Junior
- **E-mail**: gelson.exemplo@dominio.com
- **Telefone**: +55 11 98384-5608
