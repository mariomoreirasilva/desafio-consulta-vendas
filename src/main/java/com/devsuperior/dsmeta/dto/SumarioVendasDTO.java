package com.devsuperior.dsmeta.dto;

import com.devsuperior.dsmeta.projections.SumarioVendasProjection;

public class SumarioVendasDTO {
	private String name;
	private Long sum;
	
	
	public SumarioVendasDTO() {
		
	}
	public SumarioVendasDTO(String name, Long sum) {
		this.name = name;
		this.sum = sum;
	}
	
	public SumarioVendasDTO(SumarioVendasProjection projection) {
		name = projection.getName();
		sum  = projection.getSum();
	}
	
	public String getName() {
		return name;
	}
	public Long getSum() {
		return sum;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSum(Long sum) {
		this.sum = sum;
	}
	

}
