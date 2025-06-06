package com.railway.dao;
import java.sql.*;
import com.railway.bean.RegisterBean;
public class RailwayCrossingDao {
public static Connection con=getCon();
public static PreparedStatement ps;
public static ResultSet rs;
public static Connection getCon()
{
try
	{
 Class.forName("com.mysql.cj.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
}
catch(ClassNotFoundException cnf)
{
}
catch(SQLException sql)
{
}
return con;
}
public static String register(RegisterBean rb)
{
int i=0;
try
	{
 ps=con.prepareStatement("insert into register values(?,?,?)");
ps.setString(1,rb.getName());
ps.setString(2, rb.getEmail());
ps.setString(3, rb.getPassword());
i=ps.executeUpdate();
if(i==1)
{
return "SUCCESS";
}
else
 {
 return "FAIL";
}
}
catch(SQLException sql)
{
}
return null;
}
public static String checkLogin(String email,String pass)
{
try
	{
 ps=con.prepareStatement("select * from register where email=? and password=?");
ps.setString(1, email);
ps.setString(2, pass);
rs=ps.executeQuery();
if(rs.next())
{
return "Valid";
}
else
 {
 return "Invalid";
}
}
catch(SQLException sql)
{
}
return null;
}











}