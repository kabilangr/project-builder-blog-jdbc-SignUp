package dao;

import java.io.IOException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.*;

import model.User;
import utility.*;

public class UserDAO implements UserDaoInterface
{
	public void signUp(User user) throws SQLException, ClassNotFoundException, IOException
	{
		String name=user.getEmail();
		String pass=user.getPassword();
		Date date = Date.valueOf(user.getDate());
		ConnectionManager ob=new ConnectionManager();
		String sql="insert table u(email1,password1,dat)values(?,?)";
		PreparedStatement st=ob.getConnection().prepareStatement(sql);
		st.setString(1, name);
		st.setString(2, pass);
		st.setDate(3, date);
		ob.getConnection().close();
	}
	public boolean loginUser(User user) throws ClassNotFoundException, SQLException, IOException
	{
		ConnectionManager ob=new ConnectionManager();
		Statement st=ob.getConnection().createStatement();
		ResultSet rs=st.executeQuery("select * from u");
		while(rs.next())
		{
			if(((user.getEmail()).equals(rs.getString("email")))&&((user.getPassword()).equals(rs.getString("password"))))
				return true;
		}
		return false;
	}
}