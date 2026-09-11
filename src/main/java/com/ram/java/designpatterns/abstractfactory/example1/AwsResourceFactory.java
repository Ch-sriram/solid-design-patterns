package com.ram.java.designpatterns.abstractfactory.example1;

import com.ram.java.designpatterns.abstractfactory.example1.Instance.Capacity;

/**
 * Concrete factory method implementation to get AWS's resources. 
 */
public class AwsResourceFactory implements ResourceFactory {

	@Override
	public Instance createInstance(Capacity capacity) {
		return new Ec2Instance(capacity);
	}

	@Override
	public Storage createStorage(int capacityInMib) {
		return new S3Storage(capacityInMib);
	}

}
