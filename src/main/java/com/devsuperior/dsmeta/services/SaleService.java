package com.devsuperior.dsmeta.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsmeta.dto.RelatorioVendasDTO;
import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.projections.RelatorioVendasProjection;
import com.devsuperior.dsmeta.repositories.SaleRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository repository;
	
	public SaleMinDTO findById(Long id) {
		Optional<Sale> result = repository.findById(id);
		Sale entity = result.get();
		return new SaleMinDTO(entity);
	}
	/*
	///Busca paginada
		@Transactional(readOnly = true)
		public Page<ClientDTO> findAll(Pageable pageable) {
			Page<Client> result = repository.findAll(pageable);		
			return result.map(x -> new ClientDTO(x));
	*/
	@Transactional(readOnly = true)
	public List<RelatorioVendasDTO> relatorioVenda(LocalDate dataIni, LocalDate dataFim, String nome) {
		List<RelatorioVendasProjection> list =  repository.buscaRelatorioVenda(dataIni, dataFim, nome);
		List<RelatorioVendasDTO> resultadoVenda = list.stream().map(x -> new RelatorioVendasDTO(x)).collect(Collectors.toList());
		return resultadoVenda;
		
	}
	
	@Transactional(readOnly = true)
	public List<RelatorioVendasDTO> relatorioVendaJPQL(LocalDate dataIni, LocalDate dataFim, String nome) {
		List<RelatorioVendasDTO> resultadoVenda =  repository.buscaRelatorioVendaJPQL(dataIni, dataFim, nome);		
		return resultadoVenda;
		
	}
	
	public Page<RelatorioVendasDTO> relatorioVendaPaginado(String dataIni, String dataFim, String nome,Pageable pegeable){
		LocalDate dIni, dFim;
		if(dataFim == "") {
			dFim = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
			dIni = dFim.minusYears(1L);
		}
		else
		{
			dIni = LocalDate.parse(dataIni);
			dFim = LocalDate.parse(dataFim);
		}
		
		Page<RelatorioVendasProjection> resultadoVenda = repository.buscaRelatorioVendaPaginado(dIni, dFim, nome, pegeable);
		return resultadoVenda.map(x -> new RelatorioVendasDTO(x));		
	}
	
	
}
