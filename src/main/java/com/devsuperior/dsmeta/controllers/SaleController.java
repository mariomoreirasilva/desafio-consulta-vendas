package com.devsuperior.dsmeta.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsmeta.dto.RelatorioVendasDTO;
import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.dto.SumarioVendasDTO;
import com.devsuperior.dsmeta.services.SaleService;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

	@Autowired
	private SaleService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<SaleMinDTO> findById(@PathVariable Long id) {
		SaleMinDTO dto = service.findById(id);
		return ResponseEntity.ok(dto);
	}

	@GetMapping(value = "/report")
	public ResponseEntity<Page<RelatorioVendasDTO>> getReport(@RequestParam(name = "minDate" , required = false)String dataIni,
	                                                          @RequestParam(name = "maxDate", required  = false)String dataFim,
	                                                          @RequestParam(name = "name",defaultValue = "") String nome, 
	                                                          Pageable pageable) {
		
		Page<RelatorioVendasDTO> relDTO = service.relatorioVendaPaginado(dataIni, dataFim, nome, pageable);
		return ResponseEntity.ok(relDTO);
	}

	@GetMapping(value = "/summary")
	public ResponseEntity<List<SumarioVendasDTO>> getSummary(@RequestParam(name = "minDate" , required = false)String dataIni,
            												@RequestParam(name = "maxDate", required  = false)String dataFim) {
		List<SumarioVendasDTO> sumarioDTO = service.sumarioVenda(dataIni, dataFim);
		
		return ResponseEntity.ok(sumarioDTO);
	}
}
