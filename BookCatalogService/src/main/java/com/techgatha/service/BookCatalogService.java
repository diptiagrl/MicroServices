package com.techgatha.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.techgatha.model.OrderWrapper;
import com.techgatha.model.OrderWrapperResponse;
import com.techgatha.model.UserCatalog;
import com.techgatha.model.UserCatalogDTO;
import com.techgatha.model.UserCatalogResponse;

@Service
public class BookCatalogService {

	@Autowired
	BookOrderFeignClient bookOrderFeignClient;
	
	@Autowired
	BookFeignClient bookFeignClient;
	
	
	public List<UserCatalog> getBooksOrdered(String email)
	{	
		
		List<OrderWrapper> orders = this.bookOrderFeignClient.getBookOrderDetails(email);
		
		return orders.stream()
		.map(wrapper ->{
			System.out.println(wrapper.getBookid());
			UserCatalog catalog = this.bookFeignClient.getBookDetails(wrapper.getBookid());
			catalog.setEmail(email);
			catalog.setDatetime(wrapper.getDatetime());
			return catalog;
		}).collect(Collectors.toList());
	}
	
	public UserCatalogResponse getBooksOrderedResponse(String email)
	{	
		System.out.println("response");
		OrderWrapperResponse resp = this.bookOrderFeignClient.getBookOrderDetailsdto(email);
		
		List<OrderWrapper> orders = resp.getOrders();
		List<UserCatalogDTO> catalogs =  orders.stream()
		.map(wrapper ->{
			System.out.println(wrapper.getBookid());
			UserCatalogDTO catalog = this.bookFeignClient.getBookDetailsDTO(wrapper.getBookid());
			catalog.setDatetime(wrapper.getDatetime());
			return catalog;
		}).collect(Collectors.toList());
		
		UserCatalogResponse ob = new UserCatalogResponse();
		ob.setEmail(email);
		ob.setCatalogdto(catalogs);
		return ob;
	}
}
