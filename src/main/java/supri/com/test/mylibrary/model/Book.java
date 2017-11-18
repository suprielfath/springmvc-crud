package supri.com.test.mylibrary.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Book {

	private Long id;
	private String 	title;
	private String 	authors;
	private String 	publisher;
	private Date   	publishedOn;
	private String 	typeofbook;
	private Integer numberofpages;
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

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

	@Column (nullable = false)
	public String getTitle() {
		return title;
	}
	
	@Column
	public String getTypeofbook() {
		return typeofbook;
	}
	
	@Column
	public Integer getNumberofpages() {
		return numberofpages;
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

	public void setTypeofbook(String typeofbook) {
		this.typeofbook = typeofbook;
	}

	public void setNumberofpages(Integer numberofpages) {
		this.numberofpages = numberofpages;
	}
	
}
