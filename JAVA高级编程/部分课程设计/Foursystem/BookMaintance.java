package Foursystem;

import java.sql.*;

public abstract class BookMaintance extends Test{
    public Test operation()throws SQLException{
        String url = "jdbc:sqlserver://localhost:1433;DatabaseName=BookManage1;";
        Connection connection = DriverManager.getConnection(url, "sa", "lj000000");
        Statement statement=connection.createStatement();
        String sql="SELECT * FROM BOOK";
        ResultSet rs=statement.executeQuery(sql);
        while(rs.next()){
            int BookNumber=rs.getInt("BookNumber");
            String BookName=rs.getString("BookName");
            String Publish=rs.getString("Publish");
            String Author=rs.getString("Author");
            String Price=rs.getString("Price");
            int Count=rs.getInt("Count");
            System.out.println("BookNumber"+BookNumber+"\tBookName"+BookName+"\tPublish"+Publish+"\tAuthor"+Author+"\tPrice"+Price+"\tCount"+Count);
        }
        return null;
    }
    public abstract Test operation1()throws SQLException;
}