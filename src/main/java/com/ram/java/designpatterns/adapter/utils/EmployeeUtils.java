package com.ram.java.designpatterns.adapter.utils;

import com.ram.java.designpatterns.adapter.Employee;

/**
 * Contains utility methods related to {@link Employee} adaptee. 
 */
public class EmployeeUtils {

	public static void populateEmployeeData(Employee employee) {
		employee.setFullName("Sriram Chandrabhatta");
		employee.setJobTitle("Senior Software Engineer");
		employee.setOfficeLocation("MyOwnCompany, Dr. Puneet Rajkumar Rd, Nagavara, Bengaluru, India");
	}

}
