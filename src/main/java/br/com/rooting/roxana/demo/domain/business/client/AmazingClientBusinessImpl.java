package br.com.rooting.roxana.demo.domain.business.client;

import java.math.BigDecimal;
import java.math.MathContext;
import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.rooting.roxana.demo.domain.model.AmazingClient;
import br.com.rooting.roxana.demo.domain.model.CreditTransaction;
import br.com.rooting.roxana.demo.domain.model.Transaction.Status;

@Service
@Transactional
class AmazingClientBusinessImpl implements AmazingClientBusiness {

	public static final BigDecimal MIN_MONEY_FOR_CREDIT = BigDecimal.TEN;
	
	public static final BigDecimal CREDIT_CONVERT_ALIQUOT = new BigDecimal(0.1D);
	
	@Autowired
	private AmazingClientRepository clientRepository;
	
	@Autowired
	private CreditTransactionRepository creditRepository;
	
	@Override
	public AmazingClient create(@Valid AmazingClient client) {
		return this.getClientRepository().saveAndFlush(client);
	}

	@Override
	public void alter(@Valid AmazingClient client) {
		this.getClientRepository().saveAndFlush(client);
	}
	
	@Override
	public List<CreditTransaction> getCreditTransactions(Long id) {
		return this.getClientRepository().getCreditTransactions(id);
	}
	
	@Override
	public CreditTransaction buyCredit(Long id, BigDecimal money) throws InvalidMoneyValue {
		this.validMoney(money);
		
		Integer creditsToAdd = this.convertMoneyInCredit(money);
		
		AmazingClient client = this.getClient(id);
		client.setCredits(client.getCredits() + creditsToAdd);
		this.alter(client);
		
		CreditTransaction transaction = new CreditTransaction();
		transaction.setCredit(creditsToAdd);
		transaction.setClient(client);
		transaction.setMoney(money);
		transaction.setDate(LocalDateTime.now());
		
		this.getCreditRepository().saveAndFlush(transaction);
		return transaction;
	}
	
	private void validMoney(@Valid @NotNull BigDecimal money) throws InvalidMoneyValue {
		
		if(money.compareTo(MIN_MONEY_FOR_CREDIT) >= 0) {
			return;
		}
		
		throw new InvalidMoneyValue(money, MIN_MONEY_FOR_CREDIT);
	}

	private Integer convertMoneyInCredit(final BigDecimal money) {
		return money.multiply(CREDIT_CONVERT_ALIQUOT, MathContext.DECIMAL128).intValue();
	}
	
	@Override
	public CreditTransaction cancelCreditTransaction(Long id, Long creditTransactionId)
			throws InvalidCreditTransactionIdentifier {
		
		CreditTransaction transaction = this.getCreditTransactions(id).stream()
				.filter(t -> t.getId().equals(creditTransactionId)).findFirst()
				.orElseThrow(() -> new InvalidCreditTransactionIdentifier(creditTransactionId));

		transaction.setStatus(Status.CANCELLED);
		transaction.setCancellingDate(LocalDateTime.now());
		this.getCreditRepository().saveAndFlush(transaction);

		AmazingClient client = transaction.getClient();
		client.setCredits(client.getCredits() - transaction.getCredit());
		this.getClientRepository().saveAndFlush(client);
		return transaction;
	}
	
	@Override
	public AmazingClient getClient(Long id) {
		return this.getClientRepository().getOne(id);
	}

	public AmazingClientRepository getClientRepository() {
		return clientRepository;
	}

	public void setClientRepository(AmazingClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}

	public CreditTransactionRepository getCreditRepository() {
		return creditRepository;
	}

	public void setCreditRepository(CreditTransactionRepository creditRepository) {
		this.creditRepository = creditRepository;
	}
	
}
