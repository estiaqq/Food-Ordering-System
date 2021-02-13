package interfaces;

import java.lang.*;
import entity.*;

public interface IEmployee
{
	public void insertInDatabase(Employee e);
	public void updateInDatabase(Employee e);
	public void deleteFromDatabase(String employeeId);
	public Employee searchEmployee(String employeeId);

}