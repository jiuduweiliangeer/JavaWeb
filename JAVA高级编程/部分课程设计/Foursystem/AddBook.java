package Foursystem;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class AddBook extends BookMaintance{
    public Test operation1()throws SQLException{
        Scanner input=new Scanner(System.in);
        String url = "jdbc:sqlserver://localhost:1433;DatabaseName=BookManage1;";
        Connection connection = DriverManager.getConnection(url, "sa", "lj000000");
        System.out.println("请输入要添加图书的编号：");
        int BookNumber=input.nextInt();
        System.out.println("请输入要添加图书的书名:");
        String BookName=input.next();
        System.out.println("请输入要添加图书的出版社：");
        String Publish=input.next();
        System.out.println("请输入要添加图书的作者：");
        String Author=input.next();
        System.out.println("请输入要添加图书的价格：");
        String Price=input.next();
        System.out.println("请输入要添加图书的总量：");
        int Count=input.nextInt();
        Statement statement=connection.createStatement();
        String sql="INSERT INTO BOOK VALUES("+BookNumber+",'"+BookName+"','"+Publish+"','"+Author+"','"+Price+"',"+Count+")";
        statement.executeUpdate(sql);
        return null;
    }
}