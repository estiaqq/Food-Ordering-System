package entity;
import java.lang.*;

public class Customer
{
	private String customerId;
	private String customerName;
	private String phone;

	public Customer(){}
	public Customer(String customerId,String customerName,String phone)
	{
		this.customerId = customerId;
		this.customerName = customerName;
		this.phone = phone;
	}

	public void setCustomerId(String customerId){this.customerId = customerId;}
	public void setCustomerName(String customerName){this.customerName = customerName;}
	public void setPhone(String Phone){this.phone = phone;}

	public String getCustomerId(){return customerId;}
	public String getCustomerName(){return customerName;}
	public String getPhone(){return phone;}
}
