package com.amazonaws.samples.lkxSend;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class recv extends Thread {

	JFrame frame = new JFrame("RecieveMessage");
	GridBagLayout gridBagLayout = new GridBagLayout();//布局管理器
	GridBagConstraints constraints = null;//添加约束
	JButton recvButton = new JButton("recieve");
	JButton exitButton = new JButton("exit");
	JTextArea messArea = new JTextArea("Recieved Message: \n",10,10); //显示订阅信息
	JScrollPane scrollPane = new JScrollPane(messArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	queueRecv queueRecv = null;
	String message = null;

	private void palceComponents() {
		// TODO Auto-generated method stub
		constraints = new GridBagConstraints();
		
		constraints.gridwidth = 2;
		constraints.weightx = 1;
		constraints.weighty = 1;
		gridBagLayout.addLayoutComponent(recvButton, constraints);
		recvButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("按下接收键");
				queueRecv = new queueRecv();
				queueRecv.setUrl();
				message = queueRecv.RecvFromSQS();
				messArea.append("Message: ");
				messArea.append(message+"\n");
			}
		});

		frame.add(recvButton);
		constraints.gridwidth = 0;
		constraints.weightx = 1;
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
		
		constraints.gridwidth = 0;
		constraints.weightx = 0;
		constraints.weighty = 1;
		constraints.fill = GridBagConstraints.BOTH;
		
		messArea.setEditable(false);//设置为不可编辑
		messArea.setLineWrap(true); //设置自动换行
		messArea.setWrapStyleWord(true);
		gridBagLayout.addLayoutComponent(scrollPane, constraints);
		frame.add(scrollPane);
	}
	public void run()
	{
		frame.setSize(600,450);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setLayout(gridBagLayout);
		palceComponents();
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
