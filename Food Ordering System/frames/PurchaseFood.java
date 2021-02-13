
package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


import repository.*;
import entity.*;
import interfaces.*;

public class PurchaseFood extends JFrame implements ActionListener
{
	private JLabel pId,pName, pQuantity,pPrice,totalAmount,available;
	private JTextField pIdTf,pNameTf,pQuantityTf,pPriceTf,availableTf,totalAmountTf;
	private JPanel panel;
	private JButton confirmBtn,backBtn,pIdBtn;

	private ProductRepo pr;
	private CustomerRepo cr;

	private ProductRepo productRepo;
	private User user;

	public PurchaseFood()
	{
		super("Purchase FOOD");
		this.setSize(800,550);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel();


		pr = new ProductRepo();
		cr = new CustomerRepo();

		pId = new JLabel("Product Id");
		pId.setBounds(200,130,100,30);
		panel.add(pId);

		pName = new JLabel("Product Name");
		pName.setBounds(200,165,100,30);
		panel.add(pName);

		pPrice= new JLabel("Price per unit");
		pPrice.setBounds(200,200,100,30);
		panel.add(pPrice);

        available= new JLabel("Available Quantity");
		available.setBounds(200,235,100,30);
		panel.add(available);

		pQuantity= new JLabel("Purchase Quantity");
		pQuantity.setBounds(200,270,100,30);
		panel.add(pQuantity);

		totalAmount= new JLabel("Total Amount");
		totalAmount.setBounds(200,305,100,30);
		panel.add(totalAmount);

		pIdTf = new JTextField();
		pIdTf.setBounds(330, 130, 160,50);
		panel.add(pIdTf);

		pIdBtn = new JButton("...");
		pIdBtn.setBounds(560,130,50,20);
		pIdBtn.addActionListener(this);
		panel.add(pIdBtn);

		pNameTf = new JTextField();
		pNameTf.setBounds(330, 165, 160,30);
		panel.add(pNameTf);
		pNameTf.setEditable(false);

		availableTf = new JTextField();
		availableTf.setBounds(330, 235, 160,30);
		panel.add(availableTf);
		availableTf.setEditable(false);

		pQuantityTf = new JTextField();
		pQuantityTf.setBounds(330, 270, 160,30);
		panel.add(pQuantityTf);

		pPriceTf = new JTextField();
		pPriceTf.setBounds(330, 200, 160,30);
		panel.add(pPriceTf);
		pPriceTf.setEditable(false);

		totalAmountTf = new JTextField();
		totalAmountTf.setBounds(330, 305, 160,30);
		panel.add(totalAmountTf);

		confirmBtn = new JButton("Confirm");
		confirmBtn.setBounds(200,340,80,30);
		confirmBtn.addActionListener(this);
		panel.add(confirmBtn);

		backBtn = new JButton("	Back");
		backBtn.setBounds(280,340,80,30);
		backBtn.addActionListener(this);
		panel.add(backBtn);

		this.add(panel);
	}

	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();

		Product p;

        if(command.equals(pIdBtn.getText()))
		{
			if(!pIdTf.getText().equals(""))
			{
                p= pr.searchProduct(pIdTf.getText());
				if(p == null)
				{
					JOptionPane.showMessageDialog(this, "Please provide valid product id.");
				}
				else
				{
					pNameTf.setText(p.getName());
					pPriceTf.setText(Double.toString(p.getPrice()));
					availableTf.setText(Integer.toString(p.getQuantity()));

				}
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Please provide product id");
			}
		}

		else if(command.equals(confirmBtn.getText()))
		{
			if(!totalAmountTf.getText().equals("") && !pIdTf.getText().equals("") && !pQuantityTf.getText().equals(""))
			{
				try
				{
					double price;
					int quantity;
					try
					{
						price = Double.valueOf(pPriceTf.getText()).doubleValue();
						quantity = Integer.valueOf(pQuantityTf.getText()).intValue();

						totalAmountTf.setText(String.valueOf(price*quantity));
					}
					catch (Exception e)
					{
						JOptionPane.showMessageDialog(this,e.getMessage());
					}


				/*	p.setQuantity(Integer.parseInt(pQuantityTf.getText()));
					//pr.setAmount(Double.parseDouble(totalAmountTf.getText()));
					Product pd = p.searchProduct(p.getPId());

					int inventoryQuantity = pd.getQuantity() - p.getQuantity();

					if(p.getQuantity()<=0){
						JOptionPane.showMessageDialog(this,"Purchase quantity must not be zero or negative.");

					}
					else if(p.getQuantity()>0)
					{

						p.updateInDB(pd);
						JOptionPane.showMessageDialog(this, "Purchase successful.");


					}

                else
					{
						JOptionPane.showMessageDialog(this,"Insufficient inventory!!!");
					}
                */

				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(this,e.getMessage());
				}
			}
			else
				{
					//JOptionPane.showMessageDialog(this,"Invalid Purchase");
				}
		}

		else if(command.equals(backBtn.getText()))
		{
			CustomerHome ch = new CustomerHome(user);
			ch.setVisible(true);
			this.setVisible(false);
		}
	}

}
