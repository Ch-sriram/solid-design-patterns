package com.ram.java.designpatterns.simplefactory;

/**
 * Simple factory to get an instance of {@link Product},
 * given the reference/string of the {@code Product}. 
 */
public class PostFactory {

	/**
	 * Create and return a {@link Post} object based on the given type of post as a {@code String}.
	 *
	 * @param type accepts 3 values: {@code "blog"}, {@code "news"}, and {@code "product"}
	 * @return a {@link Post} object
	 */
	public static Post createPost(String type) {
		if (type == null) {
			throw new IllegalArgumentException("Post type cannot be null");
		}

		switch (type.toLowerCase().trim()) {
			case "blog": return new BlogPost();
			case "news": return new NewsPost();
			case "product": return new ProductPost();
			default: throw new IllegalArgumentException("Invalid post type provided!");
		}
	}

}
