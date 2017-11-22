package br.com.rooting.roxana.demo.web.resource.client;

import br.com.rooting.roxana.demo.domain.model.AmazingBook;
import io.swagger.annotations.ApiModelProperty;

class BookRespDTO {
	
	@ApiModelProperty(position = 0, value = "Identifier of the Book", example = "1")
	private Long id;
	
	@ApiModelProperty(position = 1, value = "Name of the Book", example = "Lord of The Ring - The Return of The King")
	private String name;
	
	@ApiModelProperty(position = 2, value = "Name of the Author of the Book", example = "J. R. R. Tolkien")
	private String author;
	
	@ApiModelProperty(position = 3, value = "Synopsis of the Book", example = "")
	private String synopsis;
	
	public BookRespDTO(final AmazingBook book) {
		this.setId(book.getId());
		this.setName(book.getTitle().getName());
		this.setAuthor(book.getTitle().getAuthor().getName());
	}
	
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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

}
