package com.devsuperior.dsmeta.projections;

import java.time.LocalDate;

public interface RelatorioVendasProjection {
	Long getId();
	LocalDate getdate();
	Integer getdeals();
	String getname();

}
