package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;

import repository.*;
import entity.*;

public class FRegistration extends JFrame implements MouseListener,ActionListener
{
	 JLabel customerIdLabel,customerPasswordLabel, customerNameLabel, phoneLabel;
	 JTextField customerIdTF, customerNameTF, customerphoneTF;
	 JPasswordField passPF;

   private  JButton submitBtn, backBtn,showPassBtn;
	 Font  myFont;
	private JPanel panel;

	public FRegistration()
	{
		super("Register Now ");
		this.setSize(800,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);

		panel = new JPanel();
		panel.setLayout(null);

		customerIdLabel = new JLabel("ID :");
		customerIdLabel.setBounds(100,50,100,30);
		customerIdLabel.setFont(new Font("Consolas", Font.BOLD, 18));
		panel.add(customerIdLabel);

		customerIdTF = new JTextField();
		customerIdTF.setBounds(250,50,200,30);
		panel.add(customerIdTF);

		customerPasswordLabel = new JLabel("Password :");
		customerPasswordLabel.setFont(new Font("Consolas", Font.BOLD, 18));
		customerPasswordLabel.setBounds(100,100,100,30);
		panel.add(customerPasswordLabel);

		passPF = new JPasswordField();
		passPF.setBounds(250,100,200,30);
		panel.add(passPF);

		showPassBtn = new JButton("Show");
		showPassBtn.setBounds(470,100,80,30);
		showPassBtn.addMouseListener(this);
		panel.add(showPassBtn);

		customerNameLabel = new JLabel("Name :");
		customerNameLabel.setFont(new Font("Consolas", Font.BOLD, 18));
		customerNameLabel.setBounds(100,150,100,30);
		panel.add(customerNameLabel);

		customerNameTF = new JTextField();
		customerNameTF.setBounds(250,150,200,30);
		panel.add(customerNameTF);

		phoneLabel = new JLabel("Phone Number: ");
		phoneLabel.setFont(new Font("Consolas", Font.BOLD, 18));
		phoneLabel.setBounds(100,200,140,30);
		panel.add(phoneLabel);

		customerphoneTF = new JTextField();
		customerphoneTF.setBounds(250,200,200,30);
		panel.add(customerphoneTF);



		submitBtn = new JButton("Submit");
		submitBtn.setBounds(220, 310, 100, 50);
		submitBtn.addActionListener(this);
		panel.add(submitBtn);


		backBtn = new JButton("Back");
		backBtn.setBounds(350, 310, 100, 50);
		backBtn.addActionListener(this);
		panel.add(backBtn);


		this.add(panel);
	}
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();

		if(command.equals(submitBtn.getText()))
		{
            CustomerRepo cr = new CustomerRepo();
            UserRepo ur = new UserRepo();

			Customer c = new Customer();
			User u = new User();

			c.setCustomerId(customerIdTF.getText());
			c.setCustomerName(customerNameTF.getText());
			c.setPhone(customerphoneTF.getText());


			u.setUserId(customerIdTF.getText());
			u.setPassword(passPF.getText());
			u.setStatus(2);

            cr.insertInDatabase(c);
			ur.insertUser(u);


            customerIdTF.setText("");
			customerNameTF.setText("");
			customerphoneTF.setText("");

		}




		else if(command.equals(backBtn.getText()))
		{   LoginFrame lf = new LoginFrame();
			this.setVisible(false);
			lf.setVisible(true);
		}

		else
		    {
			JOptionPane.showMessageDialog(this, "Inserted, Id: "+customerIdTF.getText()+"and Password: "+passPF.getText());
		    }
	}

	public void mouseClicked(MouseEvent me){}
	public void mousePressed(MouseEvent me)
	{
		passPF.setEchoChar((char)0);
	}
	public void mouseReleased(MouseEvent me)
	{
		passPF.setEchoChar('*');
	}
	public void mouseEntered(MouseEvent me){}
	public void mouseExited(MouseEvent me){}
}
