package com.ram.java.designpatterns.abstractfactory.example1;

import com.ram.java.designpatterns.abstractfactory.example1.Instance.Capacity;

/**
 * Concrete factory method implementation to get GCP's resources. 
 */
public class GoogleCloudResourceFactory implements ResourceFactory {

	@Override
	public Instance createInstance(Capacity capacity) {
		return new GoogleComputeEngineInstance(capacity);
	}

	@Override
	public Storage createStorage(int capacityInMib) {
		return new GoogleCloudStorage(capacityInMib);
	}

}
