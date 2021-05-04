package com.example.DTO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.model.Currency;


public interface CurrencyRepository extends JpaRepository<Currency, Integer>{
	@Query("SELECT c From Currency c Where c.from=?1 and c.to=?2")
	public Currency findFactor(String from, String to);
	

}
