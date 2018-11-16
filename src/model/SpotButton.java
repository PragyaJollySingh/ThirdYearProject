package model;
import javax.swing.JButton;
import javax.swing.JToggleButton;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
public class SpotButton extends JButton 
{
	private static int count =0;
	private int spotButtonID = 0;

	
	public SpotButton() 
	{
		super();
		spotButtonID = count++;
	}

	public  int getSpotButtonID() 
	{
		return spotButtonID;
	}

	public void addZombie() 
	{
		ImageIcon zombieIcon = new ImageIcon("C:\\Users\\dennis\\eclipse-workspace\\PVZVIEW\\src\\zombie.png");
		Image zombieImage = zombieIcon.getImage();
	    Image newZombieImage = zombieImage.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
	    zombieIcon = new ImageIcon(newZombieImage);
	    setIcon(zombieIcon);
	}
	
	public void addSunflower() 
	{
		 ImageIcon sunflowerIcon = new ImageIcon("C:\\Users\\dennis\\eclipse-workspace\\PVZVIEW\\src\\sunflower.png");
		 Image sunflowerImage = sunflowerIcon.getImage();
		 Image newSunflowerImage = sunflowerImage.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		 sunflowerIcon = new ImageIcon(newSunflowerImage);
		 setIcon(sunflowerIcon);
	}
	
	public void addPeashooter() 
	{
		ImageIcon peaShooterIcon = new ImageIcon("C:\\Users\\dennis\\eclipse-workspace\\PVZVIEW\\src\\peashooter.png");
	    Image peaShooterImage = peaShooterIcon.getImage();
	    Image newPeaShooterImage = peaShooterImage.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
	    peaShooterIcon = new ImageIcon(newPeaShooterImage);
	    setIcon(peaShooterIcon);
	}
	
	
}
