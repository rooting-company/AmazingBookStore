package br.com.rooting.roxana.demo.domain.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

@Entity
public class AmazingClient implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotBlank
	@Size(min = 3, max = 30)
	private String firstName;
	
	@NotBlank
	@Size(min = 3, max = 30)
	private String lastName;
	
	@Email
	@NotBlank
	private String email;
	
	@Past
	@NotNull
	private LocalDate birthDate;
	
	@Min(0L)
	private Integer credits = 0;
	
	@OneToMany(mappedBy = AmazingBook.MAPPED_BY_OWNER)
	private List<AmazingBook> books;
	
	// Getter and Setters...
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	
	public Integer getCredits() {
		return credits;
	}

	public void setCredits(Integer credits) {
		this.credits = credits;
	}

	public List<AmazingBook> getBooks() {
		return books;
	}

	public void setBooks(List<AmazingBook> books) {
		this.books = books;
	}
	
	
}