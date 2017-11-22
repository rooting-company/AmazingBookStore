package br.com.rooting.roxana.demo.domain.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.springframework.lang.Nullable;

@Entity
public class AmazingBook implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public static final String MAPPED_BY_OWNER = "owner";
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
	@ManyToOne(optional = false)
	@JoinColumn(updatable = false)
	private AmazingBookTitle title;
	
	@Nullable
	@ManyToOne
	private AmazingClient owner;
	
	// Getter and Setters...
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AmazingBookTitle getTitle() {
		return title;
	}

	public void setTitle(AmazingBookTitle title) {
		this.title = title;
	}

	public AmazingClient getOwner() {
		return owner;
	}

	public void setOwner(AmazingClient owner) {
		this.owner = owner;
	}

}
