package main.java.com.rmftelier.controller;

import main.java.com.rmftelier.models.ConversorMoeda;

import java.util.Scanner;

public class ConversorController {
      private final Scanner leitura = new Scanner(System.in);
      private final ConversorMoeda conversorMoeda = new ConversorMoeda();

      public void iniciar(){
          while(true){
              exibirMenu();
              int opcao = leitura.nextInt();
              leitura.nextLine();

              if(opcao == 8){
                  System.out.println("Conversor de Moedas Finalizado, até a próxima!");
                  break;
              }

              String moedaOrigem, moedaDestino;

              switch(opcao){
                  case 1 -> { moedaOrigem = "USD"; moedaDestino = "ARS";}
                  case 2 -> { moedaOrigem = "ARS"; moedaDestino = "USD";}
                  case 3 -> { moedaOrigem = "USD"; moedaDestino = "BRL";}
                  case 4 -> { moedaOrigem = "BRL"; moedaDestino = "USD";}
                  case 5 -> { moedaOrigem = "USD"; moedaDestino = "COP";}
                  case 6 -> { moedaOrigem = "COP"; moedaDestino = "USD";}
                  case 7 -> {
                      conversorMoeda.historico();
                      continue;

                  }
                  default -> {
                      System.out.println("Opção inválida, por favor escolha novamente.");
                      continue;
                  }
              }

              System.out.printf("Digite o valor da moeda %s que deseja converter: \n", moedaOrigem);
              double valor = leitura.nextDouble();
              leitura.nextLine();

              double taxaConversao = conversorMoeda.buscaTaxaCambio(moedaOrigem, moedaDestino);
              double resultado = conversorMoeda.conversaoParaMoedaEscolhida(valor, taxaConversao);
              conversorMoeda.registroConversao(moedaOrigem, moedaDestino, valor, resultado);

              System.out.printf(
                      "Resultado: Valor %.2f [%s] corresponde ao valor de %.2f [%s] quando convertido.\n",
                      valor, moedaOrigem, resultado, moedaDestino);
          }
      }

      private void exibirMenu(){
            System.out.println("\n#####------ Conversor de Moedas ------#####\n");
            System.out.println("|----------------- Menu ------------------|");
            System.out.println("|-----------------------------------------|");
            System.out.println("| Opção 1 - Dólar para Peso Argentino     |");
            System.out.println("| Opção 2 - Peso argentino para Dólar     |");
            System.out.println("| Opção 3 - Dólar para Real Brasileiro    |");
            System.out.println("| Opção 4 - Real brasileiro para Dólar    |");
            System.out.println("| Opção 5 - Dólar para Peso Colombiano    |");
            System.out.println("| Opção 6 - Peso Colombiano para Dólar    |");
            System.out.println("| Opção 7 - Histórico de Conversões       |");
            System.out.println("| Opção 8 - Sair                          |");
            System.out.println("|-----------------------------------------|");
            System.out.println("|-------- Escolha uma opção válida -------|");
      }
}
