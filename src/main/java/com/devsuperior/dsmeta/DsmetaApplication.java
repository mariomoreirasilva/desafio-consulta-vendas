package com.devsuperior.dsmeta;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.dsmeta.dto.RelatorioVendasDTO;
import com.devsuperior.dsmeta.services.SaleService;

@SpringBootApplication
public class DsmetaApplication implements CommandLineRunner{
	@Autowired
	private SaleService service;

	public static void main(String[] args) {
		SpringApplication.run(DsmetaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		LocalDate dataIni;
		LocalDate dataFim;
		dataIni = LocalDate.parse("2022-05-01");
		dataFim = LocalDate.parse("2022-05-31");
		
		System.out.println("************TESTE SQL RAIZ******************");
		List<RelatorioVendasDTO> resultado = service.relatorioVenda(dataIni,dataFim, "odinson");
		
		for(RelatorioVendasDTO obj : resultado) {
			System.out.println(obj);
		}
		
		System.out.println("************TESTE JPQL******************");
		List<RelatorioVendasDTO> resultado2 = service.relatorioVendaJPQL(dataIni,dataFim, "odinson");

		for(RelatorioVendasDTO obj : resultado2) {
			System.out.println(obj);
		}
		
		
	}
}
