package Foursystem;

import java.sql.*;

public class Demo {
    public static User getUser(String UserName1,int Password1)throws SQLException {
        User user=null;
        try {
            String url = "jdbc:sqlserver://localhost:1433;DatabaseName=BookManage1;";
            Connection connection= DriverManager.getConnection(url, "sa", "lj000000");
            Statement statement=connection.createStatement();
            String sql="select*from USERLOGIN where UserName='"+UserName1+"'"+"and Password='"+Password1+"'";
            ResultSet resultSet=statement.executeQuery(sql);
            if(resultSet.next()){
                user=new User();
                user.setUserNumber(resultSet.getInt("UserNumber"));
                user.setUserName(resultSet.getString("UserName"));
                user.setPassword(resultSet.getInt("Password"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return user;
    }
}
