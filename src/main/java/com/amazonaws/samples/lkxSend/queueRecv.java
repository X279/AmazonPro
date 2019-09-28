package com.amazonaws.samples.lkxSend;

import java.util.List;

import com.amazonaws.services.sqs.model.Message;

public class queueRecv implements SQS{
    String QueueUrl = null;
    
    public void setUrl()
    {
    	QueueUrl = sqs.getQueueUrl(QueueName).getQueueUrl();
    	System.out.println("设置了队列的URL");
    }
    public String RecvFromSQS() {
    	System.out.println("准备接收消息");
    	List<Message> messages = sqs.receiveMessage(QueueUrl).getMessages();
    	System.out.println("接收消息成功");
    	String message = null;
    	for(Message mess : messages)
    	{
    		message = mess.getBody();
    		System.out.println("得到消息主体");
    		sqs.deleteMessage(QueueUrl, mess.getReceiptHandle());
    		System.out.println("删除消息成功");
    	}
    	return message;
	}
}
