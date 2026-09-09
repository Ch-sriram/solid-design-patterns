package com.ram.java.designpatterns.simplefactory;

import java.time.LocalDateTime;

/**
 * Represents a Post related to NEWS.
 */
public class NewsPost extends Post {
	
	private String headline;
	
	private LocalDateTime newsTime;

	/**
	 * @return the headline
	 */
	private String getHeadline() {
		return headline;
	}

	/**
	 * @param headline the headline to set
	 */
	private void setHeadline(String headline) {
		this.headline = headline;
	}

	/**
	 * @return the newsTime
	 */
	private LocalDateTime getNewsTime() {
		return newsTime;
	}

	/**
	 * @param newsTime the newsTime to set
	 */
	private void setNewsTime(LocalDateTime newsTime) {
		this.newsTime = newsTime;
	}

	@Override
	public String toString() {
		return "NewsPost [headline=" + headline + ", newsTime=" + newsTime + "]";
	}
}
