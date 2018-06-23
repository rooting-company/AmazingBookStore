package br.com.rooting.roxana.demo.domain.business.client;

import br.com.rooting.roxana.exception.mapper.BusinessException;
import br.com.rooting.roxana.parameter.mapper.Param;

@BusinessException
public class InvalidCreditTransactionIdentifier extends Exception {

	private static final long serialVersionUID = 1L;
	
	@Param
	private final Long invalidIdentifier;
	
	InvalidCreditTransactionIdentifier(final Long invalidIdentifier) {
		this.invalidIdentifier = invalidIdentifier;
	}

	public Long getInvalidIdentifier() {
		return invalidIdentifier;
	}
	
}
