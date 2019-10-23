package Foursystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class AddReader extends ReaderMaintance{
    public Test operation2()throws SQLException {
        String url = "jdbc:sqlserver://localhost:1433;DatabaseName=BookManage1;";
        Connection connection = DriverManager.getConnection(url, "sa", "lj000000");
        Scanner input = new Scanner(System.in);
        System.out.println("请输入读者编号：");
        int ReaderNumber=input.nextInt();
        System.out.println("请输入读者姓名：");
        String ReaderName=input.next();
        System.out.println("请输入读者性别：");
        String Sex=input.next();
        System.out.println("请输入读者年龄：");
        int Age=input.nextInt();
        System.out.println("请输入读者职业：");
        String Occupation=input.next();
        Statement statement=connection.createStatement();
        String sql="INSERT INTO READER(ReaderNumber,ReaderName,Sex,Age,Occupation) VALUES("+ReaderNumber+",'"+ReaderName+"','"+Sex+"',"+Age+",'"+Occupation+"')";
        statement.executeUpdate(sql);
        return null;
    }
}