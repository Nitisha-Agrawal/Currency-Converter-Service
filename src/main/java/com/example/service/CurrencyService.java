package com.example.service;

import org.springframework.stereotype.Service;

import com.example.DTO.CurrencyRepository;
import com.example.model.Currency;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class CurrencyService {

	@Autowired
	private CurrencyRepository currencyRepository;

	public Map<String, String> convertCurrency(String from, String to, float amount) {

		Currency currency = currencyRepository.findFactor(from, to);
		HashMap<String, String> map = new HashMap<>();
		if (currency != null) {
			String convertedAmount = (amount * currency.getFactor()) + " " + to;
			map.put("responseCode", "2000");
			map.put("responseMessage", "SUCCESS");
			map.put("result", convertedAmount);
			map.put("convertedFrom", from);
			map.put("convertedTo", to);
			return map;
		} else {
			map.put("responseCode", "2001");
			map.put("responseMessage", "NO_DATA_FOUND");
			map.put("convertedFrom", from);
			map.put("convertedTo", to);
			return map;
		}
	}
}
