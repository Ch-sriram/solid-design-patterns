package com.ram.java.designpatterns.adapter;

/**
 * An existing class, used in our system. Adaptee for Adapter design pattern demonstration.
 */
public class Employee {

	private String fullName;
	private String jobTitle;
	private String officeLocation;
	/**
	 * @return the firstName
	 */
	public String getFullName() {
		return fullName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFullName(String firstName) {
		this.fullName = firstName;
	}
	/**
	 * @return the jobTitle
	 */
	public String getJobTitle() {
		return jobTitle;
	}
	/**
	 * @param jobTitle the jobTitle to set
	 */
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	/**
	 * @return the officeLocation
	 */
	public String getOfficeLocation() {
		return officeLocation;
	}
	/**
	 * @param officeLocation the officeLocation to set
	 */
	public void setOfficeLocation(String officeLocation) {
		this.officeLocation = officeLocation;
	}

}
