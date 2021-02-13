package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import repository.*;
import entity.*;


public class EmployeeFrame extends JFrame implements ActionListener
{
	private JLabel employeeIdLabel, employeeNameLabel, employeeDesignationLabel, employeeSalaryLabel;
	private JTextField employeeIdTF, employeeNameTF, employeeDesignationTF, employeeSalaryTF;
	private JButton loadBtn, insertBtn, updateBtn, deleteBtn, refreshBtn,backBtn;
	private JPanel panel;

	private User user;
	private EmployeeRepo er;
	private UserRepo ur;


	public EmployeeFrame(User user)
	{
		super("EmployeeFrame");
		this.setSize(800,450);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.user = user;

		er = new EmployeeRepo();
		ur = new UserRepo();

		panel = new JPanel();
		panel.setLayout(null);




		employeeIdLabel = new JLabel("ID :");
		employeeIdLabel.setBounds(100,100,100,30);
		panel.add(employeeIdLabel);

		employeeIdTF = new JTextField();
		employeeIdTF.setBounds(220,100,100,30);
		panel.add(employeeIdTF);

		employeeNameLabel = new JLabel("Name :");
		employeeNameLabel.setBounds(100,150,100,30);
		panel.add(employeeNameLabel);

		employeeNameTF = new JTextField();
		employeeNameTF.setBounds(220,150,100,30);
		panel.add(employeeNameTF);

		employeeDesignationLabel = new JLabel("Designation: ");
		employeeDesignationLabel.setBounds(100,200,100,30);
		panel.add(employeeDesignationLabel);

		employeeDesignationTF = new JTextField();
		employeeDesignationTF.setBounds(220,200,100,30);
		panel.add(employeeDesignationTF);

		employeeSalaryLabel = new JLabel("Salary: ");
		employeeSalaryLabel.setBounds(100,250,100,30);
		panel.add(employeeSalaryLabel);

		employeeSalaryTF = new JTextField();
		employeeSalaryTF.setBounds(220,250,100,30);
		panel.add(employeeSalaryTF);

		loadBtn = new JButton("Load");
		loadBtn.setBounds(100,300,80,30);
		loadBtn.addActionListener(this);
		panel.add(loadBtn);

		insertBtn = new JButton("Insert");
		insertBtn.setBounds(200,300,80,30);
		insertBtn.addActionListener(this);
		panel.add(insertBtn);

		updateBtn = new JButton("Update");
		updateBtn.setBounds(300,300,80,30);
		updateBtn.addActionListener(this);
		updateBtn.setEnabled(false);
		panel.add(updateBtn);

		deleteBtn = new JButton("Delete");
		deleteBtn.setBounds(400,300,80,30);
		deleteBtn.addActionListener(this);
		deleteBtn.setEnabled(false);
		panel.add(deleteBtn);

		refreshBtn = new JButton("Refresh");
		refreshBtn.setBounds(500,300,80,30);
		refreshBtn.addActionListener(this);
		refreshBtn.setEnabled(false);
		panel.add(refreshBtn);

		backBtn = new JButton("Back");
		backBtn.setBounds(600, 350, 80, 30);
		backBtn.addActionListener(this);
		panel.add(backBtn);

		this.add(panel);
	}
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();

		if(command.equals(loadBtn.getText()))
		{
			if(!employeeIdTF.getText().equals("") || !employeeIdTF.getText().equals(null))
			{
				Employee e = er.searchEmployee(employeeIdTF.getText());
				if(e!= null)
				{
					employeeNameTF.setText(e.getEmployeeName());
					employeeDesignationTF.setText(e.getDesignation());
					employeeSalaryTF.setText(e.getSalary()+"");

					employeeIdTF.setEnabled(false);
					employeeNameTF.setEnabled(true);
					employeeDesignationTF.setEnabled(true);
					employeeSalaryTF.setEnabled(true);

					updateBtn.setEnabled(true);
					deleteBtn.setEnabled(true);
					refreshBtn.setEnabled(true);
					insertBtn.setEnabled(false);
					loadBtn.setEnabled(false);
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Invaild ID");
				}
			}
		}
		else if(command.equals(insertBtn.getText()))
		{
			Employee e = new Employee();
			User u = new User();
			Random rd = new Random();
			int x = rd.nextInt(9999999)+10000000;

			e.setEmployeeId(employeeIdTF.getText());
			e.setEmployeeName(employeeNameTF.getText());
			e.setDesignation(employeeDesignationTF.getText());
			e.setSalary(Double.parseDouble(employeeSalaryTF.getText()));

			u.setUserId(employeeIdTF.getText());
			u.setPassword(x+"");


			if(((employeeDesignationTF.getText()).equals("Manager")) || ((employeeDesignationTF.getText()).equals("manager")))
			{
				u.setStatus(0);
			}
			else
			{
				u.setStatus(1);
			}

			er.insertInDatabase(e);
			ur.insertUser(u);

			JOptionPane.showMessageDialog(this, "Inserted, Id: "+employeeIdTF.getText()+"and Password: "+x);

			employeeIdTF.setText("");
			employeeNameTF.setText("");
			employeeDesignationTF.setText("");
			employeeSalaryTF.setText("");

			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);

		}
		else if(command.equals(refreshBtn.getText()))
		{
			employeeIdTF.setText("");
			employeeNameTF.setText("");
			employeeDesignationTF.setText("");
			employeeSalaryTF.setText("");

			employeeIdTF.setEnabled(true);
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
		}
		else if(command.equals(updateBtn.getText()))
		{
			Employee e = new Employee();

			e.setEmployeeId(employeeIdTF.getText());
			e.setEmployeeName(employeeNameTF.getText());
			e.setDesignation(employeeDesignationTF.getText());
			e.setSalary(Double.parseDouble(employeeSalaryTF.getText()));

			er.updateInDatabase(e);

			JOptionPane.showMessageDialog(this, "Updated");

			employeeIdTF.setText("");
			employeeNameTF.setText("");
			employeeDesignationTF.setText("");
			employeeSalaryTF.setText("");

			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);

			employeeIdTF.setEnabled(true);
			employeeNameTF.setEnabled(true);
			employeeDesignationTF.setEnabled(true);
			employeeSalaryTF.setEnabled(true);
		}
		else if(command.equals(deleteBtn.getText()))
		{
			er.deleteFromDatabase(employeeIdTF.getText());
			ur.deleteUser(employeeIdTF.getText());

			JOptionPane.showMessageDialog(this,"Deleted");

			employeeIdTF.setText("");
			employeeNameTF.setText("");
			employeeDesignationTF.setText("");
			employeeSalaryTF.setText("");

			employeeIdTF.setEnabled(true);
			employeeNameTF.setEnabled(true);
			employeeDesignationTF.setEnabled(true);
			employeeSalaryTF.setEnabled(true);

			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
		}

		else if(command.equals(backBtn.getText()))
		{
			EmployeeHome eh = new EmployeeHome(user);
			eh.setVisible(true);
			this.setVisible(false);
		}
		else{}

	}
}
