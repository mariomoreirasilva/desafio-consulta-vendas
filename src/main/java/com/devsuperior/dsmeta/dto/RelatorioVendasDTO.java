package com.devsuperior.dsmeta.dto;

import java.time.LocalDate;

import com.devsuperior.dsmeta.projections.RelatorioVendasProjection;
//antes estava com erro pois o nome dos campos do dto estava diferentes da entity.
public class RelatorioVendasDTO {
	
	private Long id;
	private LocalDate date;
	private Integer deals;
	private String name;
	
	public RelatorioVendasDTO() {		
	}

	public RelatorioVendasDTO(Long id, LocalDate data, Integer qtdVendida, String nomeVendedor) {		
		this.id = id;
		this.date = data;
		this.deals = qtdVendida;
		this.name = nomeVendedor;
	}
	
	public RelatorioVendasDTO(RelatorioVendasProjection projection) {
		id = projection.getId();
		date = projection.getdate();
		deals = projection.getDeals();
		name = projection.getname();
	}

	public Long getId() {
		return id;
	}

	public LocalDate getdate() {
		return date;
	}

	public Integer getDeals() {
		return deals;
	}

	public String getName() {
		return name;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setData(LocalDate data) {
		this.date = data;
	}

	public void setqtdVendida(Integer qtdVendida) {
		this.deals = qtdVendida;
	}

	public void setnomeVendedor(String nomeVendedor) {
		this.name = nomeVendedor;
	}

	@Override
	public String toString() {
		return "RelatorioVendasDTO [id=" + id + ", data=" + date + ", qtdVendida=" + deals + ", nomeVendedor="
				+ name + "]";
	}


}
