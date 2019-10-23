package Foursystem;

import java.sql.*;

public class ManageJudge{
    public String ManageJudge()throws SQLException {
        String Judge=Test.Login();
        String url = "jdbc:sqlserver://localhost:1433;DatabaseName=BookManage1;";
        Connection connection = DriverManager.getConnection(url, "sa", "lj000000");
        Statement statement=connection.createStatement();
        String sql="SELECT IdentityUser FROM USERLOGIN WHERE UserName='"+Judge+"'";
        ResultSet rs=statement.executeQuery(sql);
        rs.next();
        System.out.println(rs.getString("IdentityUser"));
        return rs.getString("IdentityUser");
    }
}