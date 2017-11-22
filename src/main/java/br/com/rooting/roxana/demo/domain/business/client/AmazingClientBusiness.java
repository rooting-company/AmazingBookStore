package br.com.rooting.roxana.demo.domain.business.client;

import java.math.BigDecimal;
import java.util.List;

import br.com.rooting.roxana.demo.domain.model.AmazingClient;
import br.com.rooting.roxana.demo.domain.model.CreditTransaction;

public interface AmazingClientBusiness {
	
	public AmazingClient create(AmazingClient client);
	
	public void alter(AmazingClient client);
	
	public AmazingClient getClient(Long id);

	public CreditTransaction buyCredit(Long id, BigDecimal money) throws InvalidMoneyValue;

	public List<CreditTransaction> getCreditTransactions(Long id);

	public CreditTransaction cancelCreditTransaction(Long id, Long creditTransactionId) throws InvalidCreditTransactionIdentifier;

}
