package br.com.rooting.roxana.demo.domain.business.client;

import java.math.BigDecimal;

import br.com.rooting.roxana.annotation.BusinessException;
import br.com.rooting.roxana.parameter.annotation.CurrencyParameter;

@BusinessException
public class InvalidMoneyValue extends Exception {
	
	private static final long serialVersionUID = 1L;

	@CurrencyParameter
	private final BigDecimal invalidMoneyValue;
	
	@CurrencyParameter
	private final BigDecimal minMoneyValue;
	
	InvalidMoneyValue(final BigDecimal invalidMoneyValue, final BigDecimal minMoneyValue) {
		this.invalidMoneyValue = invalidMoneyValue;
		this.minMoneyValue = minMoneyValue;
	}

	public BigDecimal getInvalidMoneyValue() {
		return invalidMoneyValue;
	}

	public BigDecimal getMinMoneyValue() {
		return minMoneyValue;
	}

}
