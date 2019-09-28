package com.amazonaws.samples.lkxSend;

public class App 
{
    public static void main( String[] args )
    {
    	send sendThread = new send();
    	recv recvThead = new recv();
    	sendThread.start();
    	recvThead.start();
    }
}
