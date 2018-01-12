package br.com.rooting.roxana.demo.domain.business.client;

import br.com.rooting.roxana.business.BusinessException;
import br.com.rooting.roxana.business.parameter.Parameter;

@BusinessException
public class InvalidCreditTransactionIdentifier extends Exception {

	private static final long serialVersionUID = 1L;
	
	@Parameter
	private final Long invalidIdentifier;
	
	InvalidCreditTransactionIdentifier(final Long invalidIdentifier) {
		this.invalidIdentifier = invalidIdentifier;
	}

	public Long getInvalidIdentifier() {
		return invalidIdentifier;
	}
	
}
