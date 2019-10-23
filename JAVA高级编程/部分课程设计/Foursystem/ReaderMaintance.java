package Foursystem;

import java.sql.*;
import java.util.Scanner;

public abstract class ReaderMaintance extends Test{
    public Test operation()throws SQLException{
        String url = "jdbc:sqlserver://localhost:1433;DatabaseName=BookManage1;";
        Connection connection = DriverManager.getConnection(url, "sa", "lj000000");
        Statement statement=connection.createStatement();
        String sql="SELECT * FROM READER";
        ResultSet rs=statement.executeQuery(sql);
        while(rs.next()){
            int ReaderNumber=rs.getInt("ReaderNumber");
            String ReaderName=rs.getString("ReaderName");
            String Sex=rs.getString("Sex");
            int Age=rs.getInt("Age");
            String Occupation=rs.getString("Occupation");
            int BorrowCount=rs.getInt("BorrowCount");
            String Finace=rs.getString("Finace");
            System.out.println("ReaderNumber"+ReaderNumber+"\tReaderName"+ReaderName+"\tSex"+Sex+"\tAge"+Age+"\tOccupation"+Occupation+"\tBorrowCount"+BorrowCount+"\tFinace"+Finace);
        }
        return null;
    }
    public abstract Test operation2()throws SQLException;
}
