import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;


import javax.swing.*;

public class ButtonLayout {
	public JFrame frame;
	public JLabel Options;
	public String[] icons= {" Sunflowers", "PeaShooters"};
	public JComboBox optionsList;
	public JLabel Current;
	public JTextField currAmount;
	public JButton enter;
	public JLabel blank;
	public JLabel message;
	public Controller c;
	
	public ButtonLayout() {
		frame=new JFrame("Options List");
		frame.setLayout(new GridLayout(0,2));
		frame.setSize(500, 150);
		Options= new JLabel(" Options");
		optionsList= new JComboBox<String>(icons);
		Current= new JLabel(" Sun Amount");
		currAmount= new JTextField();
		currAmount.setEditable(false);
		enter= new JButton("Enter");
		blank= new JLabel();
		message= new JLabel("                         INSUFFICANT FUNDS");
		message.setForeground(Color.RED);
		frame.add(Options);
		frame.add(optionsList);
		frame.add(Current);
		frame.add(currAmount);
		frame.add(blank);
		frame.add(enter);
		frame.add(message);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}
	
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JComboBox getOptionsList() {
		return optionsList;
	}

	public JButton getEnter() {
		return enter;
	}

	public void setEnter(JButton enter) {
		this.enter = enter;
	}

	public void setOptionsList(JComboBox optionsList) {
		this.optionsList = optionsList;
	}

	public JTextField getCurrAmount() {
		return currAmount;
	}

	public void setCurrAmount(JTextField currAmount) {
		this.currAmount = currAmount;
	}

	public JLabel getMessage() {
		return message;
	}

	public void setMessage(JLabel message) {
		this.message = message;
	}
	
	

	
	
	
	
}
