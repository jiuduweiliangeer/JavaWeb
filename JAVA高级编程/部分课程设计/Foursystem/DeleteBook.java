package Foursystem;

import java.sql.*;
import java.util.Scanner;

public class DeleteBook extends BookMaintance{
    public Test operation1()throws SQLException{
        Scanner input=new Scanner(System.in);
        String url = "jdbc:sqlserver://localhost:1433;DatabaseName=BookManage1;";
        Connection connection = DriverManager.getConnection(url, "sa", "lj000000");
        System.out.println("请输入您要删除的图书号：");
        int BookNumber=input.nextInt();
        Statement statement=connection.createStatement();
        String sql="SELECT * FROM BORROW WHERE BookNumber="+BookNumber+"";
        ResultSet rs=statement.executeQuery(sql);
        if(rs.next()==false){
            Statement statement1=connection.createStatement();
            String sql1="DELETE FROM BOOK WHERE BookNumber="+BookNumber+"";
            statement1.executeUpdate(sql1);
        }else{
            System.out.println("还有图书被借阅中，不允许删除");
            System.out.println("是否继续删除其它图书（1.Y/2.N）：");
            int s=input.nextInt();
            if(s==1){
                return operation1();
            }else{
                System.exit(0);
            }
        }
        return null;
    }
}