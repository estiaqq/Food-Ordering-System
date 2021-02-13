package repository;

import java.lang.*;
import entity.*;
import interfaces.*;

public class EmployeeRepo implements IEmployee
{
	DatabaseConnection dbc;

	public EmployeeRepo()
	{
		dbc = new DatabaseConnection();
	}

	public void insertInDatabase(Employee e)
	{
		String query = "Insert into employee Values ('"+e.getEmployeeId()+"','"+e.getEmployeeName()+"','"+e.getDesignation()+"',"+e.getSalary()+");";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	public void deleteFromDatabase(String employeeId)
	{
		String query = "Delete from employee where employeeId='"+employeeId+"';";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception e){System.out.println(e.getMessage());}
	}
	public void updateInDatabase(Employee e)
	{
		String query = "Update employee set employeeName='"+e.getEmployeeName()+"', designation = '"+e.getDesignation()+"', salary = '"+e.getSalary()+"' WHERE employeeId='"+e.getEmployeeId()+"'";

		try
		{
			dbc.openConnection();
			dbc.st.executeUpdate(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	public Employee searchEmployee(String employeeId)
	{
		Employee employee = null;
		String query = "Select `employeeName`, `designation`, `salary` FROM `employee` WHERE `employeeId`='"+employeeId+"';";
		try
		{
			System.out.println(query);
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);

			while(dbc.result.next())
			{

				String employeeName = dbc.result.getString("employeeName");
				String designation = dbc.result.getString("designation");
				double salary = dbc.result.getDouble("salary");

				employee = new Employee();
				employee.setEmployeeId(employeeId);
				employee.setEmployeeName(employeeName);
				employee.setDesignation(designation);
				employee.setSalary(salary);
			}

		}
		catch(Exception ex){System.out.println(ex.getMessage());}
		dbc.closeConnection();
		return employee;
	}

}




