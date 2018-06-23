package br.com.rooting.roxana.demo.domain.business.client;

import java.math.BigDecimal;

import br.com.rooting.roxana.exception.mapper.BusinessException;
import br.com.rooting.roxana.parameter.mapper.CurrencyParam;

@BusinessException
public class InvalidMoneyValue extends Exception {
	
	private static final long serialVersionUID = 1L;

	@CurrencyParam
	private final BigDecimal invalidMoneyValue;
	
	@CurrencyParam
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
