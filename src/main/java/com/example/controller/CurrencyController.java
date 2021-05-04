package com.example.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.service.CurrencyService;

@Controller
@RequestMapping(path = "/currency")
public class CurrencyController {
	
	@Autowired
	private CurrencyService currencyService;

	@GetMapping(path = "/conversion")
	@ResponseBody
	public Map<String, String> convertCurrency(@RequestParam String from, @RequestParam String to, @RequestParam float amount) {
		
		return currencyService.convertCurrency(from, to, amount);
		
	}
}
			
	

