package com.techgatha.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

public class UserCatalogResponse {

	private String email;
	private List<UserCatalogDTO> catalogdto;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<UserCatalogDTO> getCatalogdto() {
		return catalogdto;
	}
	public void setCatalogdto(List<UserCatalogDTO> catalogdto) {
		this.catalogdto = catalogdto;
	}
	
	
	
}
