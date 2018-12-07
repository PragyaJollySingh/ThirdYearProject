package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import controller.Controller;
import model.SpotButton;

public class WaveInfoPanel extends JFrame {
	
	private JLabel explanation;
	private JPanel normal;
	private JPanel explosive;
	private JPanel bucket;
	private JLabel normalZombies;
	private JLabel explosiveZombies;
	private JLabel bucketZombies;
	private JTextArea nzAmount;
	private JTextArea ezAmount;
	private JTextArea bzAmount;
	private JButton submit;
	private Controller controller;
	
	
	public WaveInfoPanel() {
		initialize();
	}
	
	public void initialize() {
		explanation = new JLabel("Enter the number of zombies for this level");
		
		normal = new JPanel(new GridLayout(1, 2));
		normalZombies = new JLabel("Normal Zombies");
		nzAmount = new JTextArea("0");
		normal.add(normalZombies);
		normal.add(nzAmount);
		
		explosive = new JPanel(new GridLayout(1, 2));
		explosiveZombies = new JLabel("Explosive Zombies");
		ezAmount = new JTextArea("0");
		explosive.add(explosiveZombies);
		explosive.add(ezAmount);
		
		bucket = new JPanel(new GridLayout(1, 2));
		bucketZombies = new JLabel("Bucket Zombies");
		bzAmount = new JTextArea("0");
		bucket.add(bucketZombies);
		bucket.add(bzAmount);
		
		submit = new JButton("Submit");
		
		controller = new Controller();
		
		setLayout(new GridLayout(0, 1));
		
		add(explanation);
		add(normal);
		add(bucket);
		add(explosive);
		add(submit);
		
	
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 300);
		
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkValidity()) {
					new MainFrame(getNzAmount(), getBzAmount(), getEzAmount());
				}
			}
		});
	}
	
	public void reset() {
		explanation = null;
		normal = null;
		explosive = null;
		bucket = null;
		normalZombies = null;
		explosiveZombies = null;
		bucketZombies = null;
		nzAmount = null;
		ezAmount = null;
		bzAmount = null;
		submit = null;
		controller = null;
	}

	public boolean checkValidity() {
		if(getNzAmount() + getEzAmount() + getBzAmount() > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public int getNzAmount() {
		return Integer.parseInt(nzAmount.getText());
	}

	public void setNzAmount(JTextArea nzAmount) {
		this.nzAmount = nzAmount;
	}

	public int getEzAmount() {
		return Integer.parseInt(ezAmount.getText());
	}

	public void setEzAmount(JTextArea ezAmount) {
		this.ezAmount = ezAmount;
	}

	public int getBzAmount() {
		return Integer.parseInt(bzAmount.getText());
	}

	public void setBzAmount(JTextArea bzAmount) {
		this.bzAmount = bzAmount;
	}
}
