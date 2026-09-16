package com.ram.java.designpatterns.adapter.objectadapter;

import com.ram.java.designpatterns.adapter.BusinessCardDesigner;
import com.ram.java.designpatterns.adapter.Employee;
import com.ram.java.designpatterns.adapter.utils.EmployeeUtils;

/**
 * Driver program that depicts the Object Adapter Pattern.
 */
public class Client {

	public static void main(String[] args) {
		// We need the Adaptee object, in order to pass it on as a parameter
		// to the EmployeeObjectAdapter class.
		Employee employee = new Employee();
		EmployeeUtils.populateEmployeeData(employee);

		// Pass employee to EmployeeObjectAdapter
		EmployeeObjectAdapter adapter = new EmployeeObjectAdapter(employee);
		BusinessCardDesigner designer = new BusinessCardDesigner();

		System.out.println(designer.designCard(adapter));

		// Now we cannot pass in the adapter instance into EmployeeUtils::populateEmployeeData
		// EmployeeUtils.populateEmployeeData(adapter); // this will be compile time error
	}

}
