package repository;

import java.lang.*;
import entity.*;
import interfaces.*;

public class CustomerRepo implements ICustomer
{
	DatabaseConnection dbc;

	public CustomerRepo()
	{
		dbc = new DatabaseConnection();
	}
	public void insertInDatabase(Customer c)
	{
		String query = "Insert into customer Values ('"+c.getCustomerId()+"','"+c.getCustomerName()+"','"+c.getPhone()+"');";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	public void updateInDatabase(Customer c)
	{
		String query = "Update customer set customerName='"+c.getCustomerName()+"', phone = '"+c.getPhone()+"' WHERE customerId='"+c.getCustomerId()+"'";

		try
		{
			dbc.openConnection();
			dbc.st.executeUpdate(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	public void deleteFromDatabase(String customerId)
	{
		String query = "Delete from customer where customerId='"+customerId+"';";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception e){System.out.println(e.getMessage());}
	}
    public Customer searchCustomer(String customerId)
	{
		Customer customer = null;
		String query = "Select `customerName`, `phone` FROM `customer` WHERE `customerId`='"+customerId+"';";
		try
		{
			System.out.println(query);
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);

			while(dbc.result.next())
			{

				String customerName = dbc.result.getString("customerName");
				String phone = dbc.result.getString("phone");

				customer = new Customer();
				customer.setCustomerId(customerId);
				customer.setCustomerName(customerName);
				customer.setPhone(phone);
			}

		}
		catch(Exception ex){System.out.println(ex.getMessage());}
		dbc.closeConnection();
		return customer;
	}

}




