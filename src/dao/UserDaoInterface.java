package dao;
import java.io.IOException;
import java.sql.SQLException;

import model.*;
public interface UserDaoInterface
{
	public void signUp(User user) throws SQLException, ClassNotFoundException, IOException;
	public boolean loginUser(User user) throws ClassNotFoundException, SQLException, IOException;
}