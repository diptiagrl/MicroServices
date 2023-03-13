package com.citi.ms.repo;

import org.springframework.data.repository.CrudRepository;

import com.citi.ms.entity.ExchangeValue;

public interface ExchangevalueRepo extends CrudRepository<ExchangeValue, Integer>{

	
	public ExchangeValue findByFromAndTo(String from, String to);
	
}
