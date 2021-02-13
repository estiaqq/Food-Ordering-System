package interfaces;

import java.lang.*;
import entity.*;

public interface IUser
{
	 void insertUser(User u);
	 void updateUser(User u);
	 void deleteUser(String userId);
	 User getUser(String userId, String password);
}