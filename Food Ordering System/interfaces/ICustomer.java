package interfaces;

import java.lang.*;
import entity.*;

public interface ICustomer
{
	public void insertInDatabase(Customer c);
	public void updateInDatabase(Customer c);
	public void deleteFromDatabase(String customerId);
    public Customer searchCustomer(String customerId);
}