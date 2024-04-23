package com.devsuperior.dsmeta.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dsmeta.dto.RelatorioVendasDTO;
import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.projections.RelatorioVendasProjection;
import com.devsuperior.dsmeta.projections.SumarioVendasProjection;

public interface SaleRepository extends JpaRepository<Sale, Long> {
	
	@Query(nativeQuery = true, value = "SELECT TB_SALES .ID,DATE,DEALS,NAME FROM TB_SALES "
			+ "INNER JOIN TB_SELLER ON (TB_SALES.SELLER_ID = TB_SELLER.ID) "
			+ "WHERE DATE BETWEEN :dataIni AND :dataFim AND UPPER(NAME) LIKE UPPER(CONCAT('%', :nome, '%'))")
	List<RelatorioVendasProjection> buscaRelatorioVenda(LocalDate dataIni, LocalDate dataFim, String nome);
	
	@Query(value = "SELECT new com.devsuperior.dsmeta.dto.RelatorioVendasDTO(obj.id, obj.date, obj.deals, obj.seller.name) "
			+ "FROM Sale obj "		
			+ "WHERE obj.date BETWEEN :dataIni AND :dataFim "
			+ "AND UPPER(obj.seller.name) LIKE UPPER(CONCAT('%', :nome, '%'))")
	List<RelatorioVendasDTO> buscaRelatorioVendaJPQL(LocalDate dataIni, LocalDate dataFim, String nome);
	
	@Query(value = "SELECT new com.devsuperior.dsmeta.dto.RelatorioVendasDTO(obj.id, obj.date, obj.deals, obj.seller.name) "
			+ "FROM Sale obj "		
			+ "WHERE obj.date BETWEEN :dataIni AND :dataFim "
			+ "AND UPPER(obj.seller.name) LIKE UPPER(CONCAT('%', :nome, '%'))")
	Page<RelatorioVendasProjection> buscaRelatorioVendaPaginado(LocalDate dataIni, LocalDate dataFim, String nome, Pageable pegeable);
	
	@Query(value = "SELECT new com.devsuperior.dsmeta.dto.SumarioVendasDTO(obj.seller.name, SUM(obj.amount)) "
			+ "FROM Sale obj "		
			+ "WHERE obj.date BETWEEN :dataIni AND :dataFim "
			+ "GROUP BY obj.seller.name")
	List<SumarioVendasProjection> buscaSumarioVenda(LocalDate dataIni, LocalDate dataFim);

}
