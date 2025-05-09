<h1 align="center">🪙 Conversor de Moedas </h1>

Conversor de moeda desenvolvido durante a Formação Java e Orientação a Objetos do programa Oracle Next Education (ONE) em parceria com a Alura. 

A aplicação foi desenvolvida em Java e permite a conversão entre diferentes moedas por meio do consumo da API externa ExchangeRate-API, utilizada para recuperar as taxas de câmbio.  


<h2> 🛠️ Funcionalidades </h2>

- 6 opções de conversão de moedas, entre elas: Dólar para Peso Argentino e Real brasileiro para Dólar;
- Histórico de conversões;
- Visualização do resultado da conversão.

<h3> 🚀 Tecnologias Utilizadas </h3>

- **Java 19 SE**
- **Gson** - Biblioteca para serialização/desserialização de JSON
- **ExchangeRate-API** - API externa para obter as informações sobre as moedas


<h2> 💻 Como Executar </h2>

> Siga os passos abaixo para executar o projeto localmente:

1. Clone este repositório para sua máquina local:
      ```
        git clone https://github.com/rmftelier/challenge-conversor-moedas.git
        cd challenge-conversor-moedas
      ```

2. Configure a API Key:
   
   - Crie uma conta no [ExchangeRate-API](https://www.exchangerate-api.com/);
   - No painel, gere sua API Key;
   - Crie um arquivo `.env` na base do projeto e adicione a linha:
     
      ```
        API_KEY=SUA_SECRET_KEY_AQUI
      ```

3. Execute usando Intellij:

      - Abra o projeto;
      - Clique com o botão direito na pasta `libs` → `Add as Library`;
      - Execute o projeto clicando em `Run ▶️`
