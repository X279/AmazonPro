package com.amazonaws.samples.lkxSend;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;

public interface SQS {
	static AmazonSQS sqs = AmazonSQSClientBuilder.standard().withRegion(Regions.US_EAST_1).build();
	static String QueueName = "myQueue";
	public void setUrl();
}
