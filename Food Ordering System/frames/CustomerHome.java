package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import repository.*;
import entity.*;


public class CustomerHome extends JFrame implements ActionListener
{
	JButton FoodBtn,logoutBtn,changeInformationdBtn,PurchaseBtn;
	JPanel panel;

	User user;

	public CustomerHome(User user)
	{
		super("Welcome Customer!");
		this.setSize(800,750);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.user = user;
		panel = new JPanel();
		panel.setLayout(null);

		FoodBtn = new JButton("Food");
		FoodBtn.setBounds(225, 430, 150, 60);
		FoodBtn.addActionListener(this);
		panel.add(FoodBtn);

		PurchaseBtn = new JButton("Purchase Food");
		PurchaseBtn.setBounds(300, 350, 150, 30);
		PurchaseBtn.addActionListener(this);
		panel.add(PurchaseBtn);

		changeInformationdBtn = new JButton("Change Password");
		changeInformationdBtn.setBounds(270, 510, 260, 50);
		changeInformationdBtn.addActionListener(this);
		panel.add(changeInformationdBtn);

		logoutBtn = new JButton("Logout");
		logoutBtn.setBounds(395, 430, 150, 60);
		logoutBtn.addActionListener(this);
		panel.add(logoutBtn);

		this.add(panel);

	}

	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();

		if(command.equals(logoutBtn.getText()))
		{
			LoginFrame lf = new LoginFrame();
			lf.setVisible(true);
			this.setVisible(false);
		}

		else if(command.equals(FoodBtn.getText()))
		{
			AllProductFrame ap = new AllProductFrame();
			ap.setVisible(true);
			this.setVisible(false);
		}
		else if(command.equals(changeInformationdBtn.getText()))
		{
			ChangePasswordForCustomer cp = new ChangePasswordForCustomer(user);
			cp.setVisible(true);
			this.setVisible(false);

		}
		else if(command.equals(PurchaseBtn.getText()))
		{
			PurchaseFood pd = new PurchaseFood();
			pd.setVisible(true);
			this.setVisible(false);
		}

		else{}
	}
}
