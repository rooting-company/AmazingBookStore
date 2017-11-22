package br.com.rooting.roxana.demo.domain.business.client;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.rooting.roxana.demo.domain.model.AmazingClient;
import br.com.rooting.roxana.demo.domain.model.CreditTransaction;

interface AmazingClientRepository extends JpaRepository<AmazingClient, Long> {

	@Query("select t from CreditTransaction t where t.client.id = :idClient")
	public List<CreditTransaction> getCreditTransactions(@Param("idClient") Long idClient);
}
