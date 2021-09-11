package com.arsh.view;

import com.arsh.model.ExchangeRates;
import com.arsh.model.PairConversion;
import com.arsh.service.ConsoleService;
import com.arsh.service.ExchangeService;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@SpringBootApplication
public class CurrencyConverterApplication {
	private static final String PAIR_URL = "https://v6.exchangerate-api.com/v6/0a67f9f345849c95b80d4bdc/pair/";
	private static final String BASE_URL = "https://api.exchangerate-api.com/v4/latest/";
	private static final String V4_URL = "https://api.exchangerate-api.com/v4/latest/";
	private ConsoleService console;

	public CurrencyConverterApplication (ConsoleService console) {
		this.console = console;
	}

	public static void main(String[] args) {
		int menuSelection;

		ConsoleService consoleService = new ConsoleService();
		ExchangeService exchangeService = new ExchangeService(V4_URL, PAIR_URL);
		//PairConversionService pairConversionService = new PairConversionService();

		while (true) {
			menuSelection = consoleService.printMainMenu();
			if (menuSelection == 1) {
				consoleService.printAllCurrencyCodes(exchangeService.getExchangeRates("USD"));
			}
			else if (menuSelection == 2) {
				ExchangeRates rates = exchangeService.getExchangeRates(consoleService.promptForBaseCode());
				if (rates != null) consoleService.printAllExchangeRates(rates);
			}
			else if (menuSelection == 3) {
				//String base = consoleService.promptForBaseCode();
				//String target = consoleService.promptForTargetCode();
				PairConversion pair = exchangeService.getPairConversion("USD", "CAD", new BigDecimal("23.45"));
				if (pair != null) consoleService.printPairConversion(pair);
			}
			else if (menuSelection == 0) consoleService.exit();
			else System.out.println("Invalid Selection");
			consoleService.next();
		}
	}

}

