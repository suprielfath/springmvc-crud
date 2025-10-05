package supri.com.test.mylibrary.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "book")
public class Book {

	private Long id;
	private String 	title;
	private String 	authors;
	private String 	publisher;
	private Date   	publishedOn;
	private String 	typeOfBook;
	private Integer numberOfPages;
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	@NotEmpty(message = "Authors may not be empty")
	@Column(nullable = false)
	public String getAuthors() {
		return authors;
	}

	@Column
	public String getPublisher() {
		return publisher;
	}

	@Column(name = "published_date")
	public Date getPublishedOn() {
		return publishedOn;
	}

	@NotEmpty(message = "Title may not be empty")
	@Column (nullable = false)
	public String getTitle() {
		return title;
	}
	
	@Column(name = "type_of_book")
	public String getTypeOfBook() {
		return typeOfBook;
	}
	
	@Column(name = "number_of_pages")
	public Integer getNumberOfPages() {
		return numberOfPages;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public void setAuthors(String authors) {
		this.authors = authors;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public void setPublishedOn(Date publishedOn) {
		this.publishedOn = publishedOn;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setTypeOfBook(String typeOfBook) {
		this.typeOfBook = typeOfBook;
	}

	public void setNumberOfPages(Integer numberOfPages) {
		this.numberOfPages = numberOfPages;
	}
	
}