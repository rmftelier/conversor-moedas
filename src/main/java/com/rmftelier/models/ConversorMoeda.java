package main.java.com.rmftelier.models;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import main.java.com.rmftelier.util.EnvConfig;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class ConversorMoeda {
    private final List<String> historico = new ArrayList<>();

    public double buscaTaxaCambio(String moedaOrigem, String moedaDestino){
         String apiKey = EnvConfig.get("API_KEY");

         URI endereco = URI.create("https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + moedaOrigem);

         HttpClient client = HttpClient.newHttpClient();
         HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .build();

         try {
             HttpResponse<String> response = client
                     .send(request, HttpResponse.BodyHandlers.ofString());

             Gson gson = new GsonBuilder()
                     .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                     .setPrettyPrinting()
                     .create();

             Moeda dadosMoeda = gson.fromJson(response.body(), Moeda.class);

             return dadosMoeda.conversionRates().get(moedaDestino);
         } catch (Exception e) {
             System.out.println("Erro ao buscar a taxa de câmbio.");
             throw new RuntimeException(e);
         }
    }

    public double conversaoParaMoedaEscolhida(double valor, double conversionRate){
        return valor * conversionRate;
    }

    public void registroConversao(String moedaOrigem, String moedaDestino, double valor, double resultado){
        String entrada = String.format(
                "Convertido %.2f %s → %.2f %s",
                valor, moedaOrigem, resultado, moedaDestino
        );
        historico.add(entrada);
    }

    public void historico(){
        if(historico.isEmpty()){
            System.out.println("Nenhuma conversão realizada até o momento.");
        }else{
            System.out.println("========= Histórico de Conversões =========");
            historico.forEach(System.out::println);

        }
    }
}
