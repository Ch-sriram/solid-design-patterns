package com.ram.java.designpatterns.simplefactory;

import java.time.LocalDateTime;

/**
 * Represents a generic Post on a web-site. 
 */
public abstract class Post {

	private long id;
	
	private String title;

	private String content;

	private LocalDateTime createdOn;

	private LocalDateTime publishedOn;

	/**
	 * @return the id
	 */
	private long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	private void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the title
	 */
	private String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	private void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the content
	 */
	private String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	private void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the createdOn
	 */
	private LocalDateTime getCreatedOn() {
		return createdOn;
	}

	/**
	 * @param createdOn the createdOn to set
	 */
	private void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}

	/**
	 * @return the publishedOn
	 */
	private LocalDateTime getPublishedOn() {
		return publishedOn;
	}

	/**
	 * @param publishedOn the publishedOn to set
	 */
	private void setPublishedOn(LocalDateTime publishedOn) {
		this.publishedOn = publishedOn;
	}
}
