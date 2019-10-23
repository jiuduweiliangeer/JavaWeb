package Foursystem;

import java.sql.*;
import java.util.Scanner;

public class DeleteReader extends ReaderMaintance{
    public Test operation2()throws SQLException{
        String url = "jdbc:sqlserver://localhost:1433;DatabaseName=BookManage1;";
        Connection connection = DriverManager.getConnection(url, "sa", "lj000000");
        Scanner input = new Scanner(System.in);
        System.out.println("请输入您要删除的读者号：");
        int ReaderNumber=input.nextInt();
        Statement statement=connection.createStatement();
        String sql="SELECT ReaderNumber FROM BORROW WHERE ReaderNumber="+ReaderNumber+"";
        ResultSet rs=statement.executeQuery(sql);
        if(rs.next()==false){
            Statement statement1=connection.createStatement();
            String sql1="DELETE FROM READER WHERE ReaderNumber="+ReaderNumber+"";
            statement1.executeUpdate(sql1);
        }else{
            System.out.println("该读者还有图书借阅中，不允许删除");
            System.out.println("是否继续删除其它读者（1.Y/2.N）：");
            int s=input.nextInt();
            if(s==1){
                return operation2();
            }else{
                System.exit(0);
            }

        }
        return null;
    }
}