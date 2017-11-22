package br.com.rooting.roxana.demo.domain.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class DebitTransaction extends Transaction {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
	@OneToMany
	private List<AmazingBook> purchuasedBooks;
	
	// Getter and Setters...
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<AmazingBook> getPurchuasedBooks() {
		return purchuasedBooks;
	}

	public void setPurchuasedBooks(List<AmazingBook> purchuasedBooks) {
		this.purchuasedBooks = purchuasedBooks;
	}

}
