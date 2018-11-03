import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.*;
public class BLayout {
	public ButtonLayout newFrame;
		public JFrame main;
		public JLabel A;
		public JLabel B;
		public JLabel C;
		public JLabel D;
		public JLabel one;
		public JLabel two;
		public JLabel three;
		public JLabel four;
		public JLabel five;
		public JLabel six;
		public JButton A1;
		public JButton A2;
		public JButton A3;
		public JButton A4;
		public JButton A5;
		public JButton A6;
		public JButton B1;
		public JButton B2;
		public JButton B3;
		public JButton B4;
		public JButton B5;
		public JButton B6;
		public JButton C1;
		public JButton C2;
		public JButton C3;
		public JButton C4;
		public JButton C5;
		public JButton C6;
		public JButton D1;
		public JButton D2;
		public JButton D3;
		public JButton D4;
		public JButton D5;
		public JButton D6;
		public JLabel empty;
		public JLabel Sunflower;
		public JLabel costSunflower;
		public JLabel peaShooters;
		public JLabel costpeaShooter;
		public JLabel currentSun;
		public JTextField currentUpdate;
		public JLabel r1;
		public JLabel r12;
		public JLabel r13;
		public JLabel r14;
		public JLabel r21;
		public JLabel r22;
		public JLabel r23;
		public JLabel r24; 
		public JLabel r31;
		public JLabel r32;
		public int counter;
		
	
	public BLayout() {
		newFrame= new ButtonLayout();
		main= new JFrame("Plants vs Zombies");
		main.setSize(900, 600);
		main.setLayout(new GridLayout(0,7));
		one= new JLabel("              1");
		two= new JLabel("              2");
		three= new JLabel("            3");
		four=new JLabel("              4");
		five= new JLabel("             5");
		six= new JLabel("              6");
		A= new JLabel("                A");
		B= new JLabel("                B");
		C= new JLabel("                C");
		D= new JLabel("                D");
		A1= new JButton();
		A2= new JButton();
		A3=new JButton();
		A4= new JButton();
		A5= new JButton();
		A6= new JButton();
		B1= new JButton();
		B2= new JButton();
		B3= new JButton();
		B4= new JButton();
		B5= new JButton();
		B6= new JButton();
		C1= new JButton();
		C2= new JButton();
		C3= new JButton();
		C4= new JButton();
		C5= new JButton();
		C6= new JButton();
		D1= new JButton();
		D2= new JButton();
		D3= new JButton();
		D4= new JButton();
		D5= new JButton();
		D6= new JButton();
		r1= new JLabel();
		r12=new JLabel();
		r13=new JLabel();
		r14=new JLabel();
		r21=new JLabel();
		r22=new JLabel();
		r23=new JLabel();
		r24=new JLabel();
		r31=new JLabel();
		r32=new JLabel();
		
		empty= new JLabel();
		Sunflower= new JLabel("Sunflowers");
		costSunflower= new JLabel("Cost = 25");;
		peaShooters=new JLabel("PeaShooters");
		costpeaShooter= new JLabel("Cost= 50");
		currentSun= new JLabel("Current Sun amount");
		currentUpdate= new JTextField();
		currentUpdate.setEditable(false);
		main.add(empty);
		main.add(one);
		main.add(two);
		main.add(three);
		main.add(four);
		main.add(five);
		main.add(six);
		main.add(A);
		main.add(A1);
		main.add(A2);
		main.add(A3);
		main.add(A4);
		main.add(A5);
		main.add(A6);
	main.add(B);
	main.add(B1);
	main.add(B2);
	main.add(B3);
	main.add(B3);
	main.add(B4);
	main.add(B5);
	main.add(B6);
	main.add(C);
	main.add(C1);
	main.add(C2);
	main.add(C3);
	main.add(C4);
	main.add(C5);
	main.add(C6);
	main.add(D);
	main.add(D1);
	main.add(D2);
	main.add(D3);
	main.add(D4);
	main.add(D5);
	main.add(D6);
	main.add(r1);
	main.add(Sunflower);
	main.add(r12);
	main.add(peaShooters);
	main.add(r13);
	main.add(currentSun);
	main.add(r14);
	main.add(r21);
	main.add(costSunflower);
	main.add(r22);
	main.add(costpeaShooter);
	main.add(r23);
	main.add(currentUpdate);
	main.add(r24);
	main.add(r31);
	main.add(r32);
	main.setLocationRelativeTo(null);
	main.setVisible(true);
	} 
	public ButtonLayout getNewFrame() {
		return newFrame;
	}
	public void setNewFrame(ButtonLayout newFrame) {
		this.newFrame = newFrame;
	}
	public JButton getC4() {
		counter=34;
		return C4;
	}
	public void setC4(JButton c4) {
		C4 = c4;
	}
	public JButton getC5() {
		counter=35;
		return C5;
	}
	public void setC5(JButton c5) {
		C5 = c5;
	}
	public JButton getC6() {
		counter=36;
		return C6;
	}
	public void setC6(JButton c6) {
		C6 = c6;
	}
	public JButton getD1() {
		counter=41;
		return D1;
	}
	public void setD1(JButton d1) {
		D1 = d1;
	}
	public JButton getD2() {
		counter=42;
		return D2;
	}
	public void setD2(JButton d2) {
		D2 = d2;
	}
	public JButton getD3() {
		counter=43;
		return D3;
	}
	public void setD3(JButton d3) {
		D3 = d3;
	}
	public JButton getD4() {
		counter=44;
		return D4;
	}
	public void setD4(JButton d4) {
		counter=44;
		D4 = d4;
	}
	public JButton getD5() {
		counter=45;
		return D5;
	}
	public void setD5(JButton d5) {
		counter=45;
		D5 = d5;
	}
	public JButton getD6() {
		counter=46;
		return D6;
	}
	public void setD6(JButton d6) {
		D6 = d6;
	}
	public JButton getA1() {
		counter=11;
		return A1;
	}
	public void setA1(JButton a1) {
		A1 = a1;
	}
	public JButton getA2() {
		counter=12;
		return A2;
	}
	public void setA2(JButton a2) {
		A2 = a2;
	}
	public JButton getA3() {
		counter=13;
		return A3;
	}
	public void setA3(JButton a3) {
		A3 = a3;
	}
	public JButton getA4() {
		counter=14;
		return A4;
	}
	public void setA4(JButton a4) {
		A4 = a4;
	}
	public JButton getA5() {
		counter=15;
		return A5;
	}
	public void setA5(JButton a5) {
		A5 = a5;
	}
	public JButton getA6() {
		counter=16;
		return A6;
	}
	public void setA6(JButton a6) {
		A6 = a6;
	}
	public JButton getB1() {
		counter=21;
		return B1;
	}
	public void setB1(JButton b1) {
		B1 = b1;
	}
	public JButton getB2() {
		counter=22;
		return B2;
	}
	public void setB2(JButton b2) {
		B2 = b2;
	}
	public JButton getB3() {
		counter=23;
		return B3;
	}
	public void setB3(JButton b3) {
		B3 = b3;
	}
	public JButton getB4() {
		counter=24;
		return B4;
	}
	public void setB4(JButton b4) {
		B4 = b4;
	}
	public JButton getB5() {
		counter=25;
		return B5;
	}
	public void setB5(JButton b5) {
		B5 = b5;
	}
	public JButton getB6() {
		counter=26;
		return B6;
	}
	public void setB6(JButton b6) {
		B6 = b6;
	}
	public JButton getC1() {
		counter=31;
		return C1;
	}
	public void setC1(JButton c1) {
		C1 = c1;
	}
	public JButton getC2() {
		counter=32;
		return C2;
	}
	public void setC2(JButton c2) {
		C2 = c2;
	}
	public JButton getC3() {
		counter=33;
		return C3;
	}
	public JTextField getCurrentUpdate() {
		return currentUpdate;
	}
	public void setCurrentUpdate(JTextField currentUpdate) {
		this.currentUpdate = currentUpdate;
	}
	public void setC3(JButton c3) {
		C3 = c3;
	}
	public int getCounter() {
		return counter;
	}
	public JButton getCorrectButton(int counter) {
	if(counter/10==1) {
			if(counter%10==1) {
				return A1;
			}
			else if(counter%10==2) {
				return A2; 
			}
			else if (counter%10==3) {
				return A3;
			}
			else if(counter%10==4) {
				return A4;
			}
			else if(counter%10==5) {
				return A5;
			}
			else if(counter%10==6) {
				return A6;
			}
		}
		if(counter/10==2) {
			if(counter%10==1) {
				return B1;
			}
			else if(counter%10==2) {
				return B2; 
			}
			else if (counter%10==3) {
				return B3;
			}
			else if(counter%10==4) {
				return B4;
			}
			else if(counter%10==5) {
				return B5;
			}
			else if(counter%10==6) {
				return B6;
			}
		}
		if(counter/10==3) {
			if(counter%10==1) {
				return C1;
			}
			else if(counter%10==2) {
				return C2; 
			}
			else if (counter%10==3) {
				return C3;
			}
			else if(counter%10==4) {
				return C4;
			}
			else if(counter%10==5) {
				return C5;
			}
			else if(counter%10==6) {
				return C6;
			}
		}
		if(counter/10==4) {
			if(counter%10==1) {
				return C1;
			}
			else if(counter%10==2) {
				return C2; 
			}
			else if (counter%10==3) {
				return C3;
			}
			else if(counter%10==4) {
				return C4;
			}
			else if(counter%10==5) {
				return C5;
			}
			else if(counter%10==6) {
				return C6;
			}
		}
		if(counter/10==5) {
			if(counter%10==1) {
				return D1;
			}
			else if(counter%10==2) {
				return D2; 
			}
			else if (counter%10==3) {
				return D3;
			}
			else if(counter%10==4) {
				return D4;
			}
			else if(counter%10==5) {
				return D5;
			}
		}
		return D6;
		
		
	}
	
}
