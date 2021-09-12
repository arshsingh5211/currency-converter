package com.arsh.service;

import com.arsh.model.ExchangeRates;
import com.arsh.model.PairConversion;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Iterator;
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
        System.out.println("1: List all possible currencies");
        System.out.println("2: List all exchange rates");
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
        StringBuilder sb = new StringBuilder();
        Iterator<Map.Entry<String, Double>> iter = rates.getRates().entrySet().iterator();
        int count = 0;
        while (iter.hasNext()) {
            Map.Entry<String, Double> entry = iter.next();
            String val = entry.getValue() + "";
            while (val.length() < 7) val = val + " ";
            sb.append(String.format("%10s", entry.getKey() + ": " + val + "\t\t"));
            count++;
            if (count % 8 == 0) sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public void printAllCurrencyCodes(ExchangeRates rates) {
        String[] keys = rates.getRates().keySet().toArray(String[]::new);
        for (int i = 1; i < keys.length; i++) { // start at 1 as we don't need the Base Code listed here
            if (i % 15 == 0) System.out.printf("%10s%n", keys[i]);
            else System.out.printf("%10s", keys[i]);
        }
        System.out.println("\n\n");
    }

    public String promptForBaseCode() {
        System.out.print("What currency would you like to start with? ");
        return scanner.next().toUpperCase();
    }

    public String promptForTargetCode() {
        System.out.print("What currency would you like to convert to? ");
        return scanner.next().toUpperCase();
    }

    public BigDecimal promptForAmount() {
        System.out.print("What amount would you like to convert? ");
        return scanner.nextBigDecimal();
    }

    public void printPairConversion (PairConversion pair) {
        System.out.println("");
        System.out.println("--------------------------------------------");
        System.out.println("Conversion Details");
        System.out.println("--------------------------------------------");
        if(pair == null){
            System.out.println("No conversions to print");
        } else {
            System.out.println("Base Code: " + pair.getBase_code());
            System.out.println("Target Code: " + pair.getTarget_code());
            System.out.println("Conversion Rate: " + pair.getConversion_rate());
            System.out.println("Conversion Result: " +
                    NumberFormat.getCurrencyInstance().format(pair.getConversion_result()));
        }
    }

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
