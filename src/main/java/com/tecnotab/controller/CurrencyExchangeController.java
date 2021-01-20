package com.tecnotab.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tecnotab.model.ExchangeValue;

@RestController
@RequestMapping("/currency-exchange")
public class CurrencyExchangeController {

	@Autowired
	private Environment environment;
	
	@GetMapping("/from/{USD}/to/{INR}")
	public ExchangeValue getExchangeValue(@PathVariable("USD") String from, @PathVariable("INR") String to) {
		ExchangeValue exchangeValue =  new ExchangeValue(1000l, from, to, BigDecimal.valueOf(70));
		exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		return exchangeValue;
	}
}
