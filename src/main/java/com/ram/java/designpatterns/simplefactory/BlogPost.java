package com.ram.java.designpatterns.simplefactory;

import java.util.Arrays;

/**
 * Represents a Post object, related to a Blog. 
 */
public class BlogPost extends Post {

	private String author;

	private String[] tags;

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @return the tags
	 */
	public String[] getTags() {
		return tags;
	}

	/**
	 * @param tags the tags to set
	 */
	public void setTags(String[] tags) {
		this.tags = tags;
	}

	@Override
	public String toString() {
		return "BlogPost [author=" + author + ", tags=" + Arrays.toString(tags) + "]";
	}
}
