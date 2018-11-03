

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class Controller{
	public BLayout layout;
	public ButtonLayout button;
	public JButton currentButton;
	
	
	public Controller (BLayout b) {
		layout= new BLayout();
		currentButton= new JButton();
	
	}
	public void initialize() {
		layout.getA1().addActionListener(e->push());
		layout.getA2().addActionListener(e->push());
		layout.getA3().addActionListener(e->push());
		layout.getA4().addActionListener(e->push());
		layout.getA5().addActionListener(e->push());
		layout.getA6().addActionListener(e->push());
		layout.getB1().addActionListener(e->push());
		layout.getB2().addActionListener(e->push());
		layout.getB3().addActionListener(e->push());
		layout.getB4().addActionListener(e->push());
		layout.getB5().addActionListener(e->push());
		layout.getB6().addActionListener(e->push());
		layout.getC1().addActionListener(e->push());
		layout.getC2().addActionListener(e->push());
		layout.getC3().addActionListener(e->push());
		layout.getC4().addActionListener(e->push());
		layout.getC5().addActionListener(e->push());
		layout.getC6().addActionListener(e->push());
		layout.getD1().addActionListener(e->push());
		layout.getD2().addActionListener(e->push());
		layout.getD3().addActionListener(e->push());
		layout.getD4().addActionListener(e->push());
		layout.getD5().addActionListener(e->push());
		layout.getD6().addActionListener(e->push());
		layout.getNewFrame().getEnter().addActionListener(e->enterPressed());
	}
	
	public void push() {
		button= new ButtonLayout();
		
	}
	public void enterPressed() {
		String icon= button.getOptionsList().getSelectedItem().toString();
		this.setCurrentButton(layout.getCorrectButton(layout.getCounter()));
		currentButton.setText(icon);
		layout.getNewFrame().getEnter().repaint();
		layout.getNewFrame().getEnter().revalidate();
		
		
	}
	public void setCurrentButton(JButton button) {
		currentButton= button;
		
	}
		
	}
	
