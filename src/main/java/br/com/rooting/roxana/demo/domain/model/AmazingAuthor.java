package br.com.rooting.roxana.demo.domain.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

@Entity
public class AmazingAuthor implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public static final String SEQUENCE_NAME = "amazing_client_sequence";
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotBlank
	@Size(min = 3, max = 100)
	private String name;
	
	@Past
	private LocalDate birthDate;
	
	private boolean alive;
	
	@NotBlank
	@Size(min = 3, max = 10)
	private String nationality;
	
	@Size(min = 10, max = 255)
	private String about;
	
	@OneToMany(mappedBy = AmazingBookTitle.MAPPED_BY_AUTHOR)
	private List<AmazingBookTitle> bookTitles;
	
	
	
	
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

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public List<AmazingBookTitle> getBookTitles() {
		return bookTitles;
	}

	public void setBookTitles(List<AmazingBookTitle> bookTitles) {
		this.bookTitles = bookTitles;
	}
	
}
