package com.ram.java.designpatterns.adapter.objectadapter;

import com.ram.java.designpatterns.adapter.Customer;
import com.ram.java.designpatterns.adapter.Employee;

/**
 * Object Adapter pattern depicted by {@link EmployeeObjectAdapter}.
 *
 * Here, instead of the Adapter extending Adaptee, the Adapter is
 * composed of Adaptee's object.
 */
public class EmployeeObjectAdapter implements Customer {

	// This adapter class is composed of the adaptee class' instance 
	private Employee adapteeEmployee;

	// The adaptee class' instance is passed via the constructor
	public EmployeeObjectAdapter(Employee adapteeEmployee) {
		this.adapteeEmployee = adapteeEmployee;
	}
	
	/**
	 * We make use of adaptee's methods and implement the
	 * Target {@link Customer} interface's contract.
	 */

	@Override
	public String getName() {
		return adapteeEmployee.getFullName();
	}

	@Override
	public String getDesignation() {
		return adapteeEmployee.getJobTitle();
	}

	@Override
	public String getAddress() {
		return adapteeEmployee.getOfficeLocation();
	}

}
