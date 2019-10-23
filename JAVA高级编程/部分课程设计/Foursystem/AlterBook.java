package Foursystem;

import java.awt.print.Book;
import java.sql.*;
import java.util.Scanner;

public class AlterBook extends BookMaintance{
    public Test operation1()throws SQLException {
        Scanner input = new Scanner(System.in);
        String url = "jdbc:sqlserver://localhost:1433;DatabaseName=BookManage1;";
        Connection connection = DriverManager.getConnection(url, "sa", "lj000000");
        System.out.println("请输入您要修改的书籍号：");
        int BookNumber = input.nextInt();
        Statement statement10 = connection.createStatement();
        String sql10 = "SELECT * FROM BOOK WHERE BookNumber=" + BookNumber + "";
        ResultSet resultSet = statement10.executeQuery(sql10);
        if (resultSet.next() == false) {
            System.out.println("您输入的书籍号不存在");
            return operation1();
        } else {
            System.out.println("----------------------");
            System.out.println("请输入您要修改的内容代号：");
            System.out.println("1.BookNumber\n2.BookName\n3.Publush\n4.Author\n5.Price\n6.Count");
            int num = input.nextInt();
            switch (num) {
                case 1:
                    System.out.println("请输入修改后的书籍号：");
                    int booknumber = input.nextInt();
                    Statement statement = connection.createStatement();
                    String sql = "UPDATE BOOK SET BookNumber=" + booknumber + " WHERE BookNumber=" + BookNumber + "";
                    statement.executeUpdate(sql);
                    break;
                case 2:
                    System.out.println("请输入修改后的书名：");
                    String bookname = input.next();
                    Statement statement1 = connection.createStatement();
                    String sql1 = "UPDATE BOOK SET BookName='" + bookname + "'WHERE BookNumber=" + BookNumber + "";
                    statement1.executeUpdate(sql1);
                    break;
                case 3:
                    System.out.println("请输入修改后的出版社：");
                    String publish = input.next();
                    Statement statement2 = connection.createStatement();
                    String sql2 = "UPDATE BOOK SET Publish='" + publish + "'WHERE BookNumber=" + BookNumber + "";
                    statement2.executeUpdate(sql2);
                    break;
                case 4:
                    System.out.println("请输入修改后的作者：");
                    String author = input.next();
                    Statement statement3 = connection.createStatement();
                    String sql3 = "UPDATE BOOK SET Author='" + author + "'WHERE BookNumber=" + BookNumber + "";
                    statement3.executeUpdate(sql3);
                    break;
                case 5:
                    System.out.println("请输入修改后的价格：");
                    String price = input.next();
                    Statement statement4 = connection.createStatement();
                    String sql4 = "UPDATE BOOK SET Price='" + price + "'WHERE BookNumber=" + BookNumber + "";
                    statement4.executeUpdate(sql4);
                    break;
                case 6:
                    System.out.println("请输入修改后的库存量：");
                    int count = input.nextInt();
                    Statement statement5 = connection.createStatement();
                    String sql5 = "UPDATE BOOK SET Count=" + count + "WHERE BookNumber=" + BookNumber + "";
                    statement5.executeUpdate(sql5);
                    break;
            }
            return null;
        }
    }
}
