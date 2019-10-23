package Foursystem;

import org.omg.CORBA.INTERNAL;

import java.sql.*;
import java.util.Scanner;

public class ReturnBook extends Test{
    public Test operation() throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入您的读者号：");
        int readernumber = input.nextInt();
        String url = "jdbc:sqlserver://localhost:1433;DatabaseName=BookManage1;";
        Connection connection = DriverManager.getConnection(url, "sa", "lj000000");
        Statement statement = connection.createStatement();
        String sql = "SELECT * FROM BORROW WHERE ReaderNumber=" + readernumber + "";
        ResultSet rs = statement.executeQuery(sql);
        if(rs.next()==false){
            System.out.println("读者号不存在，请重新输入");
            return operation();
        }else{
            do {
                int ReaderNumber1 = rs.getInt("ReaderNumber");
                int BookNumber1 = rs.getInt("BookNumber");
                String GetDay1 = rs.getString("GetDay");
                int GetCount1 = rs.getInt("GetCount");
                String ReturnDay1 = rs.getString("ReturnDay");
                System.out.println("ReaderName" + ReaderNumber1 + "\tBookNumber" + BookNumber1 + "\tGetDay" + GetDay1 + "\tGetCount" + GetCount1 + "\tReturnDay" + ReturnDay1);
            }
            while (rs.next());
        }
        Statement statement1=connection.createStatement();
        String sql1="SELECT COUNT(ReaderNumber)dd FROM BORROW WHERE ReaderNumber="+readernumber+"";
        ResultSet count=statement1.executeQuery(sql1);
        count.next();
        int numbercount=count.getInt("dd");
        System.out.println("请输入您要删除的书号以及上方显示的借书时间：");
        int BookNumber=input.nextInt();
        String getday=input.next();
        Statement statement2=connection.createStatement();
        String sql2="DELETE FROM BORROW WHERE ReaderNumber="+readernumber+" AND GetDay='"+getday+"' AND BookNumber="+BookNumber+"";
        statement2.executeUpdate(sql2);
        Statement statement3=connection.createStatement();
        String sql3="SELECT COUNT(ReaderNumber)dd1 FROM BORROW WHERE ReaderNumber="+readernumber+"";
        ResultSet count1=statement3.executeQuery(sql3);
        count1.next();
        int numbercount1=count1.getInt("dd1");
        Statement statement4=connection.createStatement();
        String sql4="UPDATE READER SET BorrowCount="+numbercount1+" WHERE ReaderNumber="+readernumber+"";
        statement4.executeUpdate(sql4);
        Statement statement5=connection.createStatement();
        String sql5="UPDATE BOOK SET Count=Count+"+numbercount+"-"+numbercount1+" WHERE BookNumber="+BookNumber+"";
        statement5.executeUpdate(sql5);
        return null;
    }
}
