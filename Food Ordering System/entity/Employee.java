package entity;

import java.lang.*;

public class Employee
{
	private String employeeId;
	private String employeeName;
	private String designation;
	private double salary;
  
	
	
	public Employee(){}
	public Employee(String employeeId, String employeeName, String designation, double salary)
	{
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.designation = designation;
		this.salary = salary;
		
	}
	
	public void setEmployeeId(String employeeId)
	{
		this.employeeId = employeeId;
	}
	public void setEmployeeName(String employeeName)
	{
		this.employeeName = employeeName;
	}
	public void setDesignation(String designation)
	{
		this.designation = designation;
	}
	public void setSalary(double salary)
	{
		this.salary = salary;
	}

	
	
	
	public String getEmployeeId()
	{
		return employeeId;
	}
	public String getEmployeeName()
	{
		return employeeName;
	}
	public String getDesignation()
	{
		return designation;
	}
	public double getSalary()
	{
		return salary;
	}
	
}