package com.arsh.service;

import com.arsh.model.ExchangeRates;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Scanner;

public class ConsoleService {

    private final Scanner scanner;
    private RestTemplate restTemplate = new RestTemplate();

    public ConsoleService() {
        scanner = new Scanner(System.in);
    }

    public int printMainMenu() {
        int menuSelection;
        System.out.println("Welcome to Arsh's Currency Converter! Please make a selection: ");
        System.out.println("1: List all exchange rates");
        System.out.println("2: List all possible currencies");
        System.out.println("3: Convert a currency");
        System.out.println("0: Exit");
        System.out.print("\nPlease choose an option: ");
        // ensures no InputMisMatchException is thrown
        if (scanner.hasNextInt()) {
            menuSelection = scanner.nextInt();
            scanner.nextLine();
        } else {
            menuSelection = 999;
        }
        return menuSelection;
    }

    public void printAllExchangeRates(ExchangeRates rates) {
        System.out.println("--------------------------------------------");
        System.out.println("Exchange Rates for " + rates.getBase());
        System.out.println("--------------------------------------------");
        for (Map.Entry <String, Double> entry : rates.getRates().entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public void printAllCurrencyCodes(ExchangeRates rates) {
        for (Map.Entry <String, Double> entry : rates.getRates().entrySet()) {
            System.out.println(entry.getKey());
        }
    }

/*    public String promptForBaseCode () {
        System.out.println("What currency would you like to start with?");
        String baseCode = scanner.nextLine().toUpperCase();
        return baseCode;
    }*/

    public String promptForTargetCode () {
        System.out.println("What currency would you like to convert to?");
        String targetCode = scanner.nextLine().toUpperCase();
        return targetCode;
    }

    public BigDecimal promptForAmount () {
        System.out.println("What amount would you like to convert?");
        BigDecimal amount = scanner.nextBigDecimal();
        return amount;
    }

/*    public void printPairConversion (PairConversion pair) {
        System.out.println("");
        System.out.println("--------------------------------------------");
        System.out.println("Conversion Details");
        System.out.println("--------------------------------------------");
        if(pair == null){
            System.out.println("No conversions to print");
        } else {
            System.out.println("Base Code: " + pair.getBaseCode());
            System.out.println("Target Code: " + pair.getTargetCode());
            System.out.println("Conversion Rate: " + pair.getConversionRate());
            System.out.println("Conversion Result: " + pair.getConversionResult());
        }
    }*/

    public void next() {
        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
    }

    public void exit() {
        scanner.close();
        System.exit(0);
    }

    public void printError(String errorMessage) {
        System.err.println(errorMessage);
    }

}
