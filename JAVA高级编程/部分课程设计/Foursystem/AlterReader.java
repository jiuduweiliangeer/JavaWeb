package Foursystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class AlterReader extends ReaderMaintance{
    public Test operation2()throws SQLException{
        String url = "jdbc:sqlserver://localhost:1433;DatabaseName=BookManage1;";
        Connection connection = DriverManager.getConnection(url, "sa", "lj000000");
        Scanner input = new Scanner(System.in);
        System.out.println("请输入您要修改的读者号：");
        int ReaderNumber=input.nextInt();
        System.out.println("------------------------");
        System.out.println("请输入您要修改的内容代号：");
        System.out.println("1.ReaderNumber（不可重复）\n2.ReaderName\n3.Sex\n4.Age\n5.Occupation");
        System.out.println("------------------------");
        int s=input.nextInt();
        switch (s){
            case 1:
                System.out.println("请输入更改后的读者号：");
                int readernumber=input.nextInt();
                Statement statement=connection.createStatement();
                String sql1="UPDATE READER SET ReaderNumber="+readernumber+" WHERE ReaderNumber="+ReaderNumber+"";
                statement.executeUpdate(sql1);
                break;
            case 2:
                System.out.println("请输入更改后的读者姓名：");
                String readername=input.next();
                Statement statement1=connection.createStatement();
                String sql2="UPDATE READER SET ReaderName='"+readername+"' WHERE ReaderNumber="+ReaderNumber+"";
                statement1.executeUpdate(sql2);
                break;
            case 3:
                System.out.println("请输入更改后的读者性别：");
                String sex=input.next();
                Statement statement2=connection.createStatement();
                String sql3="UPDATE READER SET Sex='"+sex+"' WHERE ReaderNumber="+ReaderNumber+"";
                statement2.executeUpdate(sql3);
                break;
            case 4:
                System.out.println("请输入更改后的年龄：");
                int age=input.nextInt();
                Statement statement3=connection.createStatement();
                String sql4="UPDATE READER SET Age="+age+" WHERE ReaderNumber="+ReaderNumber+"";
                statement3.executeUpdate(sql4);
                break;
            case 5:
                System.out.println("请输入更改后的职业：");
                String occupation=input.next();
                Statement statement4=connection.createStatement();
                String sql5="UPDATE READER SET Occupation='"+occupation+"' WHERE ReaderNumber="+ReaderNumber+"";
                statement4.executeUpdate(sql5);
                break;
        }
        return null;
    }
}