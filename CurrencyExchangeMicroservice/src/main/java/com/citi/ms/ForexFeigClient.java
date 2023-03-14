package com.citi.ms;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="FOREX-SERVICE")
public interface ForexFeigClient {

	@GetMapping("/forex/from/{from}/to/{to}")
	public CurrencyValue getConnversionMultiple(@PathVariable String from,
			@PathVariable String to);
}
