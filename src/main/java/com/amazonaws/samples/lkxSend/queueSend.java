package com.amazonaws.samples.lkxSend;

import com.amazonaws.services.sqs.model.AmazonSQSException;
import com.amazonaws.services.sqs.model.SendMessageRequest;

public class queueSend implements SQS{

	String QueueUrl = null;
	
	public void setUrl() {
		try {
		    QueueUrl = SQS.sqs.getQueueUrl(SQS.QueueName).getQueueUrl();
		    System.out.println("设置了队列的URL");
		} catch (AmazonSQSException e) {
		    if (!e.getErrorCode().equals("QueueAlreadyExists")) {
		        throw e;
		    }
		}
	}
	
	public void sendMessage(String message)
	{
		System.out.println("开始发送消息");
		SendMessageRequest send_msg_request = new SendMessageRequest()
	            .withQueueUrl(QueueUrl)
	            .withMessageBody(message)
	            .withDelaySeconds(5);
	    sqs.sendMessage(send_msg_request);
	    System.out.println("发送消息成功");
	}
}

