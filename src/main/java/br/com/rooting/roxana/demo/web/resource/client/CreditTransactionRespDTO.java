package br.com.rooting.roxana.demo.web.resource.client;

import java.time.LocalDateTime;

import br.com.rooting.roxana.demo.domain.model.CreditTransaction;
import br.com.rooting.roxana.demo.domain.model.Transaction.Status;
import io.swagger.annotations.ApiModelProperty;

class CreditTransactionRespDTO {
	
	@ApiModelProperty(position = 0, value = "Identifier of the Credit Transaction", example = "1")
	private Long id;
	
	@ApiModelProperty(position = 1, value = "Amount of money transferred", example = "100.00")
	private Double money;
	
	@ApiModelProperty(position = 2, value = "Amount of credit owned", example = "10")
	private Integer credit;
	
	@ApiModelProperty(position = 3, value = "Status of the Transaction", example = "ACTIVE")
	private Status status;
	
	@ApiModelProperty(position = 4, value = "Date of Transaction", example = "")
	private LocalDateTime date;
	
	@ApiModelProperty(position = 5, value = "Cancelling date of Transaction. Empty if the transaction was not cancelled", example = "")
	private LocalDateTime cancellingDate;
	
	public CreditTransactionRespDTO(final CreditTransaction transaction) {
		this.setId(transaction.getId());
		this.setMoney(transaction.getMoney().doubleValue());
		this.setCredit(transaction.getCredit());
		this.setStatus(transaction.getStatus());
		this.setDate(transaction.getDate());
		this.setCancellingDate(transaction.getCancellingDate());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public Integer getCredit() {
		return credit;
	}

	public void setCredit(Integer credit) {
		this.credit = credit;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public LocalDateTime getCancellingDate() {
		return cancellingDate;
	}

	public void setCancellingDate(LocalDateTime cancellingDate) {
		this.cancellingDate = cancellingDate;
	}
	
}
