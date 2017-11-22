package br.com.rooting.roxana.demo.domain.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import org.springframework.lang.Nullable;

@MappedSuperclass
public abstract class Transaction implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@NotNull
	private Integer credit;

	@Nullable
	@PastOrPresent
	private LocalDateTime date;
	
	@NotNull
	@ManyToOne(optional = false)
	@JoinColumn(updatable = false)
	private AmazingClient client;
	
	@NotNull
	private Status status = Status.ACTIVE;
	
	@Nullable
	@PastOrPresent
	private LocalDateTime cancellingDate;

	public Integer getCredit() {
		return credit;
	}

	public void setCredit(Integer credit) {
		this.credit = credit;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public AmazingClient getClient() {
		return client;
	}

	public void setClient(AmazingClient client) {
		this.client = client;
	}
	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public LocalDateTime getCancellingDate() {
		return cancellingDate;
	}

	public void setCancellingDate(LocalDateTime cancellingDate) {
		this.cancellingDate = cancellingDate;
	}

	public enum Status {
		ACTIVE, CANCELLED
	}
	
}
