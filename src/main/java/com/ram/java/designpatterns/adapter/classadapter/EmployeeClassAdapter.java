package com.ram.java.designpatterns.adapter.classadapter;

import com.ram.java.designpatterns.adapter.Customer;
import com.ram.java.designpatterns.adapter.Employee;

/**
 * Class adapter, works as two-way adapter.
 */
public class EmployeeClassAdapter extends Employee implements Customer {

	@Override
	public String getName() {
		return getFullName();
	}

	@Override
	public String getDesignation() {
		return getJobTitle();
	}

	@Override
	public String getAddress() {
		return getOfficeLocation();
	}

}
