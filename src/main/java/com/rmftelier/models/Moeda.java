package main.java.com.rmftelier.models;

import java.util.Map;

public record Moeda(
        String baseCode,
        Map<String, Double> conversionRates
      )
      { }
