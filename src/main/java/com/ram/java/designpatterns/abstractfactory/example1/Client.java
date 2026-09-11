/**
 * 
 */
package com.ram.java.designpatterns.abstractfactory.example1;

import java.util.List;

import com.ram.java.designpatterns.abstractfactory.example1.Instance.Capacity;

/**
 * Driver program for demonstrating the Abstract Factory Pattern example.
 */
public class Client {
	
	private ResourceFactory factory;

	public Client(ResourceFactory factory) {
		this.factory = factory;
	}

	public Instance createServer(Capacity capacity, int capacityInMiB) {
		Instance instance = factory.createInstance(capacity);
		Storage storage = factory.createStorage(capacityInMiB);
		instance.attachStorage(storage);
		return instance;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/**
		 * As can be seen below, AwsResourceFactory and GoogleCloudResourceFactory
		 * instances are created separately by the client, but the underlying
		 * code is the same, where it's just making a call to
		 * createInstance, and createStore methods.
		 */
		List.of(new AwsResourceFactory(), new GoogleCloudResourceFactory())
			.forEach(factory -> {
				Instance instance = factory.createInstance(Capacity.SMALL);
				Storage storage = factory.createStorage(32767);
				instance.attachStorage(storage);
			});
		
		System.out.println("-----------------------------------------------------------------------");

		// We can individually create the GCP/AWS resources as follows:
		Client awsClient = new Client(new AwsResourceFactory());
		Instance awsInstance = awsClient.createServer(Capacity.MICRO, 36768);
		awsInstance.start();
		awsInstance.stop();

		Client gcpClient = new Client(new GoogleCloudResourceFactory());
		Instance gcpInstance = gcpClient.createServer(Capacity.LARGE, (int) 1e9+7);
		gcpInstance.start();
		gcpInstance.stop();
	}
	
	/**
	 * Output:
	 * ------
	 *
	 * Created AWS EC2 Instance: Ec2Instance [instanceId=2, capacity=SMALL]
     * Allocated 32767 on S3 (1)
     * Attached S3Storage [id=1, capacityInMiB=32767] to EC2 instance: 2
     * Created Google Compute Engine (GCE) Instance: GoogleComputeEngineInstance [instanceId=2, capacity=SMALL]
     * Allocated 32767 on Google Cloud Storage (1)
     * Attached: GoogleCloudStorage [id=1, capacityInMib=32767] to compute engine instance: 2
     * -----------------------------------------------------------------------
     * Created AWS EC2 Instance: Ec2Instance [instanceId=4, capacity=MICRO]
     * Allocated 36768 on S3 (2)
     * Attached S3Storage [id=2, capacityInMiB=36768] to EC2 instance: 4
     * Started AWS EC2 Instance (4).
     * Stopped AWS EC2 Instance (4).
     * Created Google Compute Engine (GCE) Instance: GoogleComputeEngineInstance [instanceId=4, capacity=LARGE]
     * Allocated 1000000007 on Google Cloud Storage (2)
     * Attached: GoogleCloudStorage [id=2, capacityInMib=1000000007] to compute engine instance: 4
     * Started GCE Instance (4)
     * Stopped GCE Instance (4)
	 */

}
