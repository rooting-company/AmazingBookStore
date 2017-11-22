package br.com.rooting.roxana.demo.domain.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class AmazingBookTitle implements Serializable  {
	
	private static final long serialVersionUID = 1L;

	public static final String MAPPED_BY_AUTHOR = "author";
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
	@Size(max = 255)
	private String name;
	
	@NotNull
	@ManyToOne(optional = false)
	@JoinColumn(updatable = false)
	private AmazingAuthor author;
	
	@NotNull
	private LocalDate firstPublicationDate;
	
	@NotBlank
	@Size(min = 10, max = 255)
	private String synopsis;
	
	@Min(0L)
	@NotNull
	private BigDecimal price;
	
	// Getter and Setters...
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AmazingAuthor getAuthor() {
		return author;
	}

	public void setAuthor(AmazingAuthor author) {
		this.author = author;
	}

	public LocalDate getFirstPublicationDate() {
		return firstPublicationDate;
	}

	public void setFirstPublicationDate(LocalDate firstPublicationDate) {
		this.firstPublicationDate = firstPublicationDate;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}
	
	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
}
