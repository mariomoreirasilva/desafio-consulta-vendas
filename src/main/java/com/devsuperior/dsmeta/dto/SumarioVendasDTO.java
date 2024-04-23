package com.devsuperior.dsmeta.dto;

import com.devsuperior.dsmeta.projections.SumarioVendasProjection;

public class SumarioVendasDTO {
	private String name;
	private Double sum;
	
	
	public SumarioVendasDTO() {
		
	}
	public SumarioVendasDTO(String name, Double sum) {
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
	public Double getSum() {
		return sum;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSum(Double sum) {
		this.sum = sum;
	}
	

}
