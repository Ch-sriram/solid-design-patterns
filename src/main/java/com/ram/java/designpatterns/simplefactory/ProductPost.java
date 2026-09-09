package com.ram.java.designpatterns.simplefactory;

/**
 * Represents a Product Information Post object. 
 */
public class ProductPost extends Post {

	private String imageUrl;
	
	private String name;

	/**
	 * @return the imageUrl
	 */
	public String getImageUrl() {
		return imageUrl;
	}

	/**
	 * @param imageUrl the imageUrl to set
	 */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "ProductPost [imageUrl=" + imageUrl + ", name=" + name + "]";
	}
}
