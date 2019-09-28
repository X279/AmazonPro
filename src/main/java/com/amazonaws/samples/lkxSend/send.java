package com.amazonaws.samples.lkxSend;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class send extends Thread {
	JFrame frame = new JFrame("SendMessage");
	JLabel messLabel = new JLabel("Message:");
	JLabel noJLabel = new JLabel(" ");
	JTextField text = new JTextField(20);
	JButton submit = new JButton("submit");
	JButton clear = new JButton("clear");
	JButton exitButton = new JButton("exit");
	GridBagLayout gridBagLayout = new GridBagLayout();//布局管理器
	GridBagConstraints constraints = null;//添加约束
	queueSend queue = null;
	
	public void run()
	{
		frame.setSize(500,250);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setLayout(gridBagLayout);
		palceComponents();
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	private void palceComponents() {
		// TODO Auto-generated method stub
		constraints = new GridBagConstraints();
		
		constraints.gridwidth = 3;
		constraints.weightx = 0;
		constraints.weighty = 0;
		gridBagLayout.addLayoutComponent(messLabel, constraints);
		frame.add(messLabel);
		constraints.gridwidth = 2;
		constraints.weightx = 0;
		constraints.weighty = 0;
		constraints.insets = new Insets(0, 1, 0, 0);
		gridBagLayout.addLayoutComponent(text, constraints);
		frame.add(text);
		
		constraints.gridwidth = 0;
		constraints.weightx = 0;
		constraints.weighty = 0;
		constraints.insets = new Insets(0, 10, 0, 0);
		gridBagLayout.addLayoutComponent(noJLabel, constraints);
		frame.add(noJLabel);
		
		constraints.gridwidth = 3;
		constraints.weightx = 0;
		constraints.weighty = 0;
		gridBagLayout.addLayoutComponent(submit, constraints);
		submit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//发送消息
				System.out.println("按下了发送键");
				String message = text.getText();
				System.out.println("message: "+message);
				queue = new queueSend();
				queue.setUrl();
				queue.sendMessage(message);
				text.setText("");
			}
		});
		frame.add(submit);

		constraints.gridwidth = 2;
		constraints.weightx = 0;
		constraints.weighty = 0;
		gridBagLayout.addLayoutComponent(clear, constraints);
		clear.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				text.setText("");
			}
		});
		frame.add(clear);
		
		constraints.gridwidth = 0;
		constraints.weightx = 0;
		constraints.weighty = 0;
		constraints.insets = new Insets(0, 10, 0, 0);
		gridBagLayout.addLayoutComponent(exitButton, constraints);
		exitButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		frame.add(exitButton);
	}
}
