package com.ram.java.designpatterns.simplefactory;

/**
 * Driver program for creating and using a {@link PostFactory}. 
 */
public class Client {
	
	private static final String BLOG = "blog";
	private static final String NEWS = "news";
	private static final String PRODUCT = "product";
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Post blogPost = PostFactory.createPost(BLOG);
		Post newsPost = PostFactory.createPost(NEWS);
		Post productPost = PostFactory.createPost(PRODUCT);

		System.out.println(blogPost);
		System.out.println(newsPost);
		System.out.println(productPost);
	}
}
