package com.ram.java.designpatterns.adapter.classadapter;

import com.ram.java.designpatterns.adapter.BusinessCardDesigner;
import com.ram.java.designpatterns.adapter.utils.EmployeeUtils;

/**
 * Driver program that depicts the Class Adapter (Two-way) pattern.
 */
public class Client {

	public static void main(String[] args) {
		EmployeeClassAdapter adapter = new EmployeeClassAdapter();
		BusinessCardDesigner designer = new BusinessCardDesigner();
		
		// We can use our Adapter instance (adapter), wherever an Adaptee is expected.
		// For e.g: populateEmployeeData(Employee employee) expects Employee (Adaptee),
		// to which, we can pass in the Adapter object, as EmployeeClassAdapter extends Employee.
		EmployeeUtils.populateEmployeeData(adapter);

		// We can pass in our Adapter (EmployeeClassAdapter) here, since adapter is expected.
		String card = designer.designCard(adapter);
		System.out.println(card);

		// The reason why a class adapter is known as a two-way adapter is mainly due to the
		// flexibility of the adapter object being accepted as an adaptee and an adapter,
		// wherever necessary, especially in situations where it's being passed in as a parameter.
	}

}
