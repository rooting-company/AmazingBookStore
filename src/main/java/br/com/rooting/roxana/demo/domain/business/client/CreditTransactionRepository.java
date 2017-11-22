package br.com.rooting.roxana.demo.domain.business.client;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rooting.roxana.demo.domain.model.CreditTransaction;

interface CreditTransactionRepository extends JpaRepository<CreditTransaction, Long> {

	
	
}
