package com.devsuperior.dsmeta.dto;

import java.time.LocalDate;

import com.devsuperior.dsmeta.projections.RelatorioVendasProjection;

public class RelatorioVendasDTO {
	
	private Long id;
	private LocalDate data;
	private Integer qtdVendida;
	private String nomeVendedor;
	
	public RelatorioVendasDTO() {		
	}

	public RelatorioVendasDTO(Long id, LocalDate data, Integer qtdVendida, String nomeVendedor) {		
		this.id = id;
		this.data = data;
		this.qtdVendida = qtdVendida;
		this.nomeVendedor = nomeVendedor;
	}
	
	public RelatorioVendasDTO(RelatorioVendasProjection projection) {
		id = projection.getId();
		data = projection.getdate();
		qtdVendida = projection.getdeals();
		nomeVendedor = projection.getname();
	}

	public Long getId() {
		return id;
	}

	public LocalDate getdata() {
		return data;
	}

	public Integer getqtdVendida() {
		return qtdVendida;
	}

	public String getnomeVendedor() {
		return nomeVendedor;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public void setqtdVendida(Integer qtdVendida) {
		this.qtdVendida = qtdVendida;
	}

	public void setnomeVendedor(String nomeVendedor) {
		this.nomeVendedor = nomeVendedor;
	}

	@Override
	public String toString() {
		return "RelatorioVendasDTO [id=" + id + ", data=" + data + ", qtdVendida=" + qtdVendida + ", nomeVendedor="
				+ nomeVendedor + "]";
	}


}
